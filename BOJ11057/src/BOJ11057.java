import java.io.*;
import java.util.*;
	
public class BOJ11057 {
	static BufferedReader in;
	static int[][] DP;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		DP = new int[N+1][10];
		for(int i = 0; i < 10; i++)
			DP[1][i] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					DP[i][j] += DP[i-1][k];
					DP[i][j] %= 10007;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 10; i++) {
			ans += DP[N][i];
			ans %= 10007;
		}
		System.out.println(ans);
	}
}