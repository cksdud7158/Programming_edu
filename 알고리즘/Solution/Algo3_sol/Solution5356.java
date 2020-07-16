import java.util.Scanner;

public class Solution5356{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		char[][] arr = null;
		String s = "";
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++){
			s = "";
			arr = new char[5][15];
			for(int i = 0 ; i < 5; i++) {
				char[] temp = sc.nextLine().toCharArray();
				for(int j = 0 ; j < temp.length; j++) {
					arr[i][j] = temp[j];
				}
			}
			for(int j = 0; j < arr[0].length; j++) {
				for(int i = 0; i < arr.length;i++) {
					if(arr[i][j] != '\u0000') {
						s += arr[i][j];
					}
				}
			}			
			System.out.println("#" + test_case  + " " + s);
		}
	}
}
/*
Input Data

2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx

------------------------

Output Data

#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x

*/