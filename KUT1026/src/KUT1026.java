import java.io.*;
import java.util.*;

public class KUT1026 {
	static BufferedReader in;
	static StringTokenizer st;
	static int T;
	static StringBuilder sb;
	static Stack<Character> stack;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			String str = in.readLine();
			stack = new Stack<>();
			stack.push(str.charAt(0));
			for(int i = 1; i < str.length(); i++) {
				if(stack.isEmpty()) stack.push(str.charAt(i));
				else {
					char c = stack.pop();
					if(c == str.charAt(i)) continue;
					else {
						stack.push(c);
						stack.push(str.charAt(i));
					}
				}
			}
			sb = new StringBuilder();
			while(!stack.isEmpty())
				sb.append(stack.pop());
			System.out.println(sb.reverse());
		}
	}
}
