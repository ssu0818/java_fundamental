package java_20210524.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private String ip;
	private int port;
	
	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next(); 
	}
	
	public void run() {
		Socket socket = null;
		//char 2bytes 사용하기 위해 bufferedRead,write사용
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			//3. ip와 port로 서버에 접속을 시도한다.
			socket = new Socket(ip, port);
			System.err.println("서버와 접속 성공 :)");
			
/*
 * 메세지 하나만 전송 가능.
 			//6. Socket을 이용해서 서버와 통신할 수 있는 입출력 스트림 생성
			//6-1.
			String message = console("메세지> ");
			
			OutputStream out = socket.getOutputStream();
			osw = new OutputStreamWriter(out); // 1 -> 2bytes
			bw = new BufferedWriter(osw);

			bw.write(message);
			bw.newLine();
			bw.flush();
			
			//6-4.
			InputStream in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			String readLine = br.readLine();
			System.out.println("서버로부터 받은 메세지 : " + readLine);
			
 */
			//*타 컴퓨터 접속할 때 다른 한명이 서버 중단할때까지 접속하지 못함
			//6. Socket을 이용해서 서버와 통신할 수 있는 입출력 스트림 생성
			//6-1.			
			OutputStream out = socket.getOutputStream();
			osw = new OutputStreamWriter(out); // 1 -> 2bytes
			bw = new BufferedWriter(osw);

			//6-4.
			InputStream in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);

			System.out.println("[클라이언트 화면]");
			while(true) {
				String message = console("메세지> ");
				bw.write(message);
				bw.newLine();
				bw.flush();
				
				String readLine = br.readLine();
				System.out.println("서버로부터 받은 메세지 : " + readLine);
			}
		} catch (IOException e) {
			System.err.println("서버와 접속 실패 :(");
		}
	}
	
	public static void main(String[] args) {
		//cmd > ipconfig > IP주소 확인 
		new EchoClient("192.168.0.65", 3000).run();
//		new EchoClient("192.168.0.28", 3000).run(); //타 컴퓨터 
		
	}
}
