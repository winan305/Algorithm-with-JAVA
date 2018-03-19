import java.io.*;
import java.util.*;

public class KUT1003 {
	static BufferedReader in;
	static StringTokenizer st;
	static int[] array;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		array = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(array);
		
		int answer = 0;
		int prev = array[0] - 123;
		int next = array[N-1] + 123;
		for(int i = 0; i <= N-3; i++) {
			if(prev == array[i]) continue;
			prev = array[i];
			
			int j = i+1, k = N-1;
			next = array[k] + 123;
			
			while(j < k) {
				int sum = array[i] + array[j] + array[k];
				if(sum == 0) {
					if(next != array[k]) {
						next = array[k];
						answer++;
					}
					k--;
					j++;
				}
				else if(sum > 0) k--;
				else j++;
			}
		}
		System.out.println(answer);
	}
}