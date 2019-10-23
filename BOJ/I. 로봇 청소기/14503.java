package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][];
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}
	static void solve(int y, int x, int dir) {
		int ny = 0;
		int nx = 0;
		int next = 0;
		int d = dir;
		if(matrix[y][x] == 1)
		{
			return;
		}
		if(matrix[y][x] == 0)
		{
			// 1. 현재 위치를 청소한다.
			matrix[y][x] = 2;
			result += 1;
		}
		// 2. 현재 위치를 기준으로 왼쪽방향부터 차례대로 탐색 진행
		for(int l = 0; l < 4; l++)
		{
			// (0)북 -> (3)서, (1)동 -> (0)북, (2)남 -> (1)동, (3)서 -> (2)남
			if(dir == 0)
			{
				next = 3;
			}
			else {
				next = dir - 1;
			}
			ny = y + dy[next];
			nx = x + dx[next];
			if(matrix[ny][nx] == 0)
			{
				solve(ny, nx, next);
				return;
			}
			else {
				dir = next;
			}
		}
		ny = y - dy[d];
		nx = x - dx[d];
		solve(ny, nx, d);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(y, x, d);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}