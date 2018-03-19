import java.io.*;
import java.util.*;

public class BOJ11403 {
	static BufferedReader in;
	static StringTokenizer st;
	static int[][] map;
	static int N;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		inputMap();
		solve();
		printMap();
	}
	
	public static void inputMap() throws IOException{
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void solve() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
					for(int k = 0; k < N; k++)
						if(map[j][i] == 1 && map[i][k] == 1) map[j][k] = 1;
	}
	
	public static void printMap() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}