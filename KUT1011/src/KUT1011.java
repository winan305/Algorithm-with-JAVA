import java.io.*;
import java.util.*;

public class KUT1011 {
	static BufferedReader in;
	static StringTokenizer st;
	static int T, N;
	static int[] bridge;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(in.readLine());
			bridge = new int[N];
			st = new StringTokenizer(in.readLine());
			int i = 0;
			while(st.hasMoreTokens() && N > 0) {
				bridge[i] = Integer.parseInt(st.nextToken());
				if(i >= 3)
					bridge[i] += Math.min(bridge[i-1], Math.min(bridge[i-2], bridge[i-3]));
				i++;
			}
	
			if(N < 3) System.out.println(0);
			else {
				int ans = Integer.MAX_VALUE;
				int n = N-1;
				while(n >= 0 && n >= N-3)
						ans = Math.min(ans, bridge[n--]);
				System.out.println(ans);
			}
		}
	}
}
