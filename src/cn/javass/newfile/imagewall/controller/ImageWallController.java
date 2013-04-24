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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;

import cn.javass.DTO.ImageWallDTO;
import cn.javass.common.Constants;
import cn.javass.common.pagination.Page;
import cn.javass.newfile.comment.service.CommentService;
import cn.javass.newfile.imagewall.DTO.ImageWallShowDTO;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.imagewall.entity.ImgWallLoveEntity;
import cn.javass.newfile.imagewall.entity.ImgWallShowEntity;
import cn.javass.newfile.imagewall.service.ImageWallService;
import cn.javass.newfile.imagewall.service.ImgWallLoveService;
import cn.javass.newfile.imagewall.service.ImgWallShowService;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.spring.mvc.bind.annotation.RequestJsonParam;
import cn.javass.sql.CommentHql;
import cn.javass.util.Ai2YCOM;
import cn.javass.util.DateUtil;
import cn.javass.util.ImageCut;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxUtil;

@Controller
@RequestMapping("/imageWall")
@SessionAttributes(Constants.USER_SESSION)
public class ImageWallController
{
	// 喜欢数
	private final String HQL_IMGWL_LOVE = " where imageWallId = ? and status = 0";

	private final String HQL_IMGWAL_LOVE_IW_UI = " where imageWallId = ? and userId = ? and status = 0";

	private final String HQL_IMGWALL_SHOW_BY_WALL_ID = " where pertainWallId = ?";

	private static final String SQL_CLICK_NUM_ADDONE = "update tbl_image_wall set click_num=click_num+1 where id = ?";

	@Autowired
	@Qualifier("ImageWallService")
	private ImageWallService imageWallService;

	@Autowired
	@Qualifier("ImgWallLoveService")
	private ImgWallLoveService imgWallLoveService;

	@Autowired
	@Qualifier("ImgWallShowService")
	private ImgWallShowService imgWallShowService;

	@Autowired
	@Qualifier("CommentService")
	private CommentService commentService;

	private HttpServletRequest request;

	private HttpSession session;

	@ModelAttribute
	public void initModel(Model model, HttpServletRequest request, HttpSession session)
	{
		model.addAttribute("tab", "imagewall"); // 当前 Tab: 图片墙
		this.request = request;
		this.session = session;
	}

