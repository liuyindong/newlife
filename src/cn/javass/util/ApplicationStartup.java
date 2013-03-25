package cn.javass.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

public class ApplicationStartup implements InitializingBean, ServletContextAware
{
	private ServletContext servletContext;

	@Autowired
	private Config config;

	@Override
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		// 将 Config 保存到 Application
		config.setWebUrl(servletContext.getContextPath()); // 网站根目录 URL
		config.setWebPath(servletContext.getRealPath("/")); // 网站根目录物理路径
		servletContext.setAttribute("config", config);
	}

}
