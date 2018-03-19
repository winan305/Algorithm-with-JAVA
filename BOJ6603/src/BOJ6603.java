import java.io.*;
import java.util.*;

public class BOJ6603 {
	static int k = 1;
	static BufferedReader in;
	static StringTokenizer st;
	static int[] list;
	static final int LIMIT = 6;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));

		while(k != 0) {
			st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			list = new int[k];
			for(int i = 0; i < k; i++) 
				list[i] = Integer.parseInt(st.nextToken());
				
			for(int i = 0; i <= k - LIMIT; i++)
				backtracking(i, 1, new StringBuilder(""));
			System.out.println();
		}
	}
	public static void backtracking(int index, int count, StringBuilder sb) {
		if(count == LIMIT) {
			System.out.println(sb.append(list[index]));
			return;
		}
		else if(k-1-index+count < LIMIT) return;
		
		for(int i = index+1; i < k; i++) {
			StringBuilder next = new StringBuilder(sb);
			backtracking(i, count+1, next.append(list[index] + " "));
		}
	}
}
