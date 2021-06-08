package java_20210608;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
//		File f = new File("C:\\dev\\test\\2021\\05\\18\\apache-tomcat-9.0.46.zip");
		File f = new File("C:\\dev\\test\\2021\\05\\18\\apache.zip");
		
		long len = f.length(); //length() -- long type
		System.out.printf("%d %n", len);
		System.out.printf("%,dK %n", len/1024);
		
		String fileName = f.getName();
		System.out.printf("%s %n", fileName);
		
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		System.out.printf("%s %n", name); //파일명
		
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.printf("%s %n", extension); //확장자
		
		String parentPath = f.getParent();
		System.out.printf("%s %n", parentPath);
		
		File f2 = new File(parentPath, System.currentTimeMillis() + "." + extension); //파일명이 중복될 가능성이 낮아 이렇게 관리하기도 함.
		f.renameTo(f2);
		
	}
}
