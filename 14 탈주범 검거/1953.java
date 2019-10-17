package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x; int type;
	node(int y, int x, int type){
		this.y = y;
		this.x = x;
		this.type = type;
	}
}

public class Main {
	static final int dy[] = {0, 0, 1,-1}; // > < v ^
	static final int dx[] = {1,-1, 0, 0};
	static int T, N, M, result, t_num, time;
	static int matrix[][];
	static boolean visit[][];
	static Queue<node> q = new LinkedList<node>();
	static void solve(int y, int x, int type) {
		q.offer(new node(y, x, type));
		int ny = 0; int nx = 0;
		for(int t = 0; t < time; t++)
		{
			int len = q.size();
			for(int i = 0; i < len; i++)
			{
				node n = q.poll();
				type = n.type;
				visit[n.y][n.x] = true;
				// (0. >), (1. <), (2. v), (3. ^)
				if(type == 1)
				{
					for(int l = 0; l < 4; l++)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 0)
						{
							// > 우
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 6 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 1)
						{
							// < 좌
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 4 || matrix[ny][nx] == 5)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 2)
						{
							// v 하
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 4 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 3)
						{
							// ^ 상
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 5 || matrix[ny][nx] == 6)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 2)
				{
					for(int l = 2; l < 4; l++)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 2)
						{
							// v 하
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 4 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 3)
						{
							// ^ 상
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 5 || matrix[ny][nx] == 6)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 3)
				{
					for(int l = 0; l < 2; l++)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 0)
						{
							// > 우
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 6 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 1)
						{
							// < 좌
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 4 || matrix[ny][nx] == 5)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 4)
				{
					for(int l = 0; l < 4; l+=3)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 0)
						{
							// > 우
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 6 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 3)
						{
							// ^ 상
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 5 || matrix[ny][nx] == 6)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 5)
				{
					for(int l = 0; l < 4; l+=2)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 0)
						{
							// > 우
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 6 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 2)
						{
							// v 하
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 4 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 6)
				{
					for(int l = 1; l < 3; l++)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 1)
						{
							// < 좌
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 4 || matrix[ny][nx] == 5)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 2)
						{
							// v 하
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 4 || matrix[ny][nx] == 7)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
				if(type == 7)
				{
					for(int l = 1; l < 4; l+=2)
					{
						ny = n.y + dy[l];
						nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
						if(visit[ny][nx]) continue;
						if(matrix[ny][nx] == 0) continue;
						if(l == 1)
						{
							// < 좌
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 3 || matrix[ny][nx] == 4 || matrix[ny][nx] == 5)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
						else if(l == 3)
						{
							// ^ 상
							if(matrix[ny][nx] == 1 || matrix[ny][nx] == 2 || matrix[ny][nx] == 5 || matrix[ny][nx] == 6)
							{
								q.offer(new node(ny, nx, matrix[ny][nx]));
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			matrix = new int[N][M];
			visit = new boolean[N][M];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(sy, sx, matrix[sy][sx]);
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					
					if(visit[i][j])
					{
						result++;
					}
				}
			}
			bw.write("#" + ++t_num + " " + result + "\n");
			result = 0;
			q.clear();
		}
		bw.flush();
		bw.close();
	}
}
