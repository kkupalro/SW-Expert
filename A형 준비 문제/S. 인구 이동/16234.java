package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int N, min, max;
	static int matrix[][];
	static int visit[][];
	static int result = 0;
	static boolean map[][];
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
	static void print2(boolean a[][]) {
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
	static void dfs(int y, int x) 
	{
		int a = matrix[y][x];
		map[y][x] = true;
		for(int l = 0; l < 4; l++)
		{
			int ny = y + dy[l];
			int nx = x + dx[l];
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			int b = matrix[ny][nx];
			if(Math.abs(a-b) >= min && Math.abs(a-b) <= max)
			{
				if(!map[ny][nx]) {
					map[ny][nx] = true;
					visit[ny][nx] = visit[y][x];
					dfs(ny, nx);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			int value = 1;
			boolean flag = false;
			boolean check = false;
			map = new boolean[N][N];
			visit = new int[N][N];
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					int a = matrix[i][j];
					if(!map[i][j])
					{
						for(int l = 0; l < 4; l++)
						{
							int ny = i + dy[l];
							int nx = j + dx[l];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
							int b = matrix[ny][nx];
							if(map[ny][nx] || visit[ny][nx] > 0) continue;
							if(Math.abs(a-b) >= min && Math.abs(a-b) <= max)
							{
								map[i][j] = true;
								visit[i][j] = value;
								visit[ny][nx] = value;
								dfs(ny, nx);
								flag = true;
								check = true;
							}
						}
						if(flag)
						{
							value++;
							flag = false;
						}					
					}
				}
			}
			// 기저 조건
			if(!check) 
			{
				break;
			}
			value--;
			for(int k = 1; k <= value; k++)
			{
				int sum = 0; int cnt = 0;
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						if(visit[i][j] == k && map[i][j])
						{
							sum += matrix[i][j];
							cnt++;
						}
					}
				}
				int data = sum / cnt;
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						if(visit[i][j] == k && map[i][j])
						{
							matrix[i][j] = data;
						}
					}
				}
			}
			// 초기화
			result++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
