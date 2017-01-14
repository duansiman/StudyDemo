package javaemail;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MultipartEmailDemo {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");//指定验证
		props.setProperty("mail.transport.protocol", "smtp");//指定协议
		props.setProperty("mail.host", "smtp.163.com");//指定服务器域名
		Session session = Session.getInstance(props, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("epdcsiman@163.com", "****");//"e_lajiyouxiang@163.com", "e123456"
			}//指定连接服务器用户名和密码
		});
		session.setDebug(true);//打印调试信息
		MimeMessage msg = new MimeMessage(session);
		msg.setSubject("复杂邮件");//设置主题
		msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("传智播客") + "\"<epdcsiman@163.com>"));//发件人
		msg.setReplyTo(InternetAddress.parse("lili@163.com"));//辉回复人
		msg.setRecipients(RecipientType.TO, InternetAddress.parse("835804205@qq.com,epdcsiman@163.com"));//收件人
		
		MimeMultipart msgMultipart = new MimeMultipart("mixed");//只要填子类型混合类型，不要填成这样multipart/mixed
		msg.setContent(msgMultipart);//设置邮件内容 是个复杂内容
		MimeBodyPart content = new MimeBodyPart();//内容
		MimeBodyPart attch1 = new MimeBodyPart();//附件一
		MimeBodyPart attch2 = new MimeBodyPart();//附件二
		msgMultipart.addBodyPart(content);
		msgMultipart.addBodyPart(attch1);
		msgMultipart.addBodyPart(attch2);
		
		DataSource ds1 = new FileDataSource("attachment/attach1.txt");
		DataHandler dh1 = new DataHandler(ds1);
		attch1.setDataHandler(dh1);
		attch1.setFileName(
				MimeUtility.encodeText("attach1中文.txt")//解决乱码问题
														//根据文件名的内容选择是base64编码还是quote-printable编码
				);//设置下载文件名	
		
		DataSource ds2 = new FileDataSource("attachment/attach2.txt");
		DataHandler dh2= new DataHandler(ds2);
		attch2.setDataHandler(dh2);
		attch2.setFileName("attach2.txt");//设置下载文件名
		
		MimeMultipart bodyMultipart = new MimeMultipart("related");//依赖类型
		content.setContent(bodyMultipart);
		MimeBodyPart htmlPart = new MimeBodyPart();//html文本
		MimeBodyPart gifPart = new MimeBodyPart();//图片
		bodyMultipart.addBodyPart(htmlPart);
		bodyMultipart.addBodyPart(gifPart);
		
		DataSource gifds = new FileDataSource("image/happy.jpg");
		DataHandler gifdh = new DataHandler(gifds);
		gifPart.setDataHandler(gifdh);
		gifPart.setHeader("Content-Location", "image/happy.jpg");
		gifPart.setFileName("happy.jpg");
		
		htmlPart.setContent("呵呵 <img src='http://www.baidu.com/happy.jpg'>", "text/html;charset=gbk");
		
		msg.saveChanges();//生成
		Transport.send(msg);
		
		OutputStream ops = new FileOutputStream("result/result.txt");
		msg.writeTo(ops);
		ops.close();
	}
	
}
