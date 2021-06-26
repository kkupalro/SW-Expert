package DataStructure;

import java.io.*;
import java.util.*;

class node {
	int y;
	int x;
	int h;

	node(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
}

public class Main {
	static final int dy[] = { -1, 0, 1, 0 };
	static final int dx[] = { 0, 1, 0, -1 };
	static final int dh[] = { -1, 1 };
	static int M, N, H, result;
	static int[][][] matrix;
	static Queue<node> q;
	static int cnt;

	static void bfs() {
		int ny = 0;
		int nx = 0;
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();
			result++;
			for (int i = 0; i < size; i++) {
				node n = q.poll();
				int y = n.y;
				int x = n.x;
				int h = n.h;
				for (int dir = 0; dir < 4; dir++) {
					ny = y + dy[dir];
					nx = x + dx[dir];
					if (ny < 0 || ny > N - 1 || nx < 0 || nx > M - 1) continue;
					if (matrix[h][ny][nx] == -1 || matrix[h][ny][nx] == 1) continue;
					matrix[h][ny][nx] = 1;
					cnt--;
					q.offer(new node(ny, nx, h));
				}

				for (int dir = 0; dir < 2; dir++) {
					int nh = h + dh[dir];
					if (nh < 0 || nh > H - 1) continue;
					if (matrix[nh][y][x] == -1 || matrix[nh][y][x] == 1) continue;
					matrix[nh][y][x] = 1;
					cnt--;
					q.offer(new node(y, x, nh));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		matrix = new int[H][N][M];
		q = new LinkedList<node>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					matrix[k][i][j] = Integer.parseInt(st.nextToken());
					if (matrix[k][i][j] == 1) {
						q.offer(new node(i, j, k));
					}
					if (matrix[k][i][j] == 0) {
						cnt++;
					}
				}
			}
		}

		// 모든 토마토가 익어있는 상태
		if (cnt == 0) {
			result = 0;
		} else {
			result = -1;
			bfs();

			// 덜 익은 토마토가있는 상태
			if (cnt != 0) {
				result = -1;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
