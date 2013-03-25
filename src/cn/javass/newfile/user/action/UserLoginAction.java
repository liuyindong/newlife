package cn.javass.newfile.user.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.service.UserService;
import cn.javass.util.DateUtil;
import cn.javass.util.LdUtils;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxEntity;
import cn.javass.util.ajax.AjaxUtil;

@Controller
@SessionAttributes("user")
public class UserLoginAction
{
	private Logger logger = LoggerFactory.getLogger(UserLoginAction.class);
	
	AjaxUtil ajaxUtil = new AjaxUtil();
	
	private Map<String,AjaxEntity> mapAjaxEnt = new HashMap<String,AjaxEntity>();
	
	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	@RequestMapping(value = "/user/login", method = { RequestMethod.POST })
	public void userLogin(HttpServletRequest request, ModelMap modelMap,HttpServletResponse response)
	{
		String loginModel = request.getParameter("loginMod");
		try
		{
			UserModel user = userService.userLogin(loginModel);

			if (null != user)
			{
				modelMap.put("user", user);

				ajaxUtil.setResult(true);
			}
			else
			{
				ajaxUtil.setFailMsg(LdUtils.LOGIN_MSG);
			}
		}
		catch (Exception e)
		{
			logger.error("登陆出现异常:"+e);
			ajaxUtil.setFailMsg(LdUtils.FIAL_MSG);
		}
		WriteJson.returnJson(response, ajaxUtil);
	}
	@RequestMapping(value = "/user/toregistration", method = { RequestMethod.GET })
	public String userToRegistration()
	{
		return "newMsg/registration";
	}
	@RequestMapping(value = "/user/registration", method = { RequestMethod.POST })
	public String userRegisTration(ModelMap modelMap, @ModelAttribute("command") @Valid UserModel user)
	{
		user.setCreatedate(DateUtil.timeToString(new Date()));
		userService.save(user);
		modelMap.put("user", user);
		return "redirect:/index";
	}
	@RequestMapping(value = "/user/emailIsRegis", method = { RequestMethod.POST })
	public void emailIsRegis( @ModelAttribute("command") @Valid AjaxEntity ajaxVal,HttpServletResponse response)
	{
		UserModel isEmail = userService.userIsExtis(ajaxVal.getValidateValue());
		if(isEmail != null)
		{
			ajaxVal.setResult(false);
			
		}else
		{
			ajaxVal.setResult(true);
		}
		mapAjaxEnt.put("jsonValidateReturn", ajaxVal);
		WriteJson.returnJson(response, mapAjaxEnt);
	}
}
