package java_20210518;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			//1. FileInputStream과 FileOutputStream을 이용하여 1바이트 읽어서 1바이트 출력한 예제이고, 그 결과 경과시간은 46979ms이다.(11,756KB파일)
			fis = new FileInputStream("C:\\dev\\test\\2021\\05\\18\\apache-tomcat-9.0.46.zip");
			fos = new FileOutputStream("C:\\dev\\test\\2021\\05\\18\\apache-tomcat-9.0.46_copy.zip");
			
			/*
			int readByte = 0;
			long start = System.currentTimeMillis();
			while((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n", (end-start)); 
			*/
			
			
			//2. BufferedInputStream과 BufferedOutputStream을 이용하여 1바이트 읽어서 1바이트 출력한 예제이고, 경과시간은 310ms이다.
			// BufferedOutputStream의 버퍼(byte[]) 공간에 가득 차 있으면 출력한다. 만약 다 채워지지 않으면 출력하지 않음.
			// 이런경우 flush() 메서드를 호출하여 모두 출력해줘야 함.
			
			bis = new BufferedInputStream(fis,1024*100);
			bos = new BufferedOutputStream(fos,1024*100);
			int readByte = 0;
			long start = System.currentTimeMillis();
			while((readByte = bis.read()) != -1) {
				bos.write(readByte);
			}
			bos.flush();
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n", (end-start));
			
			
			//경과시간 : 16ms
			/*
			int readByteCount = 0;
			long start = System.currentTimeMillis();
			byte[] readBytes = new byte[1024*10];
			while((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n", (end-start));
			 */
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(fis!=null) fis.close();
					if(bis!=null) bis.close();
					if(fos!=null) fos.close();
					if(bos!=null) bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
