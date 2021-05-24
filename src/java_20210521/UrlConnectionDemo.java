package java_20210521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
//		URL url = new URL("https://sports.news.naver.com/news.nhn?oid=241&aid=0003119705");
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=001&aid=0012407845");
		URLConnection urlCon = url.openConnection();
		
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		
		System.out.println("cache-control : " + cacheControl);
		System.out.println("content-type : " + contentType);
		System.out.println("date : " + date);
		
		InputStream in = urlCon.getInputStream();
//		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		InputStreamReader isr = new InputStreamReader(in, "euc-kr");
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
		}
		
		
	}
}
