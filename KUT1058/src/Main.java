import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int C = Integer.parseInt(in.readLine());
			int[] value = new int[N];
			int[] dp = new int[C+1];
			for(int i = 0; i < N; i++) {
				int v = Integer.parseInt(st.nextToken());
				value[i] = v;
			}
			dp[0] = 1;
			for(int i = 0; i < N; i++) {
				for(int j = value[i]; j <= C; j++)
						dp[j] = dp[j]%1000000007 + dp[j-value[i]]%1000000007;
			}
			System.out.println(dp[C]%1000000007);
		}
    }
}