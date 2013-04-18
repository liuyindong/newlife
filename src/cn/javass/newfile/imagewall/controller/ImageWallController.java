package cn.javass.newfile.imagewall.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.javass.DTO.ImageWallDTO;
import cn.javass.common.Constants;
import cn.javass.common.pagination.Page;
import cn.javass.newfile.imagewall.entity.ImageWallCommentEntity;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.imagewall.entity.ImgWallLoveEntity;
import cn.javass.newfile.imagewall.service.ImageWallCommentService;
import cn.javass.newfile.imagewall.service.ImageWallService;
import cn.javass.newfile.imagewall.service.ImgWallLoveService;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.spring.mvc.bind.annotation.RequestJsonParam;
import cn.javass.util.DateUtil;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxUtil;

@Controller
@RequestMapping("/imageWall")
@SessionAttributes(Constants.USER_SESSION)
public class ImageWallController
{
	// 查询前3条评论
	private final String HQL_SEL_IMG_WALL_COMMENT = "from ImageWallCommentEntity where imageWallId = ?";
	// 评论数
	private final String HQL_COMMENT_NUM = "select count(id) from ImageWallCommentEntity where imageWallId = ?";
	// 喜欢数
	private final String HQL_IMGWL_LOVE = "select count(id) from ImgWallLoveEntity where imageWallId = ? and status = 0";

	private final String HQL_IMGWAL_LOVE_IW_UI = "from ImgWallLoveEntity where imageWallId = ? and userId = ? and status = 0";

	@Autowired
	@Qualifier("ImageWallService")
	private ImageWallService imageWallService;

	@Autowired
	@Qualifier("ImageWallCommentService")
	private ImageWallCommentService imageWallCommentService;

	@Autowired
	@Qualifier("ImgWallLoveService")
	private ImgWallLoveService imgWallLoveService;

	/**
	 * ajax图片内容
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/imageWallDate")
	@ResponseBody
	public Object imageWallDate(Model model, HttpServletRequest request)
	{
		// http://ld:8080/newlife/imageWall/index?pn=3&id=285
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
		boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
		Page<ImageWallEntity> page = null;
		if (id > 0)
		{
			if (pre)
			{
				page = imageWallService.pre(id, pn);
			}
			else
			{
				page = imageWallService.next(id, pn);
			}
		}
		else
		{
			page = imageWallService.listAll(pn);
		}

		return page;
	}

	/**
	 * jsp图片墙
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/imageWallDateJsp")
	public String imageWallDateJsp(Model model, HttpServletRequest request, HttpSession session)
	{
		// http://ld:8080/newlife/imageWall/index?pn=3&id=285
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Page<ImageWallEntity> page = null;
		page = imageWallService.listAll(pn, 10);

		List<ImageWallDTO> listImgWallDto = new ArrayList<ImageWallDTO>();

		UserModel user = (UserModel) session.getAttribute(Constants.USER_SESSION);

		for (Iterator<ImageWallEntity> iterator = page.getItems().iterator(); iterator.hasNext();)
		{
			ImageWallEntity imageWall = iterator.next();
			ImageWallDTO imageWallDTO = new ImageWallDTO();
			imageWallDTO.setFilePath(imageWall.getFilePath());
			imageWallDTO.setId(imageWall.getId());
			imageWallDTO.setListWallComment(imageWallCommentService.listAll(HQL_SEL_IMG_WALL_COMMENT, 1, 3, imageWall.getId()));
			imageWallDTO.setCommentNum(imageWallCommentService.countAll(HQL_COMMENT_NUM, imageWall.getId()));
			imageWallDTO.setLoveNum(imgWallLoveService.countAll(HQL_IMGWL_LOVE, imageWall.getId()));
			if (user != null)
			{
				ImgWallLoveEntity isImgWall = imgWallLoveService.JudgeIsExist(HQL_IMGWAL_LOVE_IW_UI, imageWall.getId(), user.getId());
				if (isImgWall != null)
				{
					imageWallDTO.setUserIsLoveWall(true);
				}
			}
			imageWallDTO.setName(imageWall.getName());
			imageWallDTO.setTitle(imageWall.getTitle());
			listImgWallDto.add(imageWallDTO);
		}
		model.addAttribute("listImgWall", listImgWallDto);

		if (pn == 1)
		{
			return "imageWall/imageWalls";
		}
		return "imageWall/masonryLoad";
	}

	@RequestMapping(value = "/imgWallLove", method = { RequestMethod.POST })
	@ResponseBody
	public Object imgWallLove(HttpSession session, @RequestJsonParam(value = "model", required = true) ImgWallLoveEntity imageWallLove)
	{
		UserModel user = (UserModel) session.getAttribute(Constants.USER_SESSION);

		AjaxUtil ajax = new AjaxUtil();

		try
		{
			if (user != null)
			{
				ImgWallLoveEntity isImgWall = imgWallLoveService.JudgeIsExist(HQL_IMGWAL_LOVE_IW_UI, imageWallLove.getImageWallId(), user.getId());
				if (isImgWall == null)
				{
					imageWallLove.setCreateDate(DateUtil.timeToString(new Date()));
					imageWallLove.setUserId(user.getId());
					imgWallLoveService.save(imageWallLove);
					ajax.setJsonValidateReturn("1");
				}
				else
				{
					imgWallLoveService.delete(isImgWall.getId());
					ajax.setJsonValidateReturn("0");
				}
				ajax.setResult(true);
			}
		}
		catch (Exception e)
		{
			ajax.setFailMsg("服务器异常请稍后再试...");
		}
		return ajax;
	}

	@RequestMapping("/imgWallComment")
	@ResponseBody
	public Object imageWallComment(HttpSession session, @RequestJsonParam(value = "model", required = true) ImageWallCommentEntity imgWallComment)
	{
		UserModel user = (UserModel) session.getAttribute(Constants.USER_SESSION);
		AjaxUtil ajaxUtil = new AjaxUtil();
		if (user == null)
		{
			ajaxUtil.setFailMsg("请登陆...");
			ajaxUtil.setResult(false);
		}
		else
		{
			ajaxUtil.setResult(true);
			imgWallComment.setUser(user);
			imageWallCommentService.save(imgWallComment);
		}
		return ajaxUtil;
	}

	@RequestMapping(value = "/index")
	public String imageIndex()
	{
		return "imageWall/imageWall";
	}

	@RequestMapping(value = "/indexs")
	public String imageIndexs()
	{
		return "imageWall/imageWalls";
	}

	@RequestMapping(value = "/showImg")
	public void showImg(HttpServletRequest request, HttpServletResponse response)
	{
		int wallId = ServletRequestUtils.getIntParameter(request, "imgioc", 1);
		ImageWallEntity imgwall = imageWallService.get(wallId);
		try
		{
			WriteJson.returnImg(request, response, imgwall.getFilePath());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/addImgWall")
	public void addImgWall(HttpServletRequest request) throws Exception
	{
		String path = "D:\\2013\\04\\美女";
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			if (files[i].isDirectory())
			{
				ImageWallEntity iw = new ImageWallEntity();
				iw.setContent(files[i].getPath());
				iw.setCreateDate(DateUtil.timeToString(new Date()));
				iw.setFilePath(files[i].getPath());
				iw.setTitle(files[i].getPath());
				imageWallService.save(iw);
			}
		}
	}
}