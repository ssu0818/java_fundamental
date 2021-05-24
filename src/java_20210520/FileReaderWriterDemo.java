package java_20210520;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
//			fw = new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemo_copy.java");
			fw = new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemo_copy.java", true); //true -> 이어쓰기 됨.
			
			/*
			int readChar = 0;
			//read() : 한 개의 문자를 읽는다.
			while((readChar = fr.read()) != -1) {
				System.out.print((char)readChar); //모니터
				//write() : 한 개의 문자를 쓴다.
				fw.write(readChar);
			}
			 */
			
			int readCharCount = 0;
			char[] readChars = new char[1024*10];
			
			while((readCharCount = fr.read(readChars)) != -1) {
				System.out.println(readChars);
				fw.write(readChars, 0, readCharCount); //fw.write(readChars); // 추가되어 출력됨. 원본과 다름.
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}
