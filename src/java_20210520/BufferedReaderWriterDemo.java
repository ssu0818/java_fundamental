package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemo_copy2.java");
			bw = new BufferedWriter(fw);
			
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				System.out.println(readLine); //print하면 개행x
//				bw.write(readLine+"\r\n"); //이렇게 사용해도 되지만 유닉스에서 적용x...
				bw.write(readLine); //readLine 변수에는 개행을 포함x
				bw.newLine(); //개행을 넣어준다.(window:\r\n, unix:\n)
			} 
			bw.flush();
			
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
