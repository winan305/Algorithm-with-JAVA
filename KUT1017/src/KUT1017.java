import java.io.*;
import java.util.*;

public class KUT1017 {
	static BufferedReader in;
	static StringTokenizer st;
	static int T, N;
	static int[] moneys;
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(in.readLine());
			moneys = new int[N];
			DP = new int[2][N];
			st = new StringTokenizer(in.readLine());
			int i = 0, ans = 0;
			while(st.hasMoreTokens()) {
				moneys[i] = DP[0][i++] = Integer.parseInt(st.nextToken());
			}
			if(N == 1) ans = moneys[0];
			else if(N == 2) ans = moneys[0] + moneys[1];
			else if(N > 2) {
				DP[0][0] = DP[1][0] = moneys[0];
				DP[0][1] = moneys[1];
				DP[1][1] = moneys[0] + moneys[1];
				DP[0][2] = moneys[0] + moneys[2];
				DP[1][2] = moneys[1] + moneys[2];
				
				for(i = 2; i < N; i++)
					for(int j = 0; j <= i-2; j++)
						DP[0][i] = Math.max(DP[0][i], moneys[i] + DP[1][j]);
				
				for(i = 3; i < N; i++)
					for(int j = 0; j <= i-3; j++)
						DP[1][i] = Math.max(DP[1][i], moneys[i]+moneys[i-1] + DP[1][j]);
				
				for(i = 0; i < N; i++)
					ans = Math.max(ans, Math.max(DP[0][i],DP[1][i]));
			}
			System.out.println(ans);
		}
	}
}