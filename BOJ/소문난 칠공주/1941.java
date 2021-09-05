package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoo
 * @commit 0905|BOJ|소문난 칠공주|1941
 *
 */

class node {
	int y, x;

	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static final int dy[] = { 0, -1, 0, 1 }; // < ^ > v
	static final int dx[] = { -1, 0, 1, 0 };
	static int matrix[][] = new int[5][5];
	static boolean visit[][];
	static int result;

	static void comb(int idx, int cnt, boolean[] check) {
		// 기저 조건
		if (cnt == 7) {
			if (isPrincess(check)) {
				result++;
			}
			return;
		}

		for (int i = idx + 1; i < 25; i++) {
			if (check[i]) continue;
			check[i] = true;
			comb(i, cnt + 1, check);
			check[i] = false;
		}
	}

	static boolean isPrincess(boolean[] check) {
		visit = new boolean[5][5];
		boolean temp[][] = new boolean[5][5];
		
		Queue<node> q = new LinkedList<node>();
		int r = 0;
		int c = 0;

		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				r = i / 5;
				c = i % 5;
				temp[r][c] = true;
			}
		}

		int cnt = 1;
		int sCnt = matrix[r][c];
		visit[r][c] = true;
		q.offer(new node(r, c));
		
		while (!q.isEmpty()) {
			node n = q.poll();
			int ny = 0;
			int nx = 0;
			for (int i = 0; i < dy.length; i++) {
				ny = n.y + dy[i];
				nx = n.x + dx[i];
				if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
				if (visit[ny][nx]) continue;
				visit[ny][nx] = true;
				if (temp[ny][nx]) {
					cnt++;
					sCnt += matrix[ny][nx];
					q.offer(new node(ny, nx));
				}
			}
		}

		if (cnt == 7 && sCnt >= 4) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				char c = str.charAt(j);
				matrix[i][j] = (c == 'Y') ? 0 : 1;
			}
		}
		boolean check[] = new boolean[25];
		for (int i = 0; i < 25; i++) {
			check[i] = true;
			comb(i, 1, check);
			check[i] = false;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}