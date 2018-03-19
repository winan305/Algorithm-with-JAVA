import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0, T, N;
	static int[][] v = new int[2][100001];
	static int[][] dp = new int[2][100001];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			// input
			N = Integer.parseInt(in.readLine());
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 1; j <= N; j++)
					v[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = v[0][1];
			dp[1][1] = v[1][1];
			
			for(int j = 2; j <= N; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + v[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + v[1][j];
			}
			
			// output
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
