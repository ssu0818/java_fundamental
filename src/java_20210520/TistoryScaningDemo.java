package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TistoryScaningDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://jamesdreaming.tistory.com/99");
		
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
//		InputStreamReader isr = new InputStreamReader(in,"utf-8");
		BufferedReader br = new BufferedReader(isr); //한줄단위로 읽을 수 있음
		
		FileWriter fw = new FileWriter("C:\\Users\\user\\tistory.html");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String readLine = null;
		while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			bw.write(readLine);
			bw.newLine();
		}
		bw.flush();
	}
}
