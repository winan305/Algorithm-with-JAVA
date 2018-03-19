import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		int[] chocolates = new int[n];
		for(int i = 0; i < n; i++)
			chocolates[i] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		int cases = 0;
		for(int i = 0; i < n; i++) {
			if(chocolates[i] == 1) {
				answer += cases;
				cases = 1;
			}
			else if(chocolates[i] == 0 && cases >= 1)
				cases++;
		}
		System.out.println(answer);
	}
}