package array.test1;

class ArrayExam{
	String type="배열";
	public String type() {
		return type;
	}
}
public class ArrayBasicTest1 {
	public static void main(String[] args) {
		ArrayExam exam = new ArrayExam();
		//1. 선언과 생성
		int[ ] arr = new int[3];//   |0|0|0|
		
		/*for(int i=0; i<arr.length; i++) {//length() 가 아니다.
			System.out.print(arr[i]+" ");
		}*/
		
		System.out.println("=== Default Value ====");
		//향상된 for문...뭐가 어디안에서 돌아가는가?
		for(int val : arr) System.out.print(val+" ");
		//FQCN(Full Qualified Class Name)
		System.out.println("\n"+exam);
		System.out.println("\n"+exam.toString());
		
		System.out.println(arr);
		
		//2. 배열의 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		for(int val : arr) System.out.print(val+" ");
		System.out.println(" ");
		
		//3. 선언 + 생성 + 초기화를 한꺼번에
		int [ ] arr2 = {11,22,33};
		for(int val : arr2) System.out.print(val+" ");
		System.out.println("\n arr2 배열의 크기 "+arr2.length); //3
		
		//4. arr2
		/*
		 * 배열은 Resizing이 안된다.
		 * 만약에 사이즈를 변경하면 새로운 배열객체가 생성...
		 */
		arr2 = new int[5];
		arr2[3] = 44; arr2[4] = 55; 
		for(int val : arr2) System.out.println(val+" ");
	}
}












