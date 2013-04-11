package cn.javass.util.email;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件
 * 
 * @author liuyindong
 * 
 */
public class SendEmail
{
	public static boolean sendMail(String email, String title, String message) throws Exception
	{

	//	 String host = config.getSmtpServer();
	 // String port = config.getSmtpPort();
	//	 String emailName = config.getSmtpUser();
	//	 String emailPwd = config.getSmtpPass();
		
		String emailName = "jingjidian@126.com";
		String emailPwd = "1234qwer";

		Properties properties = new Properties();
		// properties.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
	//	properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.host", "smtp.126.com");
		properties.setProperty("mail.smtp.auth", "true");

		Authenticator authenticator = new MyAuthenticator(emailName, emailPwd);

		Session session = Session.getDefaultInstance(properties, authenticator);

		session.getDebug();

		Address from = new InternetAddress(emailName);
		Address to = new InternetAddress(email);

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(from);
		msg.setSubject(title);
		msg.setSentDate(new Date());
		msg.setContent(message, "text/html;charset=utf-8");
		msg.setRecipient(RecipientType.TO, to);
		Transport.send(msg);
		return true;
	}
	public static void main(String[] args) throws Exception
	{
		try
		{
			sendMail("33398487@qq.com", "欢", "测试消息是0000000000000000000000000000000");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
