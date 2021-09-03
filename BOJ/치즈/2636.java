package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0903|BOJ|치즈|2636
 *
 */

public class Main {
	static int R, C;
	static int result;
	static int cnt;
	static StringTokenizer st;
	static int matrix[][];
	static boolean visit[][];
	final static int dy[] = { 0, -1, 0, 1 }; // < ^ > v
	final static int dx[] = { -1, 0, 1, 0 };

	static void init() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 2) {
					matrix[i][j] = 0;
				}
			}
		}

	}

	static void dfs(int y, int x) {
		// 기저 조건
		if (matrix[y][x] == 1) {
			matrix[y][x] = 2;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= R || nx < 0 || nx >= C)
				continue;
			if (visit[ny][nx])
				continue;
			visit[ny][nx] = true;
			dfs(ny, nx);
		}
	}
	
	static void calc() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 2) {
					result++;
				}
			}
		}
	}
	
	static boolean isZero() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isEnd() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		matrix = new int[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(!isZero()) {
			visit = new boolean[R][C];
			dfs(0, 0);
			cnt++;
			if(isEnd()) {
				calc();
				break;
			}
			init();
		}
		bw.write(cnt + "\n" + result + "\n");
		bw.flush();
		bw.close();
	}
}