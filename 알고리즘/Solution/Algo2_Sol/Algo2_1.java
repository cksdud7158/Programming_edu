import java.util.LinkedList;
import java.util.Scanner;

public class Algo2_1 {
	static LinkedList<Nod>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int x2 = sc.nextInt();				//밭의 가로
		int y2 = sc.nextInt();				//밭의 세로
		
		int N = sc.nextInt();				//자르는 횟수
		sc.nextLine();						//개행처리
		list = new LinkedList[N+1];			
		for(int i = 0 ; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		
		int x = 0;
		int y = 0;
		list[0].add(new Nod(0,x2,0,y2));   // 첫번째 밭 
		boolean flag = false;				// 가로 세로 자를 거 구분자
		
		
		for(int i = 0; i < N; i++) {		//자르는 횟수 만큼 입력 받고 자름
			String[] input = sc.nextLine().split(" ");		
			int cs = Integer.parseInt(input[0]);		//가로인지 세로인지 구분
			if(cs==0) {
				y = Integer.parseInt(input[1]);			//가로면 y를 구분 flag = true;
				flag = true;							
			} else {
				x = Integer.parseInt(input[1]);			//세로면 x를 구분 flag = false;
				flag =false;
			}
			while(!list[i].isEmpty()) {					//존재하면 짜름
				if(flag) {								//가로
					Nod now = list[i].poll();
//					System.out.println("i ==" + i);
//					System.out.println(now);
					if(now.y1<y && y < now.y2) {
						list[i+1].add(new Nod(now.x1,now.x2,now.y1,y));
						list[i+1].add(new Nod(now.x1,now.x2,y,now.y2));
					} else {
						list[i+1].add(now);
					}
				} else {
					Nod now = list[i].poll();
//					System.out.println("i ==" + i);
//					System.out.println(now);
					if(now.x1<x && x < now.x2) {
						list[i+1].add(new Nod(now.x1,x,now.y1,now.y2));
						list[i+1].add(new Nod(x,now.x2,now.y1,now.y2));
					} else {
						list[i+1].add(now);
					}
				}
			} // list[i]가 있을 때
		} // 가장 바깥 for
		int max = 0;
		for(Nod n : list[N]) {
			int s = (n.x2-n.x1) * (n.y2-n.y1);
//			System.out.println("i=="+ 3);
//			System.out.println(n);
			if(max < s) {
				max = s;
			}
		}
		System.out.println(max);
		
	}
	
	
	
	
	
	
}

class Nod{
	int x1,x2,y1,y2;
	Nod(int x1,int x2, int y1, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	@Override
	public String toString() {
		return "Nod [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + "]";
	}
	
	
}

