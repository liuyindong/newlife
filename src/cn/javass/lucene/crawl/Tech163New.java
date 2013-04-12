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

/**
 * 163信息获取
 * 
 * @author liuyd
 * 
 */
public class Tech163New extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(Tech163New.class);

	public List<NewsEntity> downNewMsg(CrawlResourceEntity caputTrsource) throws Exception
	{
		
		List<NewsEntity> listNewEntity = new ArrayList<NewsEntity>();
		
		Document doc = JsoupConnect.jsoutConnectLog(caputTrsource.getCrawlUrl());
		
		Elements emelents= doc.select(caputTrsource.getSelect());
		
		for (Element element : emelents)
		{
			try
			{
				
				
				String date = element.select("span").first().text();
				date = date.substring(1,date.length()-1);
				
				String dateType = caputTrsource.getTimeFormat();
				String nowDate = DateUtil.timeToString(new Date(),dateType);
				
				if(DateUtil.jisuan(date,nowDate, dateType)*60 > caputTrsource.getEndIsTime())
				{
					return listNewEntity;
				}
				
				Element newMsg = element.select("a").first();
				
				NewsEntity newsEntity = new NewsEntity();
				
				newsEntity.setDownDate(date);
				newsEntity.setCreateDate(DateUtil.timeToString(new Date()));
				newsEntity.setNewMsgOne(showNewMsg(newMsg.attr("abs:href")));
				newsEntity.setNewType("互联网新闻");
				newsEntity.setTitle(newMsg.text());
				
				listNewEntity.add(newsEntity);
			}
			catch (Exception e)
			{
				return listNewEntity;
			}
		}
		return listNewEntity;
	}
	
	public String showNewMsg(String showMsgUrl) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(showMsgUrl);
		
		Element element = doc.select("div #endText").first();
		
		element.select("div.gg200x300").remove();
		
		return element.html();
	}

}
