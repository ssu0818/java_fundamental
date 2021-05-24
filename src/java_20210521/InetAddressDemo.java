package java_20210521;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress i = InetAddress.getLocalHost();
		System.out.printf("호스트 이름: %s%n", i.getHostName());
		System.out.printf("IP: %s%n", i.getHostAddress());
		
		InetAddress i2 = InetAddress.getByName("naver.com");
		System.out.printf("호스트 이름: %s%n", i2.getHostName());
		System.out.printf("IP: %s%n", i2.getHostAddress());
		
		System.out.printf("%s", i2); // naver.com/125.209.222.141
	}
}
