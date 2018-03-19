import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String[] code = {"000001","000010", "000100", "001000","010000", "100000"};
		while(T-- > 0) {
			boolean isValid = false;
			String ID = in.readLine();
			
			String region = ID.substring(0, 6);
			int birth = Integer.parseInt(ID.substring(6, 14));
			String order = ID.substring(14, 17);
			int checksum = ID.charAt(17) == 'X' ? 10 : ID.charAt(17) - '0';
			for(int i = 0; i < code.length; i++)
				if(region.equals(code[i])) isValid = true;
			if(isValid) {
				isValid = birth >= 19000101 && birth <= 20141231 ? true : false;
			}
			if(isValid) {
				isValid = !order.equals("000") && checksum == getChecksum(ID.substring(0,17)) ? true : false;
			}
			if(isValid) {
				if(Integer.parseInt(order)%2 == 0) System.out.println("Female");
				else System.out.println("Male"); 
			}
			else System.out.println("Invalid");
		}
	}
	
	public static int getChecksum(String body) {
		int checksum = 0;
		int bin = 2;
		for(int i = body.length()-1; i >= 0; i--) {
			checksum = checksum + (body.charAt(i) -'0') * bin;
			bin *= 2;
		}
		return checksum%11;
	}
}
