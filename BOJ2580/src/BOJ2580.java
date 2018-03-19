import java.io.*;
import java.util.*;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
}
public class BOJ2580 {
	static BufferedReader in;
	static StringTokenizer st;
	static int[][] board = new int[9][9];
	static ArrayList<Point> list = new ArrayList<>();
	static boolean isAnswer = false;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) list.add(new Point(j,i));
			}
		}
		backtracking(0);
	}
	public static void backtracking(int index) {
		if(isAnswer) return;
		if(index == list.size()) {
			isAnswer = true;
			printAns();
			return;
		}
		Point now = list.get(index);
		for(int i = 1; i < 10; i++) {
			board[now.getY()][now.getX()] = i;
			if(isPromising(now))
				backtracking(index+1);
			board[now.getY()][now.getX()] = 0;
		}
	}
	public static void printAns() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++)
				sb.append(board[i][j] + " ");
			if(i < 8)sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isPromising(Point now) {
		int col = now.x; int row = now.y;
		return checkCols(row) && checkRows(col) && checkSquare(row, col);
	}
	public static boolean checkRows(int col) {
		boolean[] numbers = new boolean[10];
		for(int i = 0; i < 9; i++) {
			int number = board[i][col];
			if(number == 0) continue;
			else if(numbers[number]) return false;
			numbers[number] = true;
		}
		return true;
	}
	public static boolean checkCols(int row) {
		boolean[] numbers = new boolean[10];
		for(int i = 0; i < 9; i++) {
			int number = board[row][i];
			if(number == 0) continue;
			else if(numbers[number]) return false;
			numbers[number] = true;
		}
		return true;
	}
	public static boolean checkSquare(int row, int col) {
		boolean[] numbers = new boolean[10];
		int squareX = (col/3)*3;
		int squareY = (row/3)*3;
		for(int i = squareY; i < squareY+3; i++)
			for(int j = squareX; j < squareX+3; j++) {
				int number = board[i][j];
				if(number == 0) continue;
				else if(numbers[number]) return false;
				numbers[number] = true;
			}
		return true;
	}
}