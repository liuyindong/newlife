package cn.javass.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.javass.lucene.crawl.CrawlInternetController;
import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.service.CrawlResourceSrevice;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.newfile.newmsg.service.NewsTypeService;
import cn.javass.util.Config;
import cn.javass.util.DateUtil;
import cn.javass.util.email.SendEmail;

/**
 * 任务调度，抓取任务
 * 
 * @author liuyd
 * 
 */
@Component
public class ListComponent
{
	private final String HQL_CRAWLRESOURCEBY_DOMAINNAME = " where domainName = ? and status = 0";

	@Autowired
	private Config config;

	@Autowired
	@Qualifier("CrawlResourceSrevice")
	private CrawlResourceSrevice crawlResourceSrevice;

	@Autowired
	@Qualifier("NewsTypeService")
	private NewsTypeService newsTypeService;

	@Autowired
	@Qualifier("NewService")
	private NewService newService;

	// 30分钟抓取一次新闻//1800000
//	@Scheduled(fixedDelay = 1800000)
	void crawIntent() throws Exception
	{
		crawIntentStart("qqcom");
	}

	public void crawIntentStart(String crawName) throws Exception
	{

		List<CrawlResourceEntity> cralresou = crawlResourceSrevice.listAll(HQL_CRAWLRESOURCEBY_DOMAINNAME, crawName);

		try
		{
			CrawlInternetController.crawlInternetStart(newService, cralresou, newsTypeService);
		}
		catch (Exception e)
		{
			SendEmail.sendMail(config.getAdminEmail(), "抓取" + crawName + DateUtil.timeToString(new Date()) + " 错误信息信息", e.toString());
		}
	}
}
