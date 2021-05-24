package java_20210521;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {
		String url = "http://www.imbc.com/";
		
		//HTML문서를 관리하기 위한 객체
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			System.out.println("성공 :D");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements elements = doc.select(".notice-list li");
		for(Element element : elements) {
			System.out.println(element.text());
		}
	}
}
