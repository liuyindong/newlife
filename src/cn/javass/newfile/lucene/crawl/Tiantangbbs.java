package cn.javass.newfile.lucene.crawl;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.util.Ai2YCOM;
import cn.javass.util.DateUtil;
import cn.javass.util.DownImg;
import cn.javass.util.WritePath;

public class Tiantangbbs extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(Tiantangbbs.class);

	private final String movpathF = "D://2013/电影种子/";

	private String movpath;

	private String downInternet;

	public Tiantangbbs(String downInternet)
	{
		this.downInternet = downInternet;
	}

	public static void main(String[] args)
	{
		try
		{
			ExecutorService pool = Executors.newFixedThreadPool(10);

			for (int i = 1; i <= 109; i++)
			{
				String internet = "http://www.tiantangbbs.com/forum.php?mod=forumdisplay&fid=2&ortid=1&page=" + i;
				Thread thread = new Tiantangbbs(internet);
				pool.execute(thread);
			}
			pool.shutdown();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		try
		{
			logger.info(Thread.currentThread().getName() + " 正在下载资源 " + downInternet);
			downNewMsg(this.downInternet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements msgList = doc.select("ul.mtw li");

		for (Element elem : msgList)
		{

			Element moviemsg = elem.select("a").last();

			this.movpath = this.movpathF + moviemsg.attr("title");
			// System.out.println(moviemsg.attr("title"));
			// System.out.println(moviemsg.select("img").attr("abs:src"));

			// System.out.println(elem.select("em.xs0").last());

			downmoviemsg(moviemsg.attr("abs:href"));

			// return;

		}
	}

	public void downmoviemsg(String url)
	{
		try
		{
			// Document doc = JsoupConnect.jsoutConnectLog(url);

			// WritePath.writeFile("D://test.html", doc.html(), false);

			// File input = new File("D://test.html");
			// Document doc = Jsoup.parse(input, "UTF-8", "");

			String localRar = "";

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
				WritePath.writeFile(this.movpath + "/简介.txt", huazhi.substring(0, huazhi.length() - 1) + ":" + huazhiVal + "\r\n", true);
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
				try
				{
					localRar = this.movpath + "/img/" + imgnames;
					DownImg.saveUrlAs(img, localRar);
				}
				catch (Exception e)
				{
					logger.error("下载视频图片：" + img + "失败，浏览器地址：" + this.downInternet + " 存储地址：" + localRar + "错误信息:" + e);
				}
				// logger.info("图片介绍:" + img);
			}

			// 视频资源地址

			Element downmovpath = doc.select("ignore_js_op").last();

			String downUrl = null;
			
			try
			{
				downUrl = downmovpath.select("span a").first().attr("abs:href");
			}
			catch (Exception e)
			{
				downUrl = downmovpath.select("p a").first().attr("abs:href");
			}
			
			String filePath = Ai2YCOM.TOADY + "下载错误信息/" + UUID.randomUUID().toString() + ".txt";
			
			if(downUrl == null)
			{
				WritePath.writeFile(filePath, downmovpath.html() + Ai2YCOM.BLANK, true);
				
				StringBuilder sb = new StringBuilder();
				
				sb.append("下载视频：" + downUrl + Ai2YCOM.BLANK);
				sb.append("存储地址：" + localRar + Ai2YCOM.BLANK);
				sb.append("浏览器地址：" + this.downInternet + Ai2YCOM.BLANK);
				
				WritePath.writeFile(filePath, sb.toString(), true);
				
				return;
			}

			String orderMovName = DownImg.returnType(downUrl);

			orderMovName = Ai2YCOM.YUMINAIYCOM + orderMovName.substring(orderMovName.lastIndexOf("["));

			localRar = this.movpath + "/地址/" + orderMovName;

			try
			{
				DownImg.saveUrlAs(downUrl, localRar);
			}
			catch (Exception e)
			{
				logger.error("下载视频：" + downUrl + "失败，浏览器地址：" + this.downInternet + " 存储地址：" + localRar + "错误信息:" + e);
				while (true)
				{
					try
					{
						Thread.sleep(10000);
						logger.debug("等待10秒继续下载：" + downUrl + " 存储地址：" + localRar );
						DownImg.saveUrlAs(downUrl, localRar);
						break;
					}
					catch (Exception es)
					{
						logger.debug("等待10秒继续下载错误" + e);
					}
				}
			}

			// 获取了电影的简介
			Elements message = doc.select(".t_fsz tbody td");
			message.select("ignore_js_op").remove();
			// logger.info("简介:" + message.text());
			WritePath.writeFile(this.movpath + "/简介.txt", message.text() + "\r\n", true);

			logger.info(Thread.currentThread().getName() + "下载视频:" + this.movpath + "成功");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
