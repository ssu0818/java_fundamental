package java_20210507;

public class MethodDemo {
	//static 안붙음 > 인스턴스 메서드 > 반환값 있는경우, 없는경우(void)로 나뉨
	
	//달력
	public void print(int year, int month) { //출력만 하면 되므로 반환값 x => void
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		boolean isLeafYear = isLeafYear(year);
		if(isLeafYear){
			monthArray[1] = 29;
		}
		for(int i=1; i<=monthArray[month-1] ; i++) {
			System.out.print(i+"\t");
			if(i%7==0) System.out.println();
		}		
	}
	
	//오름차순 배열
	public int[] ascending(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length-(i+1); j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	//윤년 
	public boolean isLeafYear(int year){
		return year%4==0 && year%100!=0 || year%400==0;
	}
	
	//덧셈
	public int plus(int first, int second) { //first, second => 매개변수(parameter)
		return first + second;
	}
	
	
	
	public static void main(String[] args) {
		MethodDemo m = new MethodDemo();
		int sum = m.plus(10, 20); //10, 20 => 인자(argument)
		System.out.printf("덧셈 >> %d %n", sum);
		
		boolean leafYear =m.isLeafYear(2020);
		System.out.printf("윤년인가유? %s %n", leafYear);
		
		int[] test = {10,20,1,30,4,89,100,25};
		int[] afterTest = m.ascending(test);
		System.out.print("오름차순 정렬 결과 : ");
		for(int i=0; i<afterTest.length; i++) {
			System.out.print(afterTest[i] + "\t");
		}
		System.out.println("\n");
		
		
		m.print(2020, 4);
		
	}	
}
