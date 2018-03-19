import java.io.*;

public class KUT1065 {

	public static void main(String[] args) throws IOException{
		int T;
		String input;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			input = in.readLine().toLowerCase();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c >='a' && c <= 'z') sb.append(c);
			}
			String seq = sb.toString();
			String reversed = sb.reverse().toString(); 
			System.out.println(seq.equals(reversed));
		}
	}
}
