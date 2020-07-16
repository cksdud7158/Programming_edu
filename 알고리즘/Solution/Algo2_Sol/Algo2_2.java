import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_2 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int M;
	
	static class Node{
		int x; 
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		
		N = (N * 2) - 1;
		M = (M * 2) - 1;
		boolean[][] visited = new boolean[N][M];
		int cut = Integer.parseInt(br.readLine());
		int Answer = 0;
		for(int i = 0; i < cut; i++) {
			StringTokenizer tk1 = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(tk1.nextToken());
			int num = Integer.parseInt(tk1.nextToken());
			
			if(line == 0) {
				int x = (num * 2) - 1;
				for(int j = 0; j < M; j++) {
					visited[x][j] = true;
				}
				
			}else if(line == 1) {
				int y = (num * 2) - 1;
				for(int j = 0; j < N; j++) {
					visited[j][y] = true;
				}
			}		
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					int value = BFS(i, j, visited);
					Answer = Answer > value ? Answer : value;
				}
			}
		}
		System.out.println(Answer);
		
	}
	static int BFS(int i, int j , boolean[][] visited) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i,j));
		visited[i][j] = true;
		int result = 0;
		int col = 0; int row = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			col = col < y ? y : col;
			row = row < x ? x : row;
			
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k]; int ny = y + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visited[nx][ny]) continue;
				q.add(new Node(nx,ny));
				visited[nx][ny] = true;
			}					
		}
		col -= j;
		row -= i;
		col = (col / 2) + 1;
		row = (row / 2) + 1;
		
		result = col * row;
		return result;
	}

}
