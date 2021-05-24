package java_20210506.aa;

public class NoticeDemo {
	public static void main(String[] args) {
		Notice n = new Notice();
		
		n.number = 1; //public 접근 가능
		n.title = "공지사항 입니다 !"; //protected 접근 가능
		n.hit = 0; //default 접근 가능
		//n.regdate = "2021-05-06"; //private 접근 불가능
		
		
	}
}
