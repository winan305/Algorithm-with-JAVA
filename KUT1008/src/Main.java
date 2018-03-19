import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static ArrayList<Integer> res;
	static int A,B;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			int intPart = A/B;
			int flag = 0;
			res = new ArrayList<>();
			A = A%B;
			while(true) {
				if(A == 0) break;
				
				A *= 10;
				if(res.contains(A)) {
					flag = A;
					break;
				}
				res.add(A);
				A = A%B;
			}
			System.out.println(intPart + "" + getAnswer(flag));
		}
	}
	public static StringBuffer getAnswer(int flag) {
		StringBuffer sb;
		if(flag != 0) {
			int idx = res.indexOf(flag);
			sb = new StringBuffer(".");
			for(int i = 0; i < idx; i++)
				sb.append(res.remove(0)/B);
			sb.append("(");
			while(!res.isEmpty()) 
				sb.append(res.remove(0)/B);
			sb.append(")");
		}
		
		else {
			sb = new StringBuffer(".");
			while(!res.isEmpty())
				sb.append(res.remove(0)/B);
			sb.append("(0)");
		}
		return sb;
	}
}
