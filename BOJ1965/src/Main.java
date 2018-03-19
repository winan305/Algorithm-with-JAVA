import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0, N;
	static int[] v = new int[1001];
	static int[] dp = new int[1001];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		// input
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
		
		// solve
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(v[j] < v[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
			}
		}
		
		// output
		for(int i = 0; i < N; i++)
			answer = Math.max(answer, dp[i]);
		
		System.out.println(answer);
	}
}
