package cn.javass.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.service.UserService;
import cn.javass.util.CookieUtil;
import cn.javass.util.LdUtils;

@Repository
public class Interceptor implements HandlerInterceptor
{

	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	/**
	 * 在Controller方法后进行拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception
	{

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception
	{

	}

	/**
	 * 在Controller方法前进行拦截
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception
	{
		if(request.getSession().getAttribute(LdUtils.SESSION_USER) == null)
		{
			Cookie cookie = CookieUtil.getCookieByName(request, LdUtils.COOKIE_USER);

			if (cookie != null)
			{
				String[] usermsg = cookie.getValue().split("/");
				UserModel user = userService.userLogin(usermsg[0], usermsg[1]);
				if (user != null)
				{
					request.getSession().setAttribute(LdUtils.SESSION_USER, user);
				}else
				{
					CookieUtil.delCookie(LdUtils.COOKIE_USER);
				}
			}

		}
		return true;
	}

}
