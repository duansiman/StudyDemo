package base64Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {

	public static void main(String[] args) throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println("please input user name:");
		String userName = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		System.out.println(encoder.encode(userName.getBytes()));
		System.out.println("please input password:");
		String password = new BufferedReader(new InputStreamReader(System.in))
				.readLine();
		System.out.println(encoder.encode(password.getBytes()));
		
	}

}//freemx2.sinamail.sina.com.cn  125.221.225.110
