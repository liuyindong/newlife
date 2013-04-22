package cn.javass.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;

import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.service.CrawlResourceSrevice;
import cn.javass.newfile.comment.entity.CommentTypeEntity;
import cn.javass.newfile.comment.service.CommentTypeService;
import cn.javass.newfile.newmsg.entity.NewsTypesEntity;
import cn.javass.newfile.newmsg.service.NewsTypeService;

/** Application 初始化 **/
public class ApplicationStartup implements InitializingBean, ServletContextAware
{

	Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

	private ServletContext servletContext;

	private String file;

	@Autowired
	private Config config;
	

	@Autowired
	@Qualifier("NewsTypeService")
	private NewsTypeService newsTypeService;
	
	@Autowired
	@Qualifier("CrawlResourceSrevice")
	private CrawlResourceSrevice crawlResourceSrevice;
	
	@Autowired
	@Qualifier("CommentTypeService")
	private CommentTypeService commentTypeService;
	
	
	/** 获取 Servlet 上下文（ServletContextAware 接口方法） **/
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	/** Spring 配置文件加载完成执行（InitializingBean 接口方法） **/
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception
	{
		logger.info("\t开始初始化网站资源...");
		// 将 Config 保存到 Application
		config.setWebUrl(servletContext.getContextPath()); // 网站根目录 URL
		config.setWebPath(servletContext.getRealPath("/")); // 网站根目录物理路径
		servletContext.setAttribute("config", config);
		logger.info("\t初始化网站资源结束");

		String xmlFilePath = "init_date.xml";
		String filePath = null;
		if (xmlFilePath == null || xmlFilePath.trim().equals(""))
		{
			filePath = file;
		}
		else
		{
			filePath = xmlFilePath;
		}
		Document document = new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath));

		logger.info("\t开始初始化新闻类型...");
		addNewsType(document.selectNodes("//InitDatas/newstypes/newstype"));
		logger.info("\t初始化新闻类型结束");
		
		logger.info("\t开始初始化评论类型...");
		addCommentType(document.selectNodes("//InitDatas/comments/commentType"));
		logger.info("\t初始化评论类型结束...");

		logger.info("\t开始初始化抓取资源信息...");
		addCrawlResource(document.selectNodes("//InitDatas/crawlresources/crawlresource"));
		logger.info("\t初始化抓取资源信息结束");

	}

	private void addCommentType(List<CommentTypeEntity> listCommType)
	{
		if (commentTypeService.countAll() == 0)
		{
			for (Iterator<CommentTypeEntity> iterator = listCommType.iterator(); iterator.hasNext();)
			{
				Element element = (Element) iterator.next();

				CommentTypeEntity commentTypeEntity = new CommentTypeEntity();
				commentTypeEntity.setName(element.attributeValue("name"));
				commentTypeEntity.setCreateDate(DateUtil.timeToString(new Date()));
				commentTypeEntity.setId(new Integer(element.attributeValue("id")));
				commentTypeService.save(commentTypeEntity);
			}
		}
		
	}

	public int getCount()
	{
		List<?> list = newsTypeService.listAll();
		return list.size();
	}

	public void addNewsType(List<NewsTypesEntity> listNewstype)
	{
		if (newsTypeService.countAll() == 0)
		{
			for (Iterator<NewsTypesEntity> iterator = listNewstype.iterator(); iterator.hasNext();)
			{
				Element element = (Element) iterator.next();

				NewsTypesEntity NewsTypesEntity = new NewsTypesEntity();
				NewsTypesEntity.setName(element.attributeValue("name"));
				NewsTypesEntity.setCreateDate(DateUtil.timeToString(new Date()));
				NewsTypesEntity.setId(new Integer(element.attributeValue("id")));
				newsTypeService.save(NewsTypesEntity);
			}
		}
	}

	public void addCrawlResource(List<CrawlResourceEntity> listNewstype)
	{
		if (crawlResourceSrevice.countAll() == 0)
		{
			for (Iterator<?> iterator = listNewstype.iterator(); iterator.hasNext();)
			{
				Element element = (Element) iterator.next();

				CrawlResourceEntity crawlResource = new CrawlResourceEntity();

				crawlResource.setDomainName(element.attributeValue("domainname"));
				crawlResource.setCrawlUrl(element.attributeValue("crawlurl"));
				crawlResource.setSelect(element.attributeValue("select"));
				crawlResource.setShowNewSelect(element.attributeValue("shownewselect"));
				crawlResource.setTimeFormat(element.attributeValue("timeformat"));
				crawlResource.setEndIsTime(new Integer(element.attributeValue("endIstime")));
				crawlResource.setStatus(new Integer(element.attributeValue("status")));
				crawlResource.setNewType(element.attributeValue("newtype"));
				crawlResource.setDateCrawl(element.attributeValue("datecrawl"));
				crawlResourceSrevice.save(crawlResource);
			}
		}
	}

}
