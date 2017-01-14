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
		props.setProperty("mail.smtp.auth", "true");//ָ����֤
		props.setProperty("mail.transport.protocol", "smtp");//ָ��Э��
		props.setProperty("mail.host", "smtp.163.com");//ָ������������
		Session session = Session.getInstance(props, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("epdcsiman@163.com", "****");//"e_lajiyouxiang@163.com", "e123456"
			}//ָ�����ӷ������û���������
		});
		session.setDebug(true);//��ӡ������Ϣ
		MimeMessage msg = new MimeMessage(session);
		msg.setSubject("�����ʼ�");//��������
		msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("���ǲ���") + "\"<epdcsiman@163.com>"));//������
		msg.setReplyTo(InternetAddress.parse("lili@163.com"));//�Իظ���
		msg.setRecipients(RecipientType.TO, InternetAddress.parse("835804205@qq.com,epdcsiman@163.com"));//�ռ���
		
		MimeMultipart msgMultipart = new MimeMultipart("mixed");//ֻҪ�������ͻ�����ͣ���Ҫ�������multipart/mixed
		msg.setContent(msgMultipart);//�����ʼ����� �Ǹ���������
		MimeBodyPart content = new MimeBodyPart();//����
		MimeBodyPart attch1 = new MimeBodyPart();//����һ
		MimeBodyPart attch2 = new MimeBodyPart();//������
		msgMultipart.addBodyPart(content);
		msgMultipart.addBodyPart(attch1);
		msgMultipart.addBodyPart(attch2);
		
		DataSource ds1 = new FileDataSource("attachment/attach1.txt");
		DataHandler dh1 = new DataHandler(ds1);
		attch1.setDataHandler(dh1);
		attch1.setFileName(
				MimeUtility.encodeText("attach1����.txt")//�����������
														//�����ļ���������ѡ����base64���뻹��quote-printable����
				);//���������ļ���	
		
		DataSource ds2 = new FileDataSource("attachment/attach2.txt");
		DataHandler dh2= new DataHandler(ds2);
		attch2.setDataHandler(dh2);
		attch2.setFileName("attach2.txt");//���������ļ���
		
		MimeMultipart bodyMultipart = new MimeMultipart("related");//��������
		content.setContent(bodyMultipart);
		MimeBodyPart htmlPart = new MimeBodyPart();//html�ı�
		MimeBodyPart gifPart = new MimeBodyPart();//ͼƬ
		bodyMultipart.addBodyPart(htmlPart);
		bodyMultipart.addBodyPart(gifPart);
		
		DataSource gifds = new FileDataSource("image/happy.jpg");
		DataHandler gifdh = new DataHandler(gifds);
		gifPart.setDataHandler(gifdh);
		gifPart.setHeader("Content-Location", "image/happy.jpg");
		gifPart.setFileName("happy.jpg");
		
		htmlPart.setContent("�Ǻ� <img src='http://www.baidu.com/happy.jpg'>", "text/html;charset=gbk");
		
		msg.saveChanges();//����
		Transport.send(msg);
		
		OutputStream ops = new FileOutputStream("result/result.txt");
		msg.writeTo(ops);
		ops.close();
	}
	
}
