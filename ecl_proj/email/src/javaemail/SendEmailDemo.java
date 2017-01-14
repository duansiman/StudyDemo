package javaemail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.security.sasl.Provider;

public class SendEmailDemo {
	
	public static void main(String[] args) throws Exception {
		//配置信息
		Properties props = new Properties();
		//登入邮箱服务器是需要验证的
		props.setProperty("mail.smtp.auth", "true");
		//设置协议
		props.setProperty("mail.transport.protocol", "smtp");
		//环境信息
		Session session = Session.getInstance(props);
		//调试信息
		session.setDebug(true);
		//创建邮件信息
		Message msg = new MimeMessage(session);
		msg.setText("你好吗？");
		//发件人
		msg.setFrom(new InternetAddress("835804205@qq.com"));
		//发送
		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", 25, "835804205@qq.com", "00000");
		//下面这个静态send方法包括连接，发送和关闭三个步骤
		//transport.send(msg, new Address[]{new InternetAddress("835804205@qq.com")});
		transport.sendMessage(msg, new Address[]{new InternetAddress("835804205@qq.com")});
		transport.close();
		
	}
	
}
