package cn.javass.test;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Test007
{
	public static Document getDocument()
	{
		Document document = DocumentHelper.createDocument();
		Element flashParameters = document.addElement("flash_parameters");
		Element preferences = flashParameters.addElement("preferences");
		Element global = preferences.addElement("global");
		
		Element basicProperty = global.addElement("basic_property");
		basicProperty.addAttribute("movieWidth", "980");
		basicProperty.addAttribute("movieHeight", "600");
		basicProperty.addAttribute("html_title", "Title");
		basicProperty.addAttribute("backgroundColor", "0xffffff");
		basicProperty.addAttribute("anvsoftMenu", "false");
		basicProperty.addAttribute("hideAdobeMenu", "false");
		basicProperty.addAttribute("photoDynamicShow", "true");
		basicProperty.addAttribute("enableURL", "true");
		basicProperty.addAttribute("transitionArray","");
		
		
		
		Element titleProperty = global.addElement("title_property");
		titleProperty.addAttribute("photoTitle", "false");
		titleProperty.addAttribute("photoTitleX", "5");
		titleProperty.addAttribute("photoTitleY", "5");
		titleProperty.addAttribute("photoTitleSize", "15");
		titleProperty.addAttribute("photoTitleFont", "Verdana");
		titleProperty.addAttribute("photoTitleColor", "0xffffff");
		
		
		Element musicProperty = global.addElement("music_property");
		musicProperty.addAttribute("path", "");
		musicProperty.addAttribute("stream", "true");
		musicProperty.addAttribute("loop", "true");
		
		
		Element photoProperty = global.addElement("photo_property");
		photoProperty.addAttribute("topPadding", "0");
		photoProperty.addAttribute("bottomPadding", "65");
		photoProperty.addAttribute("leftPadding", "0");
		photoProperty.addAttribute("rightPadding", "0");
		
		
		Element frameProperty = global.addElement("frame_property");
		frameProperty.addAttribute("frameColor", "0x000000");
		
		
		Element properties = global.addElement("properties");
		properties.addAttribute("enable", "true");
		properties.addAttribute("backgroundColor", "0xffffff");
		properties.addAttribute("backgroundAlpha", "50");
		properties.addAttribute("cssText", "a:link{text-decoration: underline;} a:hover{color:#ff0000; text-decoration: none;} a:active{color:#0000ff;text-decoration: none;} .blue {color:#0000ff; font-size:15px; font-style:italic; text-decoration: underline;} .body{color:#ff5500;font-size:20px;}");
		properties.addAttribute("align", "bottom");
		
		
		Element thumbnail = preferences.addElement("thumbnail");
		Element basicPropertytwo = thumbnail.addElement("basic_property");
		basicPropertytwo.addAttribute("backgroundColor", "0x3c3c3c");
		basicPropertytwo.addAttribute("buttonColor", "0x000000");
		basicPropertytwo.addAttribute("borderColor", "0xb3b3b3");
		
		
		
		Element album = flashParameters.addElement("album");
		Element slide = album.addElement("slide");
		slide.addAttribute("jpegURL", "http://ld:8080/newlife/images/logo_top.png");
		slide.addAttribute("d_URL", "http://ld:8080/newlife/images/logo_top.png");
		slide.addAttribute("transition", "0");
		slide.addAttribute("panzoom", "1");
		slide.addAttribute("URLTarget", "0");
		slide.addAttribute("phototime", "2");
		slide.addAttribute("url", "http://www.baidu.com");
		slide.addAttribute("title", "Xxjpm2C000801_20080809_MVPFN1A001");
		slide.addAttribute("width", "123");
		slide.addAttribute("height", "456");
		slide.addCDATA("<![CDATA[　8月9日，中国选手黄旭在资格赛鞍马比赛中（多重曝光拍摄）。新华社记者李钢摄]]>");
		
		
		Element slide1 = album.addElement("slide");
		slide1.addAttribute("jpegURL", "http://ld:8080/newlife/images/logo_top.png");
		slide1.addAttribute("d_URL", "http://ld:8080/newlife/images/logo_top.png");
		slide1.addAttribute("transition", "0");
		slide1.addAttribute("panzoom", "1");
		slide1.addAttribute("URLTarget", "0");
		slide1.addAttribute("phototime", "2");
		slide1.addAttribute("url", "http://www.baidu.com");
		slide1.addAttribute("title", "Xxjpm2C000801_20080809_MVPFN1A001");
		slide1.addAttribute("width", "123");
		slide1.addAttribute("height", "456");
		slide1.addCDATA("<![CDATA[　8月9日，中国选手黄旭在资格赛鞍马比赛中（多重曝光拍摄）。新华社记者李钢摄]]>");
		return document;
	}

	/**
	 * 写入xml文件地址
	 * 
	 * @param document
	 *            所属要写入的内容
	 * @param outFile
	 *            文件存放的地址
	 */
	public static void writeDocument(Document document, String outFile)
	{
		try
		{
			// 读取文件
			FileWriter fileWriter = new FileWriter(outFile);
			// 设置文件编码
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();  
			xmlFormat.setEncoding("urf-8");
			// 创建写文件方法
			XMLWriter xmlWriter = new XMLWriter(fileWriter, xmlFormat);
			// 写入文件
			
			xmlWriter.write(document);
			// 关闭
			xmlWriter.close();
		}
		catch (IOException e)
		{
			System.out.println("文件没有找到");
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Test007.writeDocument(Test007.getDocument(),"D://11.xml");
	}
}
