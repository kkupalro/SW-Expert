package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][] = new int[101][101];
	static boolean map[][] = new boolean[101][101];
	static int N, M;
	static int min = 100;
	static int max = 0;
	static int result;
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
	static void prints(boolean a[][]) {
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
	static void dfs(int y, int x, boolean[][] visit) {
		visit[y][x] = true;
		for(int l = 0; l < 4; l++)
		{
			int ny = y + dy[l];
			int nx = x + dx[l];
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if(!visit[ny][nx] && !map[ny][nx])
			{
				visit[ny][nx] = true;
				dfs(ny, nx, visit);
			}
		}
	}
	static void solve(int time) {
		boolean[][] visit = new boolean[N][N];
		int value = 1;
		if(time == max-1)
		{
			// 기저 사례, time == max 일 시 1이므로 max에서 1을 뺀값 까지 완탐
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(map[i][j]) continue;
					if(matrix[i][j] == time)
					{
						map[i][j] = true;
					}
				}
			}
			// 안전영역 구함
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(!map[i][j] && !visit[i][j])
					{
						visit[i][j] = true;
						for(int l = 0; l < 4; l++)
						{
							int ny = i + dy[l];
							int nx = j + dx[l];
							if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
							if(!visit[ny][nx] && !map[ny][nx])
							{
								visit[ny][nx] = true;
								dfs(ny, nx, visit);
							}
						}
						value++;
					}
				}
			}
			result = Math.max(result, value-1);
			return;
		}
		// 물에 잠김
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[i][j]) continue;
				if(matrix[i][j] == time)
				{
					matrix[i][j] = -1;
					map[i][j] = true;
				}
			}
		}
		// 안전영역 구함
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(!map[i][j] && !visit[i][j])
				{
					visit[i][j] = true;
					for(int l = 0; l < 4; l++)
					{
						int ny = i + dy[l];
						int nx = j + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
						if(!visit[ny][nx] && !map[ny][nx])
						{
							visit[ny][nx] = true;
							dfs(ny, nx, visit);
						}
					}
					value++;
				}
			}
		}		
		result = Math.max(result, value-1);
		solve(time + 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, matrix[i][j]);
				max = Math.max(max, matrix[i][j]);
			}
		}
		result = 1;
		if(min == max)
		{
			// (min == max) visit[][] 배열 생성 -> 무한루프 -> 메모리 초과
		}
		else {
			solve(min);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
