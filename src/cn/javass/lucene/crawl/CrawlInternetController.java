package cn.javass.lucene.crawl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.entity.NewsTypesEntity;
import cn.javass.newfile.newmsg.service.NewService;
import cn.javass.newfile.newmsg.service.NewsTypeService;
import cn.javass.util.DateUtil;

public class CrawlInternetController extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(CrawlInternetController.class);

	private CrawlResourceEntity caputTrsource;

	private NewService newService;

	private NewsTypesEntity newsTypesEntity;

	public CrawlInternetController(CrawlResourceEntity caputTrsource, NewService newService, NewsTypesEntity newsTypesEntity)
	{
		this.caputTrsource = caputTrsource;
		this.newService = newService;
		this.newsTypesEntity = newsTypesEntity;
	}

	public static void crawlInternetStart(NewService newService, List<CrawlResourceEntity> listCrawl, NewsTypeService newsTypeService)
	{
		ExecutorService pool = Executors.newFixedThreadPool(5);

		for (Iterator<CrawlResourceEntity> iterator = listCrawl.iterator(); iterator.hasNext();)
		{
			CrawlResourceEntity caputTrsource = iterator.next();

			Thread thread = new CrawlInternetController(caputTrsource, newService, newsTypeService.get(caputTrsource.getId()));
			pool.execute(thread);
		}
		pool.shutdown();
	}

	@Override
	public void run()
	{
		try
		{
			logger.info(Thread.currentThread().getName() + " 正在抓取" + this.caputTrsource.getCrawlUrl());
			downNewMsg();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void downNewMsg() throws Exception
	{

		Document doc = JsoupConnect.jsoutConnectLog(this.caputTrsource.getCrawlUrl());

		Elements emelents = doc.select(this.caputTrsource.getSelect());

		for (Element element : emelents)
		{
			try
			{
				Element newsImportant = element.select("h3.f18").first();

				NewsEntity newsEntity = new NewsEntity();

				String newRefUrl = newsImportant.select("a").attr("abs:href");
				
				List<String> newMsgs = showNewMsg(newRefUrl);

				if (newMsgs == null)
				{
					return;
				}

				newsEntity.setNewMsgOne(newMsgs.get(3));

				newsEntity.setTitle(newsImportant.text());
				newsEntity.setUrlRef(newRefUrl);
				newsEntity.setNewType(this.newsTypesEntity);
				try
				{
					newsEntity.setNewsImage(element.select("img").first().attr("abs:src"));
				}
				catch (Exception e)
				{
					newsEntity.setNewsImage(null);
				}
				newsEntity.setTechTag(newMsgs.get(2));
				newsEntity.setDownDate(newMsgs.get(0));
				newsEntity.setCreateDate(newMsgs.get(1));
				newService.save(newsEntity);
			}
			catch (Exception e)
			{
				logger.error(Thread.currentThread().getName() + "抓取新闻错误:" + this.caputTrsource.getCrawlUrl() + e);
			}
		}
	}

	public List<String> showNewMsg(String showMsgUrl) throws Exception
	{
		List<String> listNews = new ArrayList<String>();

		Document doc = JsoupConnect.jsoutConnectLog(showMsgUrl);

		String dateType = this.caputTrsource.getTimeFormat();

		String date = doc.select(".pubTime").first().text();

		date = date.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", " ");

		String nowDate = DateUtil.timeToString(new Date(), dateType);

		if (DateUtil.jisuan(date, nowDate, dateType) > this.caputTrsource.getEndIsTime())
		{
			return null;
		}
		Elements newTags = doc.select("dl.cf dd");

		StringBuffer sb = new StringBuffer();

		for (Element tag : newTags)
		{
			sb.append(tag.text() + "/");
		}

		listNews.add(date);
		listNews.add(nowDate);
		listNews.add(sb.toString());

		Element element = doc.select(this.caputTrsource.getShowNewSelect()).first();
		if (element == null)
		{
			String iframe = "<iframe width=420 height=330 frameborder=0 scrolling=auto src=" + showMsgUrl + "></iframe>";
			listNews.add(iframe);
		}
		else
		{
			listNews.add(element.html());
		}
		return listNews;
	}
}
