package java_20210518;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//매개변수 path에 파일이 존재하지 않으면 예외 발생. 이때 경로와 파일명을 같이 살펴봐야함.
			fis = new FileInputStream("c:\\dev\\test\\2021\\05\\18\\images.jpeg");
			//매개변수 path의 디렉터리가 존재하지 않으면 예외 발생. 예외가 발생하지 않고 객체가 생성되면 파일을 생성한다. 이때 무조건 빈파일을 생성함
			fos = new FileOutputStream("c:\\dev\\test\\2021\\05\\18\\images_copy.jpeg");
			
			/*
			int readByte = 0;
			long start = System.currentTimeMillis();
			//read()는 1바이트 읽어서 읽은 바이트를 반환한다.
			while((readByte = fis.read()) != -1) { //모니터 or 파일에 출력할지 정해
				//write()는 1바이트 쓰기를 한다.
				fos.write(readByte);
			}
			long end = System.currentTimeMillis();
//			System.out.printf("경과시간 : %d초 %n", (end-start)/1000);
			System.out.printf("경과시간 : %d %n", (end-start));
			*/
			
			int readByteCount = 0;
			long start = System.currentTimeMillis();
			byte[] readBytes = new byte[1024*100]; //배열을 늘려도 속도가 빨라지는 것은 아님.
			while((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes,0,readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n", (end-start));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(fis != null) fis.close();
					if(fos != null) fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
