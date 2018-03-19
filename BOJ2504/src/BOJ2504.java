import java.io.*;
import java.util.*;

public class BOJ2504 {
	static BufferedReader in;
	static Stack<Integer> stack;
	static int mul = 0, sum = 0;
	static boolean isMatch = true;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		
		String brackets = in.readLine();
		
		int i = 0;
		while(isMatch && i < brackets.length()) {
			switch(brackets.charAt(i)) {
				case '(' : {
					sum += mul;
					mul = 1;
					stack.push(2);
					break;
				}
				case '[' : {
					sum += mul;
					mul = 1;
					stack.push(3);
					break;
				}
				case ')' : {
					int val = stack.pop();
					if(val != 2)
						isMatch = false;
					else {
						if(stack.isEmpty()) sum += (sum * val);
						else mul *= val;
					}
					break;
				}
				case ']' : {
					int val = stack.pop();
					if(val != 3)
						isMatch = false;
					else {
						if(stack.isEmpty()) sum += (sum * val);
						else mul *= val;
					}
					break;
				}
			}
			i++;
		}
		if(isMatch) System.out.println(sum);
		else System.out.println(0);
	}
}