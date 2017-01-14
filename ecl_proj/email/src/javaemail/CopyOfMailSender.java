package javaemail;

import java.util.Date;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;

public class CopyOfMailSender {

	public static void main(String[] args) throws Exception {

		String host = "smtp.exmail.qq.com";
		int port = 25;
		String username = "xxxx";
		String password = "uyyyy";

		String content = "测试发邮件";

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost(host);
//		mailSender.setPort(port);
//		mailSender.setUsername(username);
//		mailSender.setPassword(password);
//		mailSender.setJavaMailProperties(javaMailProperties);
		String email = "xxxx@qq.com";
		String tousername = "yyyy";
		for (int i = 0; i < 100; i++) {
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper help = new MimeMessageHelper(message, true,
//					"UTF-8");
//			help.setFrom(username);
//			help.setTo(new String[] { email });
//			help.setSubject("测试发个邮件");
//			Date date = new Date();
//			String _content = content.replace("${date}", date.toLocaleString());
//			_content = content.replace("${tousername}", tousername);
//			help.setText(_content, true);
//			mailSender.send(message);
		}
	}

}