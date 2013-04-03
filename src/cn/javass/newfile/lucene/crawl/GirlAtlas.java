package cn.javass.newfile.lucene.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
import cn.javass.util.DateUtil;
import cn.javass.util.DownImg;

public class GirlAtlas
{
	private static Logger logger = LoggerFactory.getLogger(GirlAtlas.class);

	private final static String downInternet = "http://girl-atlas.com";

	public static void main(String[] args) throws Exception
	{
		
		Document doc = JsoupConnect.jsoutConnectLog(downInternet);
		
		Document docs = JsoupConnect.jsoutConnectLog(doc.select("a.next").attr("abs:href"));
		
		System.out.println(docs);
		
		try
		{
		//	downNewMsg(downInternet);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void downNewMsg(String url) throws Exception
	{
		Document doc = JsoupConnect.jsoutConnectLog(url);

		Elements media = doc.select("a[href]");

		for (Element img : media)
		{
			String imgsrc = img.attr("photo");
			if (imgsrc.equals(""))
			{

			}
			else
			{
				String imgname = DateUtil.generateFileName(imgsrc);
				imgname = imgname.split("!")[0];

				int position = imgname.lastIndexOf(".");
				
				String imgPath = "D:\\" + DateUtil.addressRadom() +  imgname.substring(0,position);

				DownImg.saveUrlAs(imgsrc, imgPath + "/" + imgname);
				logger.info("下载图片：" + imgname + "成功");

				String imghref = img.attr("href");

				Document downshowimg = JsoupConnect.jsoutConnectLog(imghref);

				Elements showimgs = downshowimg.select("[src]");

				for (Element showimg : showimgs)
				{
					if (showimg.tagName().equals("img"))
					{
						String imgnames = DateUtil.generateFileName(showimg.attr("abs:src"));
						String title = showimg.attr("title");
						try
						{
							if (title.length() > 1)
							{
								 DownImg.saveUrlAs(showimg.attr("abs:src"), imgPath + "/show/" + imgnames.split("!")[0]);
								 
								 logger.info("下载图片：" + imgnames.split("!")[0] + "成功");
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
