package cn.javass.newfile.imagewall.controller;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.javass.common.Constants;
import cn.javass.common.pagination.Page;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.imagewall.service.ImageWallService;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.DateUtil;
import cn.javass.util.WriteJson;

@Controller
@RequestMapping("/imageWall")
public class ImageWallController
{
	@Autowired
	@Qualifier("ImageWallService")
	private ImageWallService imageWallService;
	
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

	@RequestMapping(value = "/imageWallDateJsp")
	public String imageWallDateJsp(Model model, HttpServletRequest request)
	{
		// http://ld:8080/newlife/imageWall/index?pn=3&id=285
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Page<ImageWallEntity> page = null;
		page = imageWallService.listAll(pn);
		
		for (Iterator<ImageWallEntity> iterator = page.getItems().iterator(); iterator.hasNext();)
		{
			ImageWallEntity imgWall = iterator.next();
			if(imgWall.getTitle().length() > 24)
			{
				imgWall.setTitle(imgWall.getTitle().substring(0,24) + "...");
			}
		}

		model.addAttribute("page", page);

		if (pn == 1)
		{
			return "imageWall/imageWalls";
		}
		return "imageWall/masonryLoad";
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
			if(files[i].isDirectory())
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