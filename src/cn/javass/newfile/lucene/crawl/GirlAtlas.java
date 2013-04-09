package cn.javass.newfile.lucene.crawl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.util.DateUtil;
import cn.javass.util.DownImg;
import cn.javass.util.LdUtils;

public class GirlAtlas extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(GirlAtlas.class);

	private final static String downInternet = "http://girl-atlas.com/";

	private static final List<String> nextpaglist = new ArrayList<String>();
	
	private final String todayDate = "D://" + DateUtil.addressRadom();
	
	private String imgPaths;

	private String nextPage;

	public GirlAtlas(String nextPage)
	{
		this.nextPage = nextPage;
	}

	public static void main(String[] args) throws Exception
	{

		downMsgForUrl(downInternet);

		logger.info("数据加载完成:" + nextpaglist.size());

		ExecutorService pool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < nextpaglist.size(); i++)
		{
			Thread thread = new GirlAtlas(nextpaglist.get(i));
			pool.execute(thread);
		}

	}

	@Override
	public void run()
	{
		logger.info(Thread.currentThread().getName() + " 正在下载资源 " + nextPage);
		try
		{
			downNewMsg(nextPage);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void downMsgForUrl(String internetUrl) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(internetUrl);

		String url = doc.select("a.next").attr("abs:href");

		if (url.length() <= 0)
		{
			return;
		}
		nextpaglist.add(url);
		try
		{
			logger.info("正在加入:" + url);
			downMsgForUrl(url);
		}
		catch (Exception e)
		{
			return;
		}
	}

	public void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		// System.out.println(doc);

		// File input = new File("D://aa.html");
		// Document doc = Jsoup.parse(input, "UTF-8", "");

		Elements media = doc.select("div.inner");

		for (Element img : media)
		{

			String localImgPath;
			String urlImg;

			Element imgTitles = img.select("div.grid_title").first();

			String imgTitle = imgTitles.select("a").text();
			
			if(imgTitle.length() > 100)
			{
				imgTitle = imgTitle.substring(0,100);
			}
			this.imgPaths = this.todayDate + LdUtils.StringFilter(imgTitle);

			Elements imgsrcList = img.select("div.cell");
			

			for (Element imgsrc : imgsrcList)
			{
				urlImg = imgsrc.select("a").attr("abs:photo");
				
				localImgPath = this.imgPaths + DownImg.returnType(urlImg.split("!")[0]);

				DownImg.saveUrlAs(urlImg.split("!")[0], localImgPath);

				logger.info("下载图片：" + localImgPath + "成功");

				String imghref = imgsrcList.select("a").attr("href");

				Document downshowimg = JsoupConnect.jsoutConnectLog(imghref);

				Elements showimgs = downshowimg.select("[src]");

				for (Element showimg : showimgs)
				{
					if (showimg.tagName().equals("img"))
					{

						urlImg = showimg.attr("abs:src");
						String title = showimg.attr("title");
						try
						{
							if (title.length() > 1)
							{
								localImgPath = this.imgPaths + "/show" + DownImg.returnType(urlImg.split("!")[0]);
								DownImg.saveUrlAs(showimg.attr("abs:src"), localImgPath);

								logger.info("下载图片：" + localImgPath + "成功");
							}
						}
						catch (Exception e)
						{
							// System.out.println("不是是内容" + imgnames);
						}
					}
					else
					{
						// System.out.println(showimg.attr("abs:src"));
					}

				}
			}
		}

	}

}
