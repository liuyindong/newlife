package cn.javass.newfile.lucene.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.newfile.lucene.crawl.util.JsoupConnect;
/**
 * 京东的搜索商品
 * @author liuyd
 *
 */
public class C360BuySearch extends Thread
{
	private static Logger logger = LoggerFactory.getLogger(C360BuySearch.class);

	// private static final String DOWN_DATE_TIME = "yyyy-MM-dd HH";

	static String str = "藏机图";

	private final static String downInternet = "http://search.jd.com/Search?keyword=" + str + "&enc=utf-8";


	public static void main(String[] args)
	{
		try
		{
			downNewMsg(downInternet);
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

		Elements msgList = doc.select("ul.list-h li");

		for (Element message : msgList)
		{
			Elements everyProduct = message.select(".p-name");

			logger.info("商品名称：" + everyProduct.text());
			logger.info("商品地址：" + everyProduct.select("a").attr("href"));
			logger.info("商品价格：" + message.select(".p-price img").attr("data-lazyload"));
			
			logger.info("---------------------------------------------------------------------");
		}
	}

}
