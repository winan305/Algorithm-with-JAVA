import java.io.*;
import java.util.*;

public class Main {
	static boolean answer;
	static int[] numbers = new int[3001];
	static int N;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(in.readLine());
			
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		
		
	
	}
}
