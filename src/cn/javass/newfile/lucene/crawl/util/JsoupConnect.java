package cn.javass.newfile.lucene.crawl.util;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupConnect
{
	public static Document jsoutConnectLog(String url) throws Exception
	{
		Document doc = null;
		while (true)
		{
			Connection conn = Jsoup.connect(url);
			conn.header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			try
			{
				doc = conn.timeout(10000).get();
			}
			catch (IOException e)
			{
				System.out.println("抓取异常等待10秒继续");
				e.printStackTrace();
				Thread.sleep(10000);
			}
			if(doc == null)
			{
				System.out.println("抓取到的是空的等待--10秒继续");
				Thread.sleep(10000);
			}else
			{
				break;
			}
		}
		return doc;
		
	}
}
