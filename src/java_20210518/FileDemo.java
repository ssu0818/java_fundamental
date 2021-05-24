package java_20210518;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FileDemo {

	public static String format(File f) {
		//1970년 1월 1일 00:00:00초부터 파일을 수정한 날까지의 시간을 밀리세컨드로 반환
		long lastModified = f.lastModified();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(lastModified);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String format = sdf.format(cal.getTime());
		return format;
	}
	
	
	public static void main(String[] args) {
		File f1 = new File("c:\\dev\\test\\2021\\05\\18");
		
		if(f1.mkdirs()) {
			System.out.println("디렉터리를 생성했습니다 :D");
		}else {
			System.out.println("이미 존재하는 디렉터리입니다 :( ");
		}
		
		File f2 = new File("c:\\dev\\test\\2021\\05\\18\\images.jpeg");
		long len = f2.length();
		System.out.printf("%,dKB %n", len/1024);

		
		boolean isFile = f2.isFile(); //isDirectory()
		if(isFile) {
			String path = f2.getPath();
//			System.out.println(path);
			if(path.endsWith("zip")){
				System.out.println("압축파일입니다.");
			}else if(path.endsWith("jpeg")){
				System.out.println("이미지파일입니다.");
			}else if(path.endsWith("txt")){
				System.out.println("텍스트파일입니다.");
			}else if(path.endsWith("java")){
				System.out.println("자바파일입니다.");
			}
		}else {
			System.out.println("디렉터리입니다.");
		}
		
		
//		System.out.println(format(f2));

		
		File f3 = new File("c:\\dev\\test\\2021\\05\\18\\images2.jpeg"); 
		File f4 = new File("c:\\dev\\test\\2021\\05\\18\\images3.jpeg"); 
//		File f4 = new File("c:\\dev\\test\\2021\\05\\18, images3.jpeg"); 
		f3.renameTo(f4); // f3파일을 f4파일 이름으로 변경
		
		String path = f4.getPath();
		String parent = f4.getParent();
		String name = f4.getName();
		System.out.printf("%s, %s, %s", path, parent, name);
		
		f4.delete();
		
		
		File f5 = new File("C:\\Users\\user\\eclipse-workspace\\Java_Fundamental");
		File[] files = f5.listFiles(); 
		for(int i=0; i<files.length; i++) {
			File f = files[i];
			if(f.isDirectory()) {
				String lastModified = format(f);		
				String fileName = f.getName();
				System.out.printf("%s, %s, 파일폴더 %n", fileName, lastModified);
			}else if(f.isFile()) {
				String lastModified = format(f);
				String fileName = f.getName();
				long fileSize = f.length();
				System.out.printf("%s, %s, 파일, %,dB  %n", fileName, lastModified, fileSize);
			}
		}
	}
}
