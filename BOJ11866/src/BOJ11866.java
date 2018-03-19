import java.io.*;
import java.util.*;
public class BOJ11866 {
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++)
			queue.add(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0 ; i < M-1; i++)
				queue.add(queue.remove());
			
			int item = queue.remove();
			sb.append(item);
			if(!queue.isEmpty()) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}

}
