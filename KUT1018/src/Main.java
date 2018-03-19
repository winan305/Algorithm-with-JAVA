import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			StringBuilder A = new StringBuilder(st.nextToken());
			StringBuilder B = new StringBuilder(st.nextToken());
			
			int len = A.length();
			int max = 0;
			for(int i = 0; i < B.length()-len+1; i++) {
				String tmp = B.substring(i, i+len);
				max = Math.max(max, getCount(A.toString(), tmp));
			}
			System.out.println(len-max);
		}
	}
	public static int getCount(String a, String b) {
		int cnt = 0;
		for(int i = 0; i < a.length(); i++)
			if(a.charAt(i) == b.charAt(i)) cnt++;
		return cnt;
	}
}
