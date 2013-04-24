package cn.javass.newfile.user.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.service.UserService;
import cn.javass.util.CookieUtil;
import cn.javass.util.DateUtil;
import cn.javass.util.LdUtils;
import cn.javass.util.MD5Util;
import cn.javass.util.WriteJson;
import cn.javass.util.ajax.AjaxEntity;
import cn.javass.util.ajax.AjaxUtil;

@Controller
@SessionAttributes(LdUtils.SESSION_USER)
public class UserLoginAction
{
	private Logger logger = LoggerFactory.getLogger(UserLoginAction.class);

	AjaxUtil ajaxUtil = new AjaxUtil();

	private Map<String, AjaxEntity> mapAjaxEnt = new HashMap<String, AjaxEntity>();

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	private HttpServletRequest request;

	@ModelAttribute
	public void initModel(Model model, HttpServletRequest request)
	{
		this.request = request;
	}

	@RequestMapping(value = "/user/login", method = { RequestMethod.POST })
	public void userLogin(ModelMap modelMap, HttpServletResponse response, Integer isRemember, String loginMod)
	{
		try
		{
			String[] userlogin = loginMod.split("/");

			userlogin[1] = MD5Util.md5(userlogin[1]);

			UserModel user = userService.userLogin(userlogin[0], userlogin[1]);

			if (null != user)
			{
				if (isRemember == 1)
				{
					Cookie cookie = new Cookie(LdUtils.COOKIE_USER, userlogin[0] + "/" + userlogin[1]);
					cookie.setMaxAge(7 * 24 * 60 * 60 * 1000);
					cookie.setPath("/");
					response.addCookie(cookie);
				}

				modelMap.put(LdUtils.SESSION_USER, user);

				ajaxUtil.setResult(true);
			}
			else
			{
				ajaxUtil.setFailMsg(LdUtils.LOGIN_MSG);
			}
		}
		catch (Exception e)
		{
			logger.error("登陆出现异常:" + e);
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
		modelMap.put(LdUtils.SESSION_USER, user);
		return "redirect:/index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletResponse response)
	{
		CookieUtil.delCookie(LdUtils.COOKIE_USER);

		// 清除session
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements())
		{
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		request.getSession().invalidate();

		// 获取项目真实路径
		String path = request.getContextPath();
		// 拼接跳转页面路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		// 刷新页面
		String str = "<script>top.location='" + basePath + "'</script>";
		System.out.println(str);
		responseTxt(response, str);
	}

	// 返回前台页面ajax
	protected void responseTxt(HttpServletResponse response, String str)
	{
		try
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(str);
			out.flush();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/user/emailIsRegis", method = { RequestMethod.POST })
	public void emailIsRegis(@ModelAttribute("command") @Valid AjaxEntity ajaxVal, HttpServletResponse response)
	{
		UserModel isEmail = userService.userIsExtis(ajaxVal.getValidateValue());
		if (isEmail != null)
		{
			ajaxVal.setResult(false);

		}
		else
		{
			ajaxVal.setResult(true);
		}
		mapAjaxEnt.put("jsonValidateReturn", ajaxVal);
		WriteJson.returnJson(response, mapAjaxEnt);
	}
}
