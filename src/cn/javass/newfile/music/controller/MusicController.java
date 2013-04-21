package cn.javass.newfile.music.controller;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.javass.lucene.crawl.util.JsoupConnect;
import cn.javass.util.WritePath;

public class MusicController
{
	private final static String url = "http://www.ik123.com/mp3-dj/ik123_9492.html";
	
	public static void main(String[] args)
	{
		try
		{
			downNewMsg(url);
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

		System.out.println(doc);
		
		WritePath.writeFile("D://test.txt", doc.html(), false);
	}
}
