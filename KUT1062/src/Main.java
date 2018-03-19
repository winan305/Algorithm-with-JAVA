import java.io.*;

public class Main {
	static BufferedReader in;
	static int T, N;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(in.readLine());
			if(N == 0) {
				System.out.println(-1);
				continue;
			}
			StringBuilder sb = new StringBuilder();
			int pos = 0, i = 1;
			while(i <= N && pos < 32) {
				if((N & i) == i) sb.append(pos + " ");
				i*=2; pos++;
			}
			System.out.println(sb.substring(0, sb.length()-1));
		}
	}
}
