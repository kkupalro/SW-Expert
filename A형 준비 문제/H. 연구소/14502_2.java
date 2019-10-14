package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static final int dy[] = {0, 0, 1,-1}; // > < v ^
	static final int dx[] = {1,-1, 0, 0};
	static boolean visit[][];
	static boolean map[][];
	static int matrix[][];
	static int temp[][];
	static void copy(int a[][], int b[][]) {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void bomb(int y, int x) {
		if(matrix[y][x] == 1)
		{
			return;
		}
		matrix[y][x] = 2;
		for(int l = 0; l < 4; l++)
		{
			int ny = dy[l] + y;
			int nx = dx[l] + x;
			if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
			if(map[ny][nx]) continue;
			map[ny][nx] = true;
			bomb(ny, nx);
		}
	}
	static void solve(int y, int x, int cnt) {
		if(cnt == 1)
		{
			int ans = 0;
			map = new boolean[N][M];
			copy(temp, matrix);
			// 바이러스 퍼짐
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(matrix[i][j] == 2)
					{
						if(map[i][j]) continue;
						map[i][j] = true;
						bomb(i, j);
					}
				}
			}
			// 계산
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
			result = Math.max(result, ans);
			copy(matrix, temp);
			return;
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(visit[i][j]) continue;
				if(matrix[i][j] == 0)
				{
					visit[i][j] = true;
					matrix[i][j] = 1;
					solve(i,j, cnt-1);
					matrix[i][j] = 0;
					visit[i][j] = false;
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
		temp = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(matrix[i][j] == 0) 
				{
					visit[i][j] = true;
					matrix[i][j] = 1;
					solve(i,j, 3);
					matrix[i][j] = 0;
					visit[i][j] = false;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
