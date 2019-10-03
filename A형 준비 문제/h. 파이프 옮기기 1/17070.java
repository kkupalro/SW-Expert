package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int dy[][] = {{0, 1}, {1, 1}, {0,1,1}};
	static int dx[][] = {{1, 1}, {0, 1}, {1,0,1}};
	static int result, N;
	static int matrix[][];
	static void solve(int y, int x, int t) 
	{
		if(y == N && x == N)
		{
			// 경우의수 1 증가
			result++;
			return;
		}
		
		/*
		 * t = 0, 가로
		 * t = 1, 세로
		 * t = 2, 대각선
		 */
		for(int l = 0; l < dy[t].length; l++)
		{
			int ny = y + dy[t][l];
			int nx = x + dx[t][l];
			if(ny < 1 || ny > N || nx < 1 || nx > N) continue;
			if(matrix[ny][nx] == 1) continue;
			if(t == 0)
			{
				if(l == 0)
				{
					solve(ny, nx, 0);
				}
				else if(l == 1)
				{
					if(matrix[y+1][x] == 1 || matrix[y][x+1] == 1) continue;
					solve(ny, nx, 2);
				}
			}
			else if(t == 1)
			{
				if(l == 0)
				{
					solve(ny, nx, 1);
				}
				else if(l == 1)
				{
					if(matrix[y+1][x] == 1 || matrix[y][x+1] == 1) continue;
					solve(ny, nx, 2);
				}
			}
			else if(t == 2)
			{
				if(l == 0)
				{
					solve(ny, nx, 0);
				}
				else if(l == 1)
				{
					solve(ny, nx, 1);
				}
				else if(l == 2)
				{
					if(matrix[y+1][x] == 1 || matrix[y][x+1] == 1) continue;
					solve(ny, nx, 2);
				}
			}	
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix = new int[N+1][N+1];
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(1,2,0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
