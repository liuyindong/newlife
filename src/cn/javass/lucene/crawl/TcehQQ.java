package cn.javass.lucene.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.util.JsoupConnect;

/**
 * 京东的搜索商品
 * 
 * @author liuyd
 * 
 */
public class TcehQQ extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(TcehQQ.class);

	private static final String DOWN_DATE_TIME = "yyyy-MM-dd HH";

	// 要闻
	private final static String downInternet = "http://tech.qq.com/c/techIndexList_1.htm";

	public static void main(String[] args)
	{
		try
		{
			downNewMsg(downInternet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements msgList = doc.select("#listZone .Q-tpList");

		for (Element element : msgList)
		{
			
			Element newsImportant = element.select("a").first();
			
			String date = element.select("span.aTime").first().text();
			
			
			
			System.out.println(newsImportant.select("img").attr("alt"));
			System.out.println(newsImportant.attr("abs:href"));
			System.out.println(newsImportant.select("img").attr("abs:src"));
			System.out.println(showNewMsg(newsImportant.attr("abs:href")));
			

			Elements newTags = element.select("span.techTag a");

			for (Element tag : newTags)
			{
				System.out.println(tag.text());
			}
			return;

		}
	}

	public static String showNewMsg(String showMsgUrl) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(showMsgUrl);

		Element element = doc.select("div#Cnt-Main-Article-QQ").first();

		return element.html();
	}

}
