import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, answer;
	static int[][] map;
	static int[] off_x = {0, 0, -1, 1}, off_y = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		answer = 0;
		
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < n; i++) {
			boolean isCan = false;
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) isCan = true;
				else if(isCan) answer++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			boolean isCan = false;
			for(int j = m-1; j >= 0; j--) {
				if(map[i][j] == 1) isCan = true;
				else if(isCan) answer++;
			}
		}
		
		for(int i = 0; i < m; i++) {
			boolean isCan = false;
			for(int j = 0; j < n; j++) {
				if(map[j][i] == 1) isCan = true;
				else if(isCan) answer++;
			}
		}
		
		for(int i = 0; i < m; i++) {
			boolean isCan = false;
			for(int j = n-1; j >= 0; j--) {
				if(map[j][i] == 1) isCan = true;
				else if(isCan) answer++;
			}
		}
		System.out.println(answer);
	}
}
