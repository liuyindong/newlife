package cn.javass.util;

public class Config
{
	//网站根目录 URL
	private String webUrl;

	//网站根目录物理路径 
	private String webPath;
	
	//lucene索引路径
	private String 	lucenePath;
	
	//管理员邮箱
	private String adminEmail;
	
	/**邮件信息**/
	
	//SMTP服务器地址
	private String smtpServer;
	
	// SMTP服务器端口 
	private String smtpPort;

	// SMTP用户名
	private String smtpUser;
	
	// SMTP密码 
	private String smtpPass;
	
	
	public String getAdminEmail()
	{
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail)
	{
		this.adminEmail = adminEmail;
	}

	public String getSmtpServer()
	{
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer)
	{
		this.smtpServer = smtpServer;
	}

	public String getSmtpPort()
	{
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort)
	{
		this.smtpPort = smtpPort;
	}

	public String getSmtpUser()
	{
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser)
	{
		this.smtpUser = smtpUser;
	}

	public String getSmtpPass()
	{
		return smtpPass;
	}

	public void setSmtpPass(String smtpPass)
	{
		this.smtpPass = smtpPass;
	}

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
