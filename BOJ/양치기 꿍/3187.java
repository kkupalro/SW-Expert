package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0903|BOJ|양치기 꿍|3187
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
	static int R, C, K, V;
	static int kCnt, vCnt;
	static StringTokenizer st;
	static int matrix[][];
	static boolean visit[][];
	final static int dy[] = { 0, -1, 0, 1 }; // < ^ > v
	final static int dx[] = { -1, 0, 1, 0 };

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if (visit[ny][nx] || matrix[ny][nx] == 3) continue;
			visit[ny][nx] = true;
			if (matrix[ny][nx] == 1) {
				kCnt++;
			} else if (matrix[ny][nx] == 2) {
				vCnt++;
			}
			dfs(ny, nx);
		}
	}

	static void bfs(int y, int x) {
		Queue<node> q = new LinkedList<node>();
		q.offer(new node(y, x));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			int ny = n.y;
			int nx = n.x;
			
			for (int i = 0; i < 4; i++) {
				ny = n.y + dy[i];
				nx = n.x + dx[i];

				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (visit[ny][nx] || matrix[ny][nx] == 3) continue;
				visit[ny][nx] = true;
				if (matrix[ny][nx] == 1) {
					kCnt++;
				} else if (matrix[ny][nx] == 2) {
					vCnt++;
				}
				q.offer(new node(ny, nx));
			}
		}
		
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
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				/*
				 * TODO 0 : .(빈공간), 1 : k(양), 2 : v(늑대), 3 : #(울타리)
				 */
				matrix[i][j] = c == '.' ? 0 : c == 'k' ? 1 : c == 'v' ? 2 : 3;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (visit[i][j])
					continue;
				kCnt = 0;
				vCnt = 0;
				if (matrix[i][j] == 1 || matrix[i][j] == 2) {
					visit[i][j] = true;
					if (matrix[i][j] == 1) {
						kCnt++;
					} else if (matrix[i][j] == 2) {
						vCnt++;
					}
					// dfs(i, j);
					bfs(i, j);
				}

				if (kCnt > vCnt) {
					K += kCnt;
				} else {
					V += vCnt;
				}
			}
		}

		bw.write(K + " " + V + "\n");
		bw.flush();
		bw.close();
	}
}