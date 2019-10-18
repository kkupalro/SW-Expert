package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x; int h;
	node(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
}

public class Main {
	static final int SIZE = 22;
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int T, N, M, K, t_num, result;
	static int max;
	static int matrix[][] = new int[SIZE][SIZE];
	static int cost[] = new int[SIZE + 2];
	static void solve(int y, int x) {
		Queue<node> q;
		int k = 1;
		while(k < SIZE) 
		{
			q = new LinkedList<node>();
			q.offer(new node(y, x, 1));
			boolean visit[][] = new boolean[N][N];
			int cnt = 0;
			while(!q.isEmpty()) 
			{
				node n = q.poll();
				visit[n.y][n.x] = true;
				if(matrix[n.y][n.x] == 1)
				{
					cnt++;
				}
				for(int l = 0; l < 4; l++)
				{
					int ny = n.y + dy[l];
					int nx = n.x + dx[l];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(visit[ny][nx] || n.h >= k) continue;
					q.offer(new node(ny, nx, n.h + 1));
					visit[ny][nx] = true;
				}
			}
			if(cnt * M - cost[k] >= 0)
			{
				result = Math.max(result, cnt);
			}
			if(cost[k] > max)
			{
				break;
			}
			k++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		// 비용 계산
		for(int i = 1; i < SIZE; i++)
		{
			cost[i] = (int)Math.pow(i, 2) + (int)Math.pow(i-1, 2);
		}
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			max = 0;
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] == 1) max += M;
				}
			}
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					solve(i, j);
				}
			}
			bw.write("#" + ++t_num + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
