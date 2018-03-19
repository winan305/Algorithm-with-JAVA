import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0, R, C, W;
	static int[][] pascal = new int[31][31];
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// 1 <= R <= 29
		// 1 <= C <= 29
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		pascal[1][1] = 1;
		for(int i = 2; i <= R+W; i++) {
			for(int j = 1; j <= i; j++) {
				if(i == 1 || j == i) pascal[i][j] = 1;
				else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		
		for(int i = R, cnt = 1; i < R+W; i++, cnt++) {
			for(int j = C; j < C+cnt; j++) {
				answer += pascal[i][j];
				System.out.print(pascal[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(answer);
	}
}
