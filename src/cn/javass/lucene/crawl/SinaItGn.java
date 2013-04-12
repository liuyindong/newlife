package cn.javass.lucene.crawl;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.util.DateUtil;

/**
 * 
 * @author liuyd
 *
 */
public class SinaItGn extends Thread
{

	private final static String downInternet = "http://roll.tech.sina.com.cn/it/gn/";
	private final static Logger logger = LoggerFactory.getLogger(SinaItGn.class);

	private  Element message;

	public SinaItGn(Element message)
	{
		this.message = message;
	}

	public static void main(String[] args)
	{
		try
		{
			for (int i = 1; i <= 1; i++)
			{
				if (i == 1)
				{
					downNewMsg(downInternet + "index.shtml");
				}
				else
				{
					downNewMsg(downInternet + "list_" + i + ".shtml");
					return;
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String showNewMsg(String url)
	{

		Document doc = null;
		try
		{
			doc = JsoupConnect.jsoutConnectLog(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Elements showMsgs = doc.select("#artibody");

		return showMsgs.toString();
	}

	public static void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements msgList = doc.select(".contList ul li");

		// boolean isTaday = false;

		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(1);

		for (Element message : msgList)
		{
			Thread thread = new SinaItGn(message);
	//		thread.start();
			pool.execute(thread);
		}
		// 关闭线程池
		pool.shutdown();
	}

	@Override
	public void run()
	{
		try
		{
			String newsData = message.select("span").text();

			try
			{
				newsData = newsData.substring(newsData.length() - 13, newsData.length() - 1);
				newsData = newsData.replaceAll("月", "-");
				newsData = newsData.replaceAll("日", "");
				newsData = DateUtil.timeToString(new Date(), "YYYY") + "-" + newsData;
			}
			catch (Exception e)
			{
				newsData = DateUtil.timeToString(new Date());
			}

			Elements newsmsg = message.select("a");
			
			logger.info("新闻标题是:" + newsmsg.text());
//			logger.info("链接地址:" + newsmsg.attr("href"));
			logger.info("新闻时间:" + newsData);
			
//			logger.info("新闻内容:" + showNewMsg(newsmsg.attr("href")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
