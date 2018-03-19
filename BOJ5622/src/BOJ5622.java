import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622 {
	static BufferedReader in;
	static int[] time = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String dial = in.readLine();
		
		for(int i = 0; i < dial.length(); i++) 
			answer += time[dial.charAt(i) - 'A'];
		
		System.out.println(answer);
	}
}
