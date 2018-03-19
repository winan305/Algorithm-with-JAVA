import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isPrime;
	static int[] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		isPrime = new boolean[10001];
		EratosthenesSieve(10000);
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(in.readLine());
			DP = new int[n+1];
			
			for(int i = 2; i <= n; i++) {
				if(!isPrime[i]) DP[i] = 1;
				for(int j = 2; j < i; j++)
					if(!isPrime[j] && !isPrime[i-j]) {
						DP[i] += 1;
					}
			}
			System.out.println(DP[n]);
		}
	}
	public static void EratosthenesSieve(int n) {
		isPrime[0] = isPrime[1] = true;
		for(int i = 2; i <= n; i++) {
			if(!isPrime[i])
				for(int j = i+i; j <= n; j+= i) {
					isPrime[j] = true;
				}
		}
	}
}
