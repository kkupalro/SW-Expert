package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x; int depth; int idx;
	node(int y, int x, int depth, int idx) {
		this.y = y;
		this.x = x;
		this.depth = depth;
		this.idx = idx;
	}
}

public class Main {
	static final int dy[] = { 0,-1, 0}; // < ^ > 
	static final int dx[] = {-1, 0, 1};
	static int matrix[][];
	static boolean check[];
	static int N, M, D, result;
	static void print(int[][] a) {
		System.out.println("=====================");
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static void solve(int[][] map) {
		int kill = 0;
		for(int i = N; i > 0; i--)
		{
			int index = 0;
			Queue<node> q = new LinkedList<node>();
			for(int j = 0; j < M; j++)
			{
				if(check[j])
				{
					map[i][j] = 2; // 궁수 표시
					q.offer(new node(i-1, j, 1, index++));
				}
				else 
				{
					map[i][j] = 0;
				}
			}
			boolean[] active = new boolean[3];     // 각 궁수가 적을 찾았는지 여부
			boolean[][][] visit = new boolean[N][M][3];   // 각 궁수가 해당 좌표를 조준했는지 여부
			boolean[][] find = new boolean[N][M];  // 이미 다른 궁수가 찾은 적인지 여부
			LinkedList<node> list = new LinkedList<>();
			while(!q.isEmpty())
			{
				node n = q.poll();
	        	if(active[n.idx]) continue;
	        	if(map[n.y][n.x] == 1)
	        	{
	        		active[n.idx] = true;
	        		if(!find[n.y][n.x])
	        		{
	        			find[n.y][n.x] = true;
	        			list.offer(n);
	        			kill++;
	        		}
	        		continue;
	        	}
	        	if(!active[n.idx])
	        	{
	        		visit[n.y][n.x][n.idx] = true;
	        		for(int l = 0; l < 3; l++)
	        		{
	        			int ny = n.y + dy[l];
	        			int nx = n.x + dx[l];
	        			if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[ny][nx][n.idx] && n.depth < D)
	        			{
	        				q.offer(new node(ny, nx, n.depth + 1, n.idx));
	        			}
	        		}
	        	}
	         }
	         for(int j = 0; j < list.size(); j++)
	         {
	        	 node n = list.get(j);
	        	 map[n.y][n.x] = 0;
	         }
		}
		result = Math.max(result, kill);
	}
	static void dfs(int idx, int cnt)
	{
		if(cnt == 3)
		{
			int temp[][] = new int[N+1][M];
			for(int i = 0; i < N + 1; i++)
			{
				for(int j = 0; j < M; j++)
				{
					temp[i][j] = matrix[i][j];
				}
			}
			solve(temp);
			return;
		}
		for(int i = idx; i < M; i++)
		{
			if(check[i]) continue;
			check[i] = true;
			dfs(i, cnt + 1);
			check[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		matrix = new int[N+1][M];
		result = 0;
		check = new boolean[M];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) 
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
