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
 * @commit 0904|BOJ|현수막 |14716
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
	static final int dy[] = {0, -1,-1,-1, 0, 1, 1, 1}; // < \ ^ / > \ v /
	static final int dx[] = {-1,-1, 0, 1, 1, 1, 0,-1};
	static int result;
	static int N, M;
	static StringTokenizer st;
	static int matrix[][];
	static boolean visit[][];
	
	static void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int y, int x) {
		
		for (int i = 0; i < dy.length; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if(visit[ny][nx]) continue;
			if(matrix[ny][nx] == 0) continue;
			visit[ny][nx] = true;
			dfs(ny, nx);
		}
	}
	

	static void bfs(int y, int x) {
		Queue<node> q = new LinkedList<node>();
		q.offer(new node(y, x));
		while(!q.isEmpty()) {
			node n = q.poll();
			int ny = 0;
			int nx = 0;
			for (int i = 0; i < dy.length; i++) {
				ny = n.y + dy[i];
				nx = n.x + dx[i];
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if(visit[ny][nx]) continue;
				if(matrix[ny][nx] == 0) continue;
				visit[ny][nx] = true;
				q.offer(new node(ny, nx));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]) continue;
				if(matrix[i][j] == 1) {
					visit[i][j] = true;
					bfs(i, j);
//					dfs(i, j);
					result++;
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}