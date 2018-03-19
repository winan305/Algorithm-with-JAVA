import java.util.*;
import java.io.*;

public class BOJ2661 {
	static BufferedReader in;
	static boolean isFind;
	static int N;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		isFind = false;
		StringBuilder sb = new StringBuilder();
		backtracking(0, sb);
	}
	public static void backtracking(int n, StringBuilder sb) {
		if(!isGood(sb) || isFind) return;
		if(n == N) {
			isFind = true;
			System.out.println(sb);
			return;
		}
		for(int i = 1; i <= 3; i++) {
			sb.append(i);
			backtracking(n+1, sb);
			sb.deleteCharAt(n);
		}
	}
	
	public static boolean isGood(StringBuilder sb) {
		int length = sb.length();
		for(int l = 1; l <= length/2; l++) {
			for(int j = 0, k = l; (k+l) <= length; j++, k++) {
				String left = sb.substring(j, k);
				String right = sb.substring(j+l, k+l);
				if(left.equals(right)) return false;
			}
		}
		return true;
	}
}
