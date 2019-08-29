package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int matrix[][];
	static int temp[][];
	static boolean visit[][];
	static int N, M, result, count; 
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
	static void copy(int[][] a, int[][] b) {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void up(int y, int x) {
		for(int i = y; i >= 0; i--)
		{
			if(matrix[i][x] == 0) {
				matrix[i][x] = 7;
			}
			else if(matrix[i][x] == 6) {
				break;
			}
		}
	}
	static void right(int y, int x) {
		for(int i = x; i < M; i++)
		{
			if(matrix[y][i] == 0) {
				matrix[y][i] = 7;
			}
			else if(matrix[y][i] == 6) {
				break;
			}
		}
	}
	static void down(int y, int x) {
		for(int i = y; i < N; i++)
		{
			if(matrix[i][x] == 0) {
				matrix[i][x] = 7;
			}
			else if(matrix[i][x] == 6) {
				break;
			}
		}
	}
	static void left(int y, int x) {
		for(int i = x; i >= 0; i--)
		{
			if(matrix[y][i] == 0) {
				matrix[y][i] = 7;
			}
			else if(matrix[y][i] == 6) {
				break;
			}
		}
	}
	static void solve(int y, int x, int cctv, int type, int cnt) {
		int[][] temp = new int[N][M];
		if(cnt == count)
		{
			if(cctv == 1)
			{
				if(type == 1)
				{
					up(y, x);
				}
				else if(type == 2)
				{
					right(y, x);
				}
				else if(type == 3)
				{
					down(y, x);
				}
				else if(type == 4)
				{
					left(y, x);
				}
			}
			else if(cctv == 2)
			{
				if(type == 1)
				{
					up(y, x);
					down(y, x);
				}
				else if(type == 2)
				{
					left(y, x);
					right(y, x);
				}
			}
			else if(cctv == 3)
			{
				if(type == 1)
				{
					up(y, x);
					right(y, x);
				}
				else if(type == 2)
				{
					right(y, x);
					down(y, x);
				}
				else if(type == 3)
				{
					down(y, x);
					left(y, x);
				}
				else if(type == 4)
				{
					left(y, x);
					up(y, x);
				}
			}
			else if(cctv == 4)
			{
				if(type == 1)
				{
					left(y, x);
					up(y, x);
					right(y, x);
				}
				else if(type == 2)
				{
					up(y, x);
					right(y, x);
					down(y, x);
				}
				else if(type == 3)
				{
					right(y, x);
					down(y, x);
					left(y, x);
				}
				else if(type == 4)
				{
					down(y, x);
					left(y, x);
					up(y, x);
				}
			}
			else if(cctv == 5)
			{
				if(type == 1)
				{
					up(y, x);
					right(y, x);
					left(y, x);
					down(y, x);
				}
			}
			
			// 배열 값 0인 계수 카운트후 최소 결과값 비교후 저장
			int ans = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(matrix[i][j] == 0)
					{
						ans++;
					}
				}
			}
			result = Math.min(result, ans);
			copy(matrix, temp);
			return;
		}
		else {
			if(cctv == 1)
			{
				if(type == 1)
				{
					up(y, x);
				}
				else if(type == 2)
				{
					right(y, x);
				}
				else if(type == 3)
				{
					down(y, x);
				}
				else if(type == 4)
				{
					left(y, x);
				}
			}
			else if(cctv == 2)
			{
				if(type == 1)
				{
					up(y, x);
					down(y, x);
				}
				else if(type == 2)
				{
					left(y, x);
					right(y, x);
				}
			}
			else if(cctv == 3)
			{
				if(type == 1)
				{
					up(y, x);
					right(y, x);
				}
				else if(type == 2)
				{
					right(y, x);
					down(y, x);
				}
				else if(type == 3)
				{
					down(y, x);
					left(y, x);
				}
				else if(type == 4)
				{
					left(y, x);
					up(y, x);
				}
			}
			else if(cctv == 4)
			{
				if(type == 1)
				{
					left(y, x);
					up(y, x);
					right(y, x);
				}
				else if(type == 2)
				{
					up(y, x);
					right(y, x);
					down(y, x);
				}
				else if(type == 3)
				{
					right(y, x);
					down(y, x);
					left(y, x);
				}
				else if(type == 4)
				{
					down(y, x);
					left(y, x);
					up(y, x);
				}
			}
			else if(cctv == 5)
			{
				if(type == 1)
				{
					up(y, x);
					right(y, x);
					left(y, x);
					down(y, x);
				}
			}
			copy(temp, matrix);
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(matrix[i][j] == 1)
					{
						for(int t = 1; t <= 4; t++)
						{
							if(visit[i][j]) continue;
							copy(matrix, temp);
							visit[i][j] = true;
							solve(i, j, matrix[i][j], t, cnt+1);
							visit[i][j] = false;
						}
					}
					else if(matrix[i][j] == 2) {
						for(int t = 1; t <= 2; t++)
						{
							if(visit[i][j]) continue;
							copy(matrix, temp);
							visit[i][j] = true;
							solve(i, j, matrix[i][j], t, cnt+1);
							visit[i][j] = false;
						}
					}
					else if(matrix[i][j] == 3) {
						for(int t = 1; t <= 4; t++)
						{
							if(visit[i][j]) continue;
							copy(matrix, temp);
							visit[i][j] = true;
							solve(i, j, matrix[i][j], t, cnt+1);
							visit[i][j] = false;
						}
					}
					else if(matrix[i][j] == 4) {
						for(int t = 1; t <= 4; t++)
						{
							if(visit[i][j]) continue;
							copy(matrix, temp);
							visit[i][j] = true;
							solve(i, j, matrix[i][j], t, cnt+1);
							visit[i][j] = false;
						}
					}
					else if(matrix[i][j] == 5) {
						if(visit[i][j]) continue;
						copy(matrix, temp);
						visit[i][j] = true;
						solve(i, j, matrix[i][j], 1, cnt+1);
						visit[i][j] = false;
					}
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
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		int tmp[][] = new int[N][M];
		visit = new boolean[N][M];
		count = 0;
		result = 0;
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] > 0 && matrix[i][j] < 6)
				{
					count++;
				}
				else if(matrix[i][j] == 0)
				{
					result++;
				}
			}
		}
		copy(tmp, matrix);
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(matrix[i][j] == 1)
				{
					for(int t = 1; t <= 4; t++)
					{
						visit[i][j] = true;
						copy(matrix, tmp);
						solve(i, j, matrix[i][j], t, 1);
						visit[i][j] = false;
					}
				}
				else if(matrix[i][j] == 2) {
					for(int t = 1; t <= 2; t++)
					{
						visit[i][j] = true;
						copy(matrix, tmp);
						solve(i, j, matrix[i][j], t, 1);
						visit[i][j] = false;
					}
				}
				else if(matrix[i][j] == 3) {
					for(int t = 1; t <= 4; t++)
					{
						visit[i][j] = true;
						copy(matrix, tmp);
						solve(i, j, matrix[i][j], t, 1);
						visit[i][j] = false;
					}
				}
				else if(matrix[i][j] == 4) {
					for(int t = 1; t <= 4; t++)
					{
						visit[i][j] = true;
						copy(matrix, tmp);
						solve(i, j, matrix[i][j], t, 1);
						visit[i][j] = false;
						
					}
				}
				else if(matrix[i][j] == 5) {
					visit[i][j] = true;
					copy(matrix, tmp);
					solve(i, j, matrix[i][j], 1, 1);
					visit[i][j] = false;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
