import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) 
			System.out.println(changeEndian(Integer.parseInt(in.readLine())));
	}
	public static int changeEndian(int n) {
		int[] orders = new int[32];
		for(int i = 3; i >= 0; i--) {
			for(int j = i*8; j < (i+1)*8; j++) {
				orders[j] = (n & 1) == 1 ? 1 : 0;
				n = n>>1;
			}
		}
		int result = 0, bin = 1;
		for(int i = 0; i < 32; i++) {
			result += (orders[i] * bin);
			bin *= 2;
		}
		return result;
	}
}
