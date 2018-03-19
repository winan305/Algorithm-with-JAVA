import java.io.*;
import java.util.*;
public class BOJ1085 {
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// w-x, x, h-y, y
		
		int minX = Math.min(w-x, x);
		int minY = Math.min(h-y, y);
		
		System.out.println(minX < minY ? minX : minY);
	}
}
