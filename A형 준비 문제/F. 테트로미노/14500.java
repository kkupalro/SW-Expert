package TEST;

import java.io.*;
import java.util.*;

public class Main {
	/*
	 * 시간복잡도 : O(N*M*(19*3))
	 * 19 * 500 * 500 * 3 = 최대 14,250,000번 비교연산
	 * N : 세로 (Y)
	 * M : 가로 (X)
	 */
	static int N, M, result;
	static int a[][];
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
	static void solve(int y, int x) {
		// 1_1
		if(x + 3 >= M) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y][x+3]);
		// 1_2
		if(y + 3 >= N) {}
		else result = Math.max(result, a[y][x]+a[y+1][x]+a[y+2][x]+a[y+3][x]);
		// 2_1
		if( x + 1 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x]+a[y+1][x+1]);
		// 3_1
		if( x + 1 >= M || y + 2 >= N) {}
		else result = Math.max(result, a[y][x]+a[y+1][x]+a[y+2][x]+a[y+2][x+1]);
		// 3_2
		if( x + 2 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y+1][x+2]);
		// 3_3
		if( x + 2 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y+1][x]);
		// 3_4
		if( x + 1 >= M || y + 2 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x+1]+a[y+2][x+1]);
		// 3_5
		if( x + 1 >= M || y - 2 < 0) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y-1][x+1]+a[y-2][x+1]);
		// 3_6
		if( x + 1 >= M || y + 2 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x]+a[y+2][x]);
		// 3_7
		if( x + 2 >= M || y - 1 < 0) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y-1][x+2]);
		// 3_8
		if( x + 2 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y+1][x]+a[y+1][x+1]+a[y+1][x+2]);
		
		// 4_1
		if( x + 2 >= M || y + 2 >= N) {}
		else result = Math.max(result, a[y][x]+a[y+1][x]+a[y+1][x+1]+a[y+2][x+1]);
		// 4_2
		if( x + 2 >= M || y - 1 < 0) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y-1][x+1]+a[y-1][x+2]);
		// 4_3
		if( x + 2 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x+1]+a[y+1][x+2]);
		// 4_4
		if( x + 1 >= M || y + 1 >= N || y - 1 < 0) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x]+a[y-1][x+1]);
		
		// 5_1
		if( x + 1 >= M || y + 2 >= N) {}
		else result = Math.max(result, a[y][x]+a[y+1][x]+a[y+1][x+1]+a[y+2][x]);
		// 5_2
		if( x + 2 >= M || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y+1][x+1]);
		// 5_3
		if( x + 1 >= M || y - 1 < 0 || y + 1 >= N) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y+1][x+1]+a[y-1][x+1]);
		// 5_4
		if( x + 2 >= M || y - 1 < 0) {}
		else result = Math.max(result, a[y][x]+a[y][x+1]+a[y][x+2]+a[y-1][x+1]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		result = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N][M];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
			{
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				solve(i, j);
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}