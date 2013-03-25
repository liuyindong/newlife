package cn.javass.newfile.lucene.crawl;

import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.util.WritePath;

public class BaiduSearch
{
	
	private static Logger logger = LoggerFactory.getLogger(BaiduSearch.class);
	
	public static void main(String[] args)
	{
		String str = "炊事班的故事3";
		String url = "http://www.baidu.com/s?wd="+str;
		try
		{
			baiduSearch(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void baiduSearch(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);
		
		Elements searchList = doc.select("#content_left table");
		
		for (Iterator<Element> iterator = searchList.iterator(); iterator.hasNext();)
		{
			Element element =  iterator.next();
			
	//		System.out.println(element.html());
			
			logger.info("标题："+element.select("a").first().text());
			try
			{
				logger.info("内容:"+element.select("font").first().text());
			}
			catch (Exception e)
			{
				logger.info("内容:"+element.select("p").text());
			}
			
			logger.info("超链接"+element.select("a").first().attr("href"));
			
			logger.info("--------------------------------------------------");
			
			WritePath.writeFile("D://test.txt", doc.html(), false);
		}
		
		
	}
}
