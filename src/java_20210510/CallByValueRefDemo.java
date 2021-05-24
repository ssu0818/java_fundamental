package java_20210510;

public class CallByValueRefDemo {
	
	public static void ascending(int[] temp) { //public static int[] ascending(int[] temp) { // return할 필요 없음.
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length - (i + 1); j++) {
				if (temp[j] > temp[j + 1]) {
					int temp2 = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = temp2;
				}
			}
		}
	}
	
	public static void change(int i, int[] j) {
		i = 20;
		j[3] = 400;
	}

	public static void main(String[] args) {
		int i = 10;
		int[] j = { 1, 2, 3, 4 };
		System.out.println(i + "," + j[3]);
		change(i, j); //인자가 primitive(저장함, 참조x), reference(참조함)에 따라 변경 유무 다름.
		System.out.println(i + "," + j[3]);
		
		
		int[] lotto = {3,5,12,45,23,1};
		ascending(lotto); //call by reference의 장점.
		//int[] lotto2 = ascending(lotto);
		//for(int value : lotto2){
		for(int value : lotto) {
			System.out.print(value + "\t");
		}
	}
}
