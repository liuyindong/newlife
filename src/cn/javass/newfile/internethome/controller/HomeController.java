package cn.javass.newfile.internethome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.javass.DTO.HomeInformationDTO;
import cn.javass.cache.ObjectCache;
import cn.javass.common.Constants;
import cn.javass.common.pagination.Page;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;
import cn.javass.newfile.internethome.service.InternetScrollService;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.sql.InternetHomeSql;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxEntity;

@Controller
public class HomeController
{
	private Map<String, AjaxEntity> mapAjaxEnt = new HashMap<String, AjaxEntity>();

	private List<Object> list;

	// 查询今天首页推荐的信息的信息

	// 2012-12-22 17:25:29

	@Autowired
	@Qualifier("NewService")
	private NewService newService;

	@Autowired
	@Qualifier("InternetScrollService")
	private InternetScrollService internetScrollService;

	@RequestMapping(value = "/index")
	public String index(ModelMap model, HttpServletRequest request) throws Exception
	{
		HomeInformationDTO homeInformation = new HomeInformationDTO();
		// 查询首页缓存内容（缓存为12个小时）
		ObjectCache homeScroll = ObjectCache.getInstance("internetHome", 43200);
		List<?> listScroll = homeScroll.listNews();

		if (listScroll == null)
		{
			List<InternetScrollEntity> listScrollTop = internetScrollService.listAll(InternetHomeSql.HQL_INTERNET_SCROLL_BY_TYPE, 1);
			List<InternetScrollEntity> listScrollButton = internetScrollService.listAll(InternetHomeSql.HQL_INTERNET_SCROLL_BY_TYPE, 2);
			homeInformation.setScrollTop(listScrollTop);
			homeInformation.setScrollButton(listScrollButton);
			list = new ArrayList<Object>();
			list.add(homeInformation);
			homeScroll.putMsgList(list);
		}
		
		// 查询首页缓存新闻（缓存为30分钟）
	//	ObjectCache indexPageObj = ObjectCache.getInstance("homepages", 1800);
		
	//	List<?> listpages = indexPageObj.listNews();
		
		Page<NewsEntity> page = null;
		
	//	if(listpages.size() > 0)
	//	{
	//		page = (Page<NewsEntity>) listpages.get(0);
	//	}
		
		model.addAttribute(Constants.COMMAND, new ImageWallEntity());
		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
		boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
		
	//	if (page == null && pn == 1)
	//	{
			
			if (id > 0)
			{
				if (pre)
				{
					page = newService.pre(id, pn);
				}
				else
				{
					page = newService.next(id, pn);
				}
			}
			else
			{
				page = newService.listAll(pn);
			}
		//	list = new ArrayList<Object>();
		//	list.add(page);
		//	indexPageObj.putMsgList(list);
		//}

		model.addAttribute("page", page);
		model.addAttribute("homeInformation", homeInformation);
		return "newMsg/index";
	}

	@RequestMapping(value = "/freemarker")
	public String indexFree(ModelMap model) throws Exception
	{
		model.put("name", "My First Spring Mvc");
		return "index";
	}

	@RequestMapping(value = "/lezaigocode", method = { RequestMethod.POST })
	public void lezaigoCode(@ModelAttribute("command") @Valid AjaxEntity ajaxVal, HttpServletResponse response, HttpServletRequest request)
	{
		String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (kaptchaExpected.equalsIgnoreCase(ajaxVal.getValidateValue()))
		{
			ajaxVal.setResult(true);
		}
		else
		{
			ajaxVal.setResult(false);
		}
		mapAjaxEnt.put("jsonValidateReturn", ajaxVal);
		WriteJson.returnJson(response, mapAjaxEnt);
	}

}
