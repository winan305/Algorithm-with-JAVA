import java.io.*;

public class BOJ2941 {
	static BufferedReader in;
	static String[] croatians = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		String word = in.readLine();
		for(int i = 0; i < croatians.length; i++)
			word = word.replace(croatians[i], " ");

		System.out.println(word.length());
	}
}
