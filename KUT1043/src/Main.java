import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static int W, H, answer;
	static int[][] map;
	static int[] off_x = {0, 0, -1, 1}, off_y = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		answer = 0;
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
	
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			String input = in.readLine();
			for(int j = 0; j < W; j++)
				map[i][j] = input.charAt(j);
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++)
				if(map[i][j] == '*') {
					answer = Math.max(answer, bfs(i,j));
				}
		}
		
		System.out.println(answer);
	}
	
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0 || x >= H || y >= W) return false;
		else if(map[x][y] == '.') return false;
		return true;
	}
	
	public static int bfs(int x, int y) {
		map[x][y] = '.';
		int area = 1;
		
		Queue<Integer> xs = new LinkedList<>();
		Queue<Integer> ys = new LinkedList<>();
		xs.add(x); ys.add(y);
		
		while(!(xs.isEmpty() && ys.isEmpty())) {
			int now_x = xs.poll();
			int now_y = ys.poll();
			
			for(int i = 0; i < 4; i++) {
				int next_x = now_x + off_x[i];
				int next_y = now_y + off_y[i];
				
				if(isValid(next_x, next_y)) {
					area++;
					xs.add(next_x); ys.add(next_y);
					map[next_x][next_y] = '.';
				}
			}
		}
		return area;
	}
}
