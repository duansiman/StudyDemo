package javaemail;

import java.io.FileInputStream;
import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.security.sasl.Provider;

public class SendEmailDemo2 {
	
	public static void main(String[] args) throws Exception {
//		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = new Properties();
//		Properties props = System.getProperties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.exmail.qq.com");//smtp.qq.com
		
		Security.addProvider(new Provider()); 
//		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		
//		props.setProperty( "mail.imap.socketFactory.class" , SSL_FACTORY); 
//		props.setProperty("mail.imap.socketFactory.fallback", "false");
//		props.setProperty("mail.imap.port", "993");
//		props.setProperty("mail.imap.socketFactory.port", "993");
		
		Session session = Session.getInstance(props, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("835804205@qq.com", "00000");
			}
			
		});
		session.setDebug(true);
		
		//邮件内容
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("835804205@qq.com"));
		msg.setSubject("中文主题");
		msg.setContent("<span style='color:red'>呵呵</span>", "text/html;charset=gbk");
		msg.setRecipients(RecipientType.TO, InternetAddress.parse("epdcsiman@163.com,835804205@qq.com"));
//		Transport.send(msg);
		//发送
		Transport.send(new MimeMessage(session, new FileInputStream("attachment/mail.txt")));
		
	}//编码 base64 qoute-printable
	
}
