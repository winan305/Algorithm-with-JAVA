import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			HashSet<Integer> set = new HashSet<>();
			while(st.hasMoreTokens()) {
				int item = Integer.parseInt(st.nextToken());
				if(set.contains(item)) set.remove(item);
				else set.add(item);
			}
			Iterator<Integer> iterator = set.iterator();
			int[] answer = new int[2];
			answer[0] = iterator.next();
			answer[1] = iterator.next();
			System.out.println(Math.min(answer[0], answer[1]) + " " + Math.max(answer[0], answer[1]));
		}
	}
}
