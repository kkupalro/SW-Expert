package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x; int size; int cnt; int dist;
	node(int y, int x, int size, int cnt, int dist) {
		this.y = y;
		this.x = x;
		this.size = size;
		this.cnt = cnt;
		this.dist = dist;
	}
}
public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][];
	static boolean visit[][];
	static int N, Y, X, result;
	static final int INF = 100;
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void bfs() {
		Queue<node> q= new LinkedList<node>();
		q.add(new node(Y, X, 2, 0, 0));
		visit[Y][X] = true;
		while(!q.isEmpty())
		{
			int fy = INF; int fx = INF;
			int cnt = 0; int size = 0; int dist = 0;
			int len = q.size();
			for(int i = 0; i < len; i++)
			{
				node n = q.poll();
				for(int l = 0; l < 4; l++)
				{
					int ny = n.y + dy[l];
					int nx = n.x + dx[l];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(visit[ny][nx]) continue;
					if(matrix[ny][nx] > n.size) continue;
					visit[ny][nx] = true;
					q.offer(new node(ny, nx, n.size, n.cnt, n.dist+1));
					if(matrix[ny][nx] != 0 && matrix[ny][nx] != n.size)
					{
						if(ny < fy)
						{
							fy = ny;
							fx = nx;
							cnt = n.cnt;
							size = n.size;
							dist = n.dist + 1;
						}
						else if(ny == fy)
						{
							if(nx < fx)
							{
								fy = ny;
								fx = nx;
								cnt = n.cnt;
								size = n.size;
								dist = n.dist + 1;
							}
						}
					}
				}
			}
			if(fx != INF)
			{
				cnt++;
				if(cnt == size)
				{
					size++;
					cnt = 0;
				}
				matrix[Y][X] = 0;
				result += dist;
				X = fx; Y = fy;
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						visit[i][j] = false;
					}
				}
				q.clear();
				visit[fy][fx] = true;
				q.offer(new node(fy, fx, size, cnt, 0));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		result = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 9)
				{
					Y = i; X = j;
				}
			}
		}
		visit = new boolean[N][N];
		bfs();
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}