import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		
		int[] cheese = new int[n];
		for(int i = 0; i < n; i++)
			cheese[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(cheese);
		
		int answer = 0;
		for(int i = 0; i < n; i += 2)
			answer += cheese[i];
		
		System.out.print(answer);
	}
}
