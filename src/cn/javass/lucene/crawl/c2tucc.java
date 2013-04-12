package cn.javass.lucene.crawl;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.util.WritePath;

public class c2tucc
{

	private static Logger logger = LoggerFactory.getLogger(c2tucc.class);

	public static void main(String[] args) throws UnsupportedEncodingException
	{
		String str = "";
		
		
		String url = "http://www.2tu.cc/search.asp?searchword=" + str;
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

		System.out.println(doc);

		WritePath.writeFile("D://test.txt", doc.html(), false);

		Elements searchList = doc.select("#content_left table");

		for (Iterator<Element> iterator = searchList.iterator(); iterator.hasNext();)
		{
			Element element = iterator.next();
				
		}

	}
}
