package cn.javass.lucene.crawl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.entity.CrawlResourceEntity;
import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.DateUtil;

public class CrawlInternetController
{
	private static Logger logger = LoggerFactory.getLogger(CrawlInternetController.class);

	public List<NewsEntity> downNewMsg(CrawlResourceEntity caputTrsource) throws Exception
	{

		List<NewsEntity> listNews = new ArrayList<NewsEntity>();

		Document doc = JsoupConnect.jsoutConnectLog(caputTrsource.getCrawlUrl());

		Elements emelents = doc.select(caputTrsource.getSelect());

		for (Element element : emelents)
		{
			try
			{
				Element newsImportant = element.select("a").first();

				String dateType = caputTrsource.getTimeFormat();
				String date = element.select("span.aTime").first().text();
				String nowDate = DateUtil.timeToString(new Date(), dateType);

				if (DateUtil.jisuan(date, nowDate, dateType) * 60 > caputTrsource.getEndIsTime())
				{
					return listNews;
				}

				NewsEntity newsEntity = new NewsEntity();

				newsEntity.setTitle(newsImportant.select("img").attr("alt"));
				newsEntity.setUrlRef(newsImportant.attr("abs:href"));
				newsEntity.setNewType(caputTrsource.getNewType());
				newsEntity.setNewsImage(newsImportant.select("img").attr("abs:src"));

				Elements newTags = element.select("span.techTag a");

				for (Element tag : newTags)
				{
					newsEntity.setTechTag(newsEntity.getTechTag() + "/" + tag.text());
				}

				newsEntity.setDownDate(date);
				newsEntity.setCreateDate(nowDate);
				newsEntity.setNewMsgOne(showNewMsg(newsImportant.attr("abs:href"), caputTrsource.getShowNewSelect()));

				listNews.add(newsEntity);
			}
			catch (Exception e)
			{
				logger.error("抓取新闻错误:" + e);
				return listNews;
			}
		}
		return listNews;
	}

	public String showNewMsg(String showMsgUrl, String showNewSelect) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(showMsgUrl);

		Element element = doc.select(showNewSelect).first();
		if (element == null)
		{
			String iframe = "<iframe width=420 height=330 frameborder=0 scrolling=auto src="+showMsgUrl+"></iframe>";
			return iframe;
		}

		return element.html();
	}
}
