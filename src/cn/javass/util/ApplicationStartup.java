package cn.javass.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

/** Application 初始化 **/
public class ApplicationStartup implements InitializingBean, ServletContextAware
{

	private ServletContext servletContext;

	@Autowired
	private Config config;

	/** 获取 Servlet 上下文（ServletContextAware 接口方法） **/
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	/** Spring 配置文件加载完成执行（InitializingBean 接口方法） **/
	public void afterPropertiesSet() throws Exception
	{
		// 将 Config 保存到 Application
		config.setWebUrl(servletContext.getContextPath()); // 网站根目录 URL
		config.setWebPath(servletContext.getRealPath("/")); // 网站根目录物理路径
		servletContext.setAttribute("config", config);
	}

}
