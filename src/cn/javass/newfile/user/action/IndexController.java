package cn.javass.newfile.user.action;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.javass.newfile.newmsg.cache.NewMsgCache;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.util.DateUtil;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxEntity;

@Controller("indexController")
public class IndexController
{
	private Map<String,AjaxEntity> mapAjaxEnt = new HashMap<String,AjaxEntity>();
	
	//2012-12-22 17:25:29
	
	@Autowired
	@Qualifier("NewService")
	private NewService newService;
	
	@RequestMapping(value = "/index")
	public String index(ModelMap model) throws Exception
	{
		NewMsgCache newMsg = NewMsgCache.getInstance();
		List<?> listSearch = newMsg.listNews("indexMsg");
		if(listSearch == null)
		{
			String nowDate = DateUtil.timeToString(new Date(), "yyyy-MM-dd HH");
			String todayDate = DateUtil.timeToString(new Date(), "yyyy-MM-dd");
			todayDate = todayDate + " 00";
			String HQL_SELE_NEWS_BY_CREATEDATE = "from NewsEntity n where n.downDate BETWEEN '"+todayDate+"' and '"+nowDate+"' order by n.downDate desc";
			listSearch = newService.listAll(HQL_SELE_NEWS_BY_CREATEDATE);
			newMsg.putMsgList("indexMsg", listSearch);
		}
		model.addAttribute("listNewMsg", listSearch);
		return "newMsg/index";
	//	return "user/list";
	}
	@RequestMapping(value = "/user/listUser")
	public String userL(ModelMap model)
	{
		return "user/list";
	}
	
	
	@RequestMapping(value = "/freemarker")
	public String indexFree(ModelMap model) throws Exception
	{
		model.put("name", "My First Spring Mvc");
		return "index";
	}
	@RequestMapping(value = "/lezaigocode", method = { RequestMethod.POST })
	public void lezaigoCode(@ModelAttribute("command") @Valid AjaxEntity ajaxVal,HttpServletResponse response,HttpServletRequest request)
	{
		String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kaptchaExpected.equalsIgnoreCase(ajaxVal.getValidateValue()))
		{
			ajaxVal.setResult(true);
		}else
		{
			ajaxVal.setResult(false);
		}
		mapAjaxEnt.put("jsonValidateReturn", ajaxVal);
		WriteJson.returnJson(response, mapAjaxEnt);
	}

}
