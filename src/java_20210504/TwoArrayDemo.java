package java_20210504;

public class TwoArrayDemo {

	public static void main(String[] args) {
		//2차원 배열의 선언과 생성
		int[][] a = new int [3][2];
		
		//2차원 배열의 할당
		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		
		int[][] b = {{10,20},{30,40},{50,60}};
		
		//2차원 배열의 출력
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}
		
		int[] temp = {10,20,30,40,50};
		
		for(int name:temp) {
			System.out.println(name);
		}
		
		String[] fruits = {"banana", "melon", "strawberry"};
		
		for(String f:fruits) {
			System.out.println(f);
		}
		
	}

}