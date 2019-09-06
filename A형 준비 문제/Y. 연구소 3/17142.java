package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x;
	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][];
	static boolean check[];
	static LinkedList<node> list = new LinkedList<>();
	static int N, M, result;
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
	static void copy(int[][] a, int[][] b) {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void bfs() {
		int ans = 0; int ny = 0; int nx = 0;
		Queue<node> q = new LinkedList<node>();
		boolean visit[][] = new boolean[N][N];
		int temp[][] = new int[N][N];
		copy(temp, matrix);
		for(int i = 0; i < list.size(); i++)
		{
			if(check[i])
			{
				q.offer(new node(list.get(i).y, list.get(i).x));
			}
		}
		while(!q.isEmpty())
		{
			int size = q.size();
			boolean able = false; // 0포함 여부 검사 : 포함 시 true
			for(int i = 0; i < size; i++)
			{
				node n = q.poll();
				int y = n.y;
				int x = n.x;
				for(int l = 0; l < 4; l++)
				{
					ny = y  + dy[l];
					nx = x  + dx[l];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(matrix[ny][nx] == 1 || visit[ny][nx]) continue;
					visit[ny][nx] = true;
					matrix[ny][nx] = 2;
					q.offer(new node(ny, nx));
				}
			}
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(matrix[i][j] == 0)
					{
						able = true;
						break;
					}
				}
			}
			ans++;
			if(!able)
			{
				result = Math.min(result, ans);
				copy(matrix, temp);
				return;
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(matrix[i][j] == 0)
				{
					copy(matrix, temp);
					return;
				}
			}
		}
		result = Math.min(result, ans);
		copy(matrix, temp);
		return;
	}
	static void dfs(int idx, int cnt)
	{
		if(cnt == M)
		{
			bfs();
			return;
		}
		for(int i = idx+1; i < list.size(); i++)
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
		matrix = new int[N][N];
		result = Integer.MAX_VALUE;
		boolean isAble = false;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) 
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 2)
				{
					list.offer(new node(i, j));
				}
				else if(matrix[i][j] == 0)
				{
					isAble = true;
				}
			}
		}
		if(!isAble)
		{
			result = 0;
		}
		else 
		{
			check = new boolean[list.size()];
			for(int i = 0; i < list.size(); i++)
			{
				check[i] = true;
				dfs(i, 1);
				check[i] = false;
			}
			if(result == Integer.MAX_VALUE)
			{
				result = -1;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
