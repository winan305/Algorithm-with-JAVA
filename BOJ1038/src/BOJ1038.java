import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ1038 {
	static BufferedReader in;
	static int N;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		if(N < 11) System.out.println(N);
		else {
			int cnt = 10, i = 10; 
			while(cnt < N) {
				if(isDecreaseNumber(new BigInteger(i +""))) cnt++;
				i++;
			}
			System.out.println(i);
		}
		
	}
	public static boolean isDecreaseNumber(BigInteger number) {
		int buffer = number.mod(new BigInteger("10")).intValue();
		number = number.divide(new BigInteger("10"));
		while(!number.equals(new BigInteger("0"))) {
			if(number.mod(new BigInteger("10")).intValue() <= buffer) return false;
			buffer = number.mod(new BigInteger("10")).intValue();
			number = number.divide(new BigInteger("10"));
		}
		return true;
	}
}
