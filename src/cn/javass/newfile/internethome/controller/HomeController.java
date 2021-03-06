package cn.javass.newfile.internethome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.javass.DTO.HomeInformationDTO;
import cn.javass.cache.ObjectCache;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;
import cn.javass.newfile.internethome.service.InternetScrollService;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.newfile.user.service.UserService;
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
	
	private HttpServletRequest request;
	private HttpSession session;

	@Autowired
	@Qualifier("NewService")
	private NewService newService;

	@Autowired
	@Qualifier("InternetScrollService")
	private InternetScrollService internetScrollService;
	
	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	
	@ModelAttribute
	public void initModel(Model model, HttpServletRequest request,HttpSession session)
	{
		model.addAttribute("tab", "home"); // 当前 Tab: 用户中心
		this.request = request;
		this.session = session;
	}

	@RequestMapping(value = "/index")
	public String index(ModelMap model) throws Exception
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

			List<NewsEntity> listNewsYaoW = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE, null, 6, 1,1); // 要闻
			for (Iterator<NewsEntity> iterator = listNewsYaoW.iterator(); iterator.hasNext();)
			{
				NewsEntity newsEntity = iterator.next();
				if(newsEntity.getTitle().length() > 18)
				{
					newsEntity.setTitle(newsEntity.getTitle().substring(0,17) + "...");
				}
			}
			List<NewsEntity> listNewsYdhl = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 2); // 移动互联
			List<NewsEntity> listNewsDzsw = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 3); // 电子商务
			List<NewsEntity> listNewsSjwl = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 4); // 社交网络
			List<NewsEntity> listNewsWlyx = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 5); // 网络游戏
			List<NewsEntity> listNewsIt = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 6); // it
			List<NewsEntity> listNewsSm = newService.listAll(InternetHomeSql.HQL_NEWS_BY_TYPE,null, 1, 5, 7); // 数码

			homeInformation.setListNewsYaoW(listNewsYaoW);
			homeInformation.setListNewsYdhl(listNewsYdhl);
			homeInformation.setListNewsDzsw(listNewsDzsw);
			homeInformation.setListNewsSjwl(listNewsSjwl);
			homeInformation.setListNewsWlyx(listNewsWlyx);
			homeInformation.setListNewsIt(listNewsIt);
			homeInformation.setListNewsSm(listNewsSm);

			list.add(homeInformation);
			homeScroll.putMsgList(list);
		}else
		{
			homeInformation = (HomeInformationDTO) listScroll.get(0);
		}
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
	public void lezaigoCode(@ModelAttribute("command") @Valid AjaxEntity ajaxVal, HttpServletResponse response)
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
