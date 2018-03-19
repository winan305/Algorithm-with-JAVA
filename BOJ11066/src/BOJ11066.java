import java.io.*;

public class BOJ11066 { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] LCS1 = br.readLine().toCharArray();
		char[] LCS2 = br.readLine().toCharArray();
		int n = LCS1.length;
		int m = LCS2.length;
		br.close();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				if(LCS1[i] == LCS2[j])
					dp[i+1][j+1] = dp[i][j] + 1;
				else
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		System.out.print(dp[n][m]);
    }
}