import java.io.*;
import java.util.*;

public class BOJ5430 {
	static BufferedReader in;
	static int T;
	static Deque<String> deque;
	static final int LEFT = 0, RIGHT = 1;
	static int direction;
	static boolean isError;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			String p = in.readLine();
			int n = Integer.parseInt(in.readLine());
			String array = in.readLine();
			StringTokenizer st = new StringTokenizer(array.substring(1, array.length()-1), ",");
			deque = new LinkedList<>();
			direction = LEFT;
			isError = false;
			while(st.hasMoreTokens())
				deque.add(st.nextToken());
			
			int i = 0;
			while(!isError && i < p.length()) {
				if(p.charAt(i) == 'D') order_D();
				else if(p.charAt(i) == 'R') order_R();
				i++;
			}
			if(isError) System.out.println("error");
			else printDeque();
		}
	}
	public static void order_R() {
		direction = direction == LEFT ? RIGHT : LEFT;
	}
	public static void order_D() {
		if(deque.isEmpty()) {
			isError = true;
			return;
		}
		if(direction == LEFT) deque.removeFirst();
		else deque.removeLast();
	}
	
	public static void printDeque() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(direction == LEFT) while(!deque.isEmpty()) {
			sb.append(deque.removeFirst());
			if(!deque.isEmpty()) sb.append(",");
		}
		else while(!deque.isEmpty()) { 
			sb.append(deque.removeLast());
			if(!deque.isEmpty()) sb.append(",");
		}

		sb.append("]");
		System.out.println(sb);
	}
}
