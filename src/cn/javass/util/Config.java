package cn.javass.util;

public class Config
{
	//网站根目录 URL
	private String webUrl;

	//网站根目录物理路径 
	private String webPath;
	
	//lucene索引路径
	private String 	lucenePath;
	
	public String getWebUrl()
	{
		return webUrl;
	}

	public void setWebUrl(String webUrl)
	{
		this.webUrl = webUrl;
	}

	public String getWebPath()
	{
		return webPath;
	}

	public void setWebPath(String webPath)
	{
		this.webPath = webPath;
	}

	public String getLucenePath()
	{
		return lucenePath;
	}

	public void setLucenePath(String lucenePath)
	{
		this.lucenePath = lucenePath;
	}
}
