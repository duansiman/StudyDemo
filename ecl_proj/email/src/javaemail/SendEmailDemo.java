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
		//������Ϣ
		Properties props = new Properties();
		//�����������������Ҫ��֤��
		props.setProperty("mail.smtp.auth", "true");
		//����Э��
		props.setProperty("mail.transport.protocol", "smtp");
		//������Ϣ
		Session session = Session.getInstance(props);
		//������Ϣ
		session.setDebug(true);
		//�����ʼ���Ϣ
		Message msg = new MimeMessage(session);
		msg.setText("�����");
		//������
		msg.setFrom(new InternetAddress("835804205@qq.com"));
		//����
		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", 25, "835804205@qq.com", "00000");
		//���������̬send�����������ӣ����ͺ͹ر���������
		//transport.send(msg, new Address[]{new InternetAddress("835804205@qq.com")});
		transport.sendMessage(msg, new Address[]{new InternetAddress("835804205@qq.com")});
		transport.close();
		
	}
	
}
