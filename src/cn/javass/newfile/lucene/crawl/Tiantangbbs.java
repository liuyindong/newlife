package cn.javass.newfile.lucene.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.util.DateUtil;
import cn.javass.util.DownImg;
import cn.javass.util.WritePath;

public class Tiantangbbs
{
//	private static Logger logger = LoggerFactory.getLogger(Tiantangbbs.class);

	private final static String downInternet = "http://www.tiantangbbs.com/";

	private static String movpath;

	public Tiantangbbs(String movname)
	{
		this.movpath = "D://" + DateUtil.addressRadom() + "电影/";
		this.movpath = this.movpath + movname;
	}

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

		Elements msgList = doc.select("ul.mtw li");

		for (Element elem : msgList)
		{

			Element moviemsg = elem.select("a").last();

			new Tiantangbbs(moviemsg.attr("title"));

	//		System.out.println(moviemsg.attr("title"));
	//		System.out.println(moviemsg.select("img").attr("abs:src"));

	//		System.out.println(elem.select("em.xs0").last());

			downmoviemsg(moviemsg.attr("abs:href"));

	//		return;
			
		}
	}

	public static void downmoviemsg(String url)
	{
		try
		{
			// Document doc = JsoupConnect.jsoutConnectLog(url);

			// WritePath.writeFile("D://test.html", doc.html(), false);

			// File input = new File("D://test.html");
			// Document doc = Jsoup.parse(input, "UTF-8", "");

			Document doc = JsoupConnect.jsoutConnectLog(url);

			Elements msgList = doc.select(".typeoption tr");

			// 获取了电影类型
			for (Element element : msgList)
			{
				String huazhi = element.select("th").text();

				if ("豆瓣评分:".equals(huazhi))
				{
					break;
				}
				String huazhiVal = element.select("td").text();
				WritePath.writeFile(movpath + "/简介.txt", huazhi.substring(0, huazhi.length() - 1) + ":" + huazhiVal + "\r\n", true);
				// logger.info(huazhi.substring(0, huazhi.length()-1) + ":" +
				// huazhiVal);
			}
			// 获取图片信息
			Elements movieimg = doc.select("ignore_js_op img");

			for (Element movimg : movieimg)
			{
				String img = movimg.attr("abs:zoomfile");
				if (img.length() <= 10)
				{
					break;
				}
				String imgnames = DateUtil.generateFileName(img);
				DownImg.saveUrlAs(img, movpath + "/img/" + imgnames);
				// logger.info("图片介绍:" + img);
			}

			// 视频资源地址

			Element downmovpath = doc.select("ignore_js_op").last();

			String downUrl = downmovpath.select("span a").first().attr("abs:href");

			String localRar = movpath + "/地址/" + DownImg.returnType(downUrl);
			
			DownImg.saveUrlAs(downUrl, localRar);
			
			// 获取了电影的简介
			Elements message = doc.select(".t_fsz tbody td");
			message.select("ignore_js_op").remove();
	//		logger.info("简介:" + message.text());
			WritePath.writeFile(movpath + "/简介.txt", message.text() + "\r\n", true);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