	/**
	 * ajax图片内容
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/imageWallDate")
	@ResponseBody
	public Object imageWallDate(Model model)
	{
		// http://ld:8080/newlife/imageWall/index?pn=3&id=285
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(this.request, "pn", 1);
		Integer id = ServletRequestUtils.getIntParameter(this.request, "id", -1);
		boolean pre = ServletRequestUtils.getBooleanParameter(this.request, "pre", false);
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
	@RequestMapping(value = "/imageWallDateJsp.html")
	public String imageWallDateJsp(Model model)
	{
		// http://ld:8080/newlife/imageWall/index?pn=3&id=285
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(this.request, "pn", 1);
		Page<ImageWallEntity> page = null;
		page = imageWallService.listAll(pn, 10);

		List<ImageWallDTO> listImgWallDto = new ArrayList<ImageWallDTO>();

		UserModel user = (UserModel) this.session.getAttribute(Constants.USER_SESSION);

		for (Iterator<ImageWallEntity> iterator = page.getItems().iterator(); iterator.hasNext();)
		{
			ImageWallEntity imageWall = iterator.next();
			ImageWallDTO imageWallDTO = new ImageWallDTO();
			imageWallDTO.setFilePath(imageWall.getFilePath());
			imageWallDTO.setId(imageWall.getId());
			imageWallDTO.setCommentList(commentService.listAll(CommentHql.HQL_COMMENT_TOP_TRHEE, null, 1, 3, 1, imageWall.getId()));
			imageWallDTO.setCommentNum(commentService.countAll(CommentHql.HQL_COMMENT_COUNT, 1, imageWall.getId()));
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
	public Object imgWallLove(@RequestJsonParam(value = "model", required = true) ImgWallLoveEntity imageWallLove)
	{
		UserModel user = (UserModel) this.session.getAttribute(Constants.USER_SESSION);

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
			ajax.setFailMsg(Ai2YCOM.FAIL_MSG);
		}
		return ajax;
	}

	@RequestMapping(value = "/showImgWall_{id}.html")
	public String showImgWall(@PathVariable Integer id, Model model)
	{
		List<ImgWallShowEntity> imageWall = imgWallShowService.listAll(HQL_IMGWALL_SHOW_BY_WALL_ID, id);
		StringBuilder sb = new StringBuilder();
		
		imageWallService.updateSqlOne(SQL_CLICK_NUM_ADDONE, id);
		model.addAttribute("showImgList", imageWall);
		model.addAttribute("imagewall", imageWallService.get(id));
		return "imageWall/picwall";//showimgwall
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
	public void showImg(HttpServletResponse response)
	{
		int wallId = ServletRequestUtils.getIntParameter(this.request, "imgioc", 1);
		ImageWallEntity imgwall = imageWallService.get(wallId);
		try
		{
			WriteJson.returnImg(this.request, response, imgwall.getFilePath());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/addImgWall")
	public void addImgWall() throws Exception
	{
		String path = "D:\\Workspaces\\eclipseword\\newlife\\WebContent\\girl";

		File[] files1 = fileC(path);
		for (File file1 : files1)
		{

			if (file1.isDirectory())
			{
				ImageWallEntity iw = null;
				File[] files2 = fileC(file1.getPath());
				for (File file2 : files2)
				{
					if (!file2.isDirectory())
					{
						System.out.println(file2.getName());
						iw = new ImageWallEntity();

						iw.setContent(file1.getName());
						iw.setCreateDate(DateUtil.timeNow());
						iw.setFilePath(file2.getPath().substring(path.length() - 5).replaceAll("\\\\","/"));
						iw.setName(file2.getName());
						iw.setTitle(file1.getName());
						int[] handh = null ;
						try
						{
							handh = ImageCut.getImgHeightAndWidth(file2.getPath());
						}
						catch (Exception e)
						{
							handh[0] = 0;
							handh[1] = 0;
							System.out.println(file2.getPath());
						}
						iw.setImgWidth(handh[0]);
						iw.setImgHeight(handh[1]);

						imageWallService.save(iw);
						continue;
					}
					File[] files3 = fileC(file2.getPath());
					for (File file3 : files3)
					{
						if (!file3.isDirectory())
						{
							ImgWallShowEntity is = new ImgWallShowEntity();
							is.setCreateDate(DateUtil.timeNow());
							is.setDirections(file1.getName());
							is.setFilePaths(file3.getPath().substring(path.length() - 5).replaceAll("\\\\","/"));
							is.setName(file3.getName());
							is.setFilePath(file3.getParent().substring(path.length() - 5).replaceAll("\\\\","/"));
							is.setPertainWallId(iw.getId());
							int[] handh = null ;
							try
							{
								handh = ImageCut.getImgHeightAndWidth(file3.getPath());
							}
							catch (Exception e)
							{
								handh[0] = 0;
								handh[1] = 0;
								System.out.println(file3.getPath());
							}
							is.setImgWidth(handh[0]);
							is.setImgHeight(handh[1]);
							
							imgWallShowService.save(is);
							ImageCut.scale(file3.getPath(), file3.getParent() + "/thumbnails/" + file3.getName(), 105, 69);
							
						}
					}
				}
			}
		}
	}

	public static void main(String[] args)
	{
		
		
		
		
		/*String path = "D:\\2013\\美女";

		File[] files1 = fileC(path);
		for (File file1 : files1)
		{

			if (file1.isDirectory())
			{
				ImageWallEntity iw = null;
				File[] files2 = fileC(file1.getPath());
				for (File file2 : files2)
				{
					if (file2.isDirectory())
					{
						File[] files3 = fileC(file2.getPath());
						for (File file3 : files3)
						{
							if (!file3.isDirectory())
							{
						//		WritePath.delDir(file3.getParent() + "/thumbnails/");
								
								ImageCut.scale(file3.getPath(), file3.getParent() + "/thumbnails/" + file3.getName(), 105, 69);
								
								System.out.println(file3.getParent() + "/thumbnails/" + file3.getName());
							}
						}
					}
					
				}
			}
		}*/
	}

	public static File[] fileC(String path)
	{
		return new File(path).listFiles();
	}
}