package cn.javass.newfile.lucene.crawl;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.DateUtil;


public class ItHome extends Thread
{

	private final static String downInternet = "http://www.ithome.com/list/";

	@Override
	public void run()
	{
		try
		{
			downNewsStart();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		try
		{
			ItHome.downNewMsg(downInternet);
			/*for (int i = 2; i < 1000; i++)
			{
				ItHome.downNewMsg(downInternet + "list_" + i + ".html");
			}*/

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public int downNewsStart() throws Exception
	{
		while (true)
		{

			ItHome.downNewMsg(downInternet);
			// Thread.sleep(360000);
		}
	}

	public static String showNewMsg(String url)
	{

		String newMsg = "";

		Document doc = null;
		try
		{
			doc = JsoupConnect.jsoutConnectLog(url);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Elements showMsgs = doc.select("div.post_content");

		int delFirstP = 1;
		for (Element showMsg : showMsgs)
		{
			List<Element> entityMsg = showMsg.children();
			for (Iterator<Element> iterator = entityMsg.iterator(); iterator.hasNext();)
			{
				Element element = iterator.next();
				if (delFirstP == 1)
				{
					element.remove();
					delFirstP++;
					continue;
				}
				newMsg += element;
			}
			// return Jsoup.clean(b, Whitelist.basicWithImages());
		}
		return newMsg;
	}

	public static void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements msgList = doc.select("ul.ulcl li");

		// boolean isTaday = false;

		for (Element message : msgList)
		{
			List<Element> a = message.children();

			if (a.size() == 3)
			{

				NewsEntity newsEntity = new NewsEntity();
				int i = 0;
				for (Element element : a)
				{
					switch (i)
					{
					case 0:
						// 抓取今天的新闻
						String downDate = Jsoup.clean(element.outerHtml(), Whitelist.none());
						// if (DateUtil.jisuan(DateUtil.stringToTime(downDate,
						// DOWN_DATE_TIME), DateUtil.timeToString(new Date(),
						// DOWN_DATE_TIME), DOWN_DATE_TIME) == 0)
						// {
						newsEntity.setDownDate(Jsoup.clean(element.outerHtml(), Whitelist.none()));
						// }
						// else
						// {
						// isTaday = true;
						// }
						break;
					case 1:
						newsEntity.setNewType(Jsoup.clean(element.text(), Whitelist.none()));
						break;
					case 2:
						String newsMsg = Jsoup.clean(element.text(), Whitelist.none());
						newsEntity.setTitle(newsMsg);
						System.out.println("抓取到:" + newsMsg);
						newsEntity.setUrlRef(element.attr("abs:href"));
						String showMsgs = showNewMsg(element.attr("abs:href"));
						newsEntity.setNewMsgOne(showMsgs);
						// logger.info("内容:" + showMsgs);
						break;

					default:
						break;
					}
					i++;
				}
				newsEntity.setCreateDate(DateUtil.timeToString(new Date()));

				try
				{
			//		CreateNews.insert(newsEntity);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
