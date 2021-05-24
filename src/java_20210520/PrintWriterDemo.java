package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		
		try {
			fr = new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemo_copy3.java", true); //true : 이어쓰기
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true); //true : auto flush 
			
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				System.out.println(readLine); 
				pw.println(readLine);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(fr != null) fr.close();
					if(br != null) br.close();
					if(fw != null) fw.close();
					if(bw != null) bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
