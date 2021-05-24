package java_20210503;

public class StarExam {

	public static void main(String[] args) {
		
		/*
			*
			**
			***
			****
			
			
			****
			***
			**
			*
			
		*/
		
		for(int i=1; i<5; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		System.out.println("");
		
		for(int i=1; i<5; i++) {
			for(int j=6; j-i>1; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		
	}
}
