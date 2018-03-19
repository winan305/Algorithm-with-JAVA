import java.io.*;
import java.util.*;

// 시간초과
class Path {
	int x, y, len;
	public Path(int x, int y, int l) {
		this.x = x;
		this.y = y;
		this.len = l;
	}
}
public class Main {
	static BufferedReader in;
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] isVisit;
	static int T, N, M;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			isVisit = new boolean[N][M];
			
			Path start = new Path(-1,-1,0);
			for(int i = 0; i < N; i++) {
				String input = in.readLine();
				for(int j = 0; j < M; j++) {
					char c = input.charAt(j);
					map[i][j] = c;
					if(c == 'S') start = new Path(i, j, 0);
				}
			}
			System.out.println(solve(start));
		}
	}
	public static int solve(Path start) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Queue<Path> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Path now = queue.poll();
			int nowX = now.x, nowY = now.y, nowLen = now.len;
			
			if(map[nowX][nowY] == 'E') return nowLen;
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(isValid(nextX, nextY) && !isVisit[nextX][nextY])
					queue.add(new Path(nowX + dx[i], nowY + dy[i], nowLen+1));
			}
			map[nowX][nowY] = '#';
			isVisit[nowX][nowY] = true;
		}
		return -1;
	}
	public static boolean isValid(int x, int y) {
		if(x < 0 || y < 0) return false;
		else if(x >= N || y >= M) return false;
		else if(map[x][y] == '#') return false;
		return true;
	}
}