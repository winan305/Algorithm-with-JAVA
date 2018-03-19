import java.io.*;
import java.util.*;

public class KUT1057 {
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int winNum = N-1;
			if(winNum%(K+1) == 0) System.out.println(-1);
			else {
				System.out.println(winNum%(K+1));
			}
		}
	}
}
