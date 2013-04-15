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
import cn.javass.lucene.crawl.Tech163New;
import cn.javass.lucene.crawl.controller.CrawlResourceController;
import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.service.CrawlResourceSrevice;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.util.Ai2YCOM;
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
	private final String HQL_CRAWLRESOURCEBY_DOMAINNAME = "from CrawlResourceEntity where domainName = ? and status = 0";

	@Autowired
	@Qualifier("NewService")
	private NewService newService;

	@Autowired
	private Config config;

	@Autowired
	@Qualifier("CrawlResourceSrevice")
	private CrawlResourceSrevice crawlResourceSrevice;

	// 30分钟抓取一次新闻163新闻//1800000
	@Scheduled(fixedDelay = 1800000)
	void crawIntent() throws Exception
	{
		crawIntentStart("qqcom");
	}

	public void crawIntentStart(String crawName) throws Exception
	{

		List<CrawlResourceEntity> cralresou = crawlResourceSrevice.listAll(HQL_CRAWLRESOURCEBY_DOMAINNAME, crawName);

		List<NewsEntity> listNewEntity = new ArrayList<NewsEntity>();
		try
		{
			for (Iterator<CrawlResourceEntity> iterator = cralresou.iterator(); iterator.hasNext();)
			{
				CrawlResourceEntity crawlResource = iterator.next();
				CrawlInternetController cralStart = new CrawlInternetController();
				listNewEntity = cralStart.downNewMsg(crawlResource);
			}
		}
		catch (Exception e)
		{
			SendEmail.sendMail(config.getAdminEmail(), "抓取" + crawName + DateUtil.timeToString(new Date()) + " 错误信息信息", e.toString());
			return;
		}
		for (Iterator<NewsEntity> iterator = listNewEntity.iterator(); iterator.hasNext();)
		{
			NewsEntity newsEntity = iterator.next();
			newService.save(newsEntity);
		}
	}
}
