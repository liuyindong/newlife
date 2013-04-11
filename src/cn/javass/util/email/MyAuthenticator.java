package cn.javass.util.email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用户名密码发送邮件人的密码和账号
 * @author liuyindong
 *
 */
public class MyAuthenticator extends Authenticator {
	private String userName;
	private String password;

	public MyAuthenticator(String userName, String password){
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}