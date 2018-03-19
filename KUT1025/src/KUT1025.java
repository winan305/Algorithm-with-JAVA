import java.io.*;
import java.util.*;

public class KUT1025 {
	static BufferedReader in;
	static StringTokenizer st;
	static int T;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			String str = in.readLine();
			char buffer = str.charAt(0);
			int cnt = 1, max = 1, len = str.length();
			
			for(int i = 1; i < len; i++) {
				char c = str.charAt(i);
				if(c == buffer) cnt++;
				else {
					cnt = 1;
					buffer = c;
				}
				max = Math.max(cnt, max);
			}
			System.out.println(len-max);
		}
	}
}