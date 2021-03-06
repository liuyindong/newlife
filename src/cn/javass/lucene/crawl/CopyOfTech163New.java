package cn.javass.lucene.crawl;

import java.util.Date;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.util.DateUtil;

/**
 * 163信息获取
 * 
 * @author liuyd
 * 
 */
public class CopyOfTech163New extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(CopyOfTech163New.class);

	private final static String internet = "http://tech.163.com/";

	private String internetNow;

	public CopyOfTech163New(String internetNow)
	{
		this.internetNow = internetNow;
	}

	public static void main(String[] args)
	{
		String[] interNames = { "internet" };

		for (String internateName : interNames)
		{
			CopyOfTech163New teach163 = new CopyOfTech163New(internet + "special/0009rt/" + internateName + "_roll.html");
			teach163.start();
		}
	}

	@Override
	public void run()
	{
		try
		{
			downNewMsg(this.internetNow);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements emelents = doc.select("div.colLM div ul li");

		for (Element element : emelents)
		{
			System.out.println(element.select("a").first().attr("title"));
			System.out.println(element.select("a").first().attr("href"));
			System.out.println(element.select("span").first().text().substring(1, element.select("span").first().text().length() - 1));

			System.out.println("morenimg");

			System.out.println(showNewMsg(element.select("a").first().attr("abs:href")));

			String date = element.select("span").first().text();
			date = date.substring(1, date.length() - 1);

			String dateType = "yyyy-MM-dd HH:mm";
			String nowDate = DateUtil.timeToString(new Date(), dateType);

			if (DateUtil.jisuan(date, nowDate, dateType) * 60 > 30)
			{
				return;
			}

			Element newMsg = element.select("a").first();
			// logger.info("时间是：" + date);
			// logger.info("标题：" + newMsg.text());
			// logger.info("链接：" + newMsg.attr("abs:href"));

			// showNewMsg(newMsg.attr("abs:href"));

			return;
		}
	}

	public String showNewMsg(String showMsgUrl) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(showMsgUrl);

		Element element = doc.select("div #endText").first();

		element.select("div.gg200x300").remove();

		System.out.println(element);

		return "";
	}

}
