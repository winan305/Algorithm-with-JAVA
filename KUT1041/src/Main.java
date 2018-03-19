import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static int N, answer;
	static int[] xs, ys;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		xs = new int[N]; ys = new int[N];
		answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xs); Arrays.sort(ys);
		int avg_x = xs[N/2], avg_y = ys[N/2];
		for(int i = 0; i < N; i++) {
			answer = answer + Math.abs(avg_x - xs[i]) + Math.abs(avg_y - ys[i]);
		}
		System.out.println(answer);
	}
}
