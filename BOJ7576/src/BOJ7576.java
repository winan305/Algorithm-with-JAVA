import java.util.*; 
import java.io.*;

class Tomato {
	int x, y;
	int day;
	
	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class BOJ7576 {
	static BufferedReader in;
	static StringTokenizer st;
	static int N, M;
	static int[][] tomatos;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatos = new int[N][M];
		int[] offsetX = {0,0,-1,1};
		int[] offsetY = {1,-1,0,0};
		int days = 0;
		Queue<Tomato> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				tomatos[i][j] = Integer.parseInt(st.nextToken());
				if(tomatos[i][j] == 1) queue.add(new Tomato(j,i,0));
			}
		}
		
		if(queue.size() == M*N) {
			System.out.println(0);
			return;
		}
		
		else if(queue.isEmpty()) {
			System.out.println(-1);
			return;
		}
		while(!queue.isEmpty()) {
			Tomato tomato = queue.remove();
			for(int i = 0; i < 4; i++) {
				int nextX = tomato.x + offsetX[i];
				int nextY = tomato.y + offsetY[i];
				if(isValid(nextX, nextY)) {
					tomatos[nextY][nextX] = 1;
					queue.add(new Tomato(nextX, nextY,tomato.day+1));
				}
			}
			days = tomato.day;
		}
		System.out.println(days);
	}
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0) return false;
		else if(x >= M || y >= N) return false;
		else if(tomatos[y][x] != 0) return false;
		return true;
	}
}
