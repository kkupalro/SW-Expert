package TEST;

import java.io.*;
import java.util.*;

public class Main {
	/*
	 * N : ������ ���� ũ��
	 * M : ������ ���� ũ��
	 * X : �ֻ��� X ��ǥ
	 * Y : �ֻ��� Y ��ǥ
	 * K : ����� ����
	 */
	static final int dy[] = {0, 0, 0,-1, 1}; // 1. ��, 2. �� , 3. ��, 4.��
	static final int dx[] = {0, 1,-1, 0, 0};
	static int N, M, x, y, K;
	static int A[];
	static long result;
	static int matrix[][];
	static int dice[][] = {{0, 0, 0},{0, 0, 0, 0}};
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
	static int[][] copy(int a[][])
	{
		int c[][] = {{0, 0, 0}, {0, 0, 0, 0}};
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				c[i][j] = a[i][j];
			}
		}
		return c;
	}
	static boolean solve(int c) {
		boolean flag = false;
		int copy[][] = copy(dice);
		// 1. -> ��, 2. <- ��, 3. ^ ��, 4. v ��
		switch (c) {
		case 1:
			y += dy[c];
			x += dx[c];
			if(x < 0 || x >= M || y < 0 || y >= N)
			{
				y -= dy[c];
				x -= dx[c];
				return false;
			}
			dice[0][0] = copy[1][3];
			dice[0][1] = copy[0][0];
			dice[1][1] = copy[0][0];
			dice[0][2] = copy[0][1];
			dice[1][3] = copy[0][2];
			if(matrix[y][x] == 0)
			{
				// ������ �ֻ����� �ٴڸ� ����
				matrix[y][x] = dice[1][3];
			}
			else {
				dice[1][3] = matrix[y][x];
				matrix[y][x] = 0;
			}
			flag = true;
			break;
		case 2:
			// ( �� <- )
			y += dy[c];
			x += dx[c];
			if(x < 0 || x >= M || y < 0 || y >= N)
			{
				y -= dy[c];
				x -= dx[c];
				return false;
			}
			dice[0][0] = copy[0][1];
			dice[0][1] = copy[0][2];
			dice[1][1] = copy[0][2];
			dice[0][2] = copy[1][3];
			dice[1][3] = copy[0][0];
			if(matrix[y][x] == 0)
			{
				// ������ �ֻ����� �ٴڸ� ����
				matrix[y][x] = dice[1][3];
			}
			else {
				dice[1][3] = matrix[y][x];
				matrix[y][x] = 0;
			}
			flag = true;
			break;
		case 3:
			// ( �� ^ )
			y += dy[c];
			x += dx[c];
			if(x < 0 || x >= M || y < 0 || y >= N)
			{
				y -= dy[c];
				x -= dx[c];
				return false;
			}
			dice[1][0] = copy[1][1];
			dice[0][1] = copy[1][2];
			dice[1][1] = copy[1][2];
			dice[1][2] = copy[1][3];
			dice[1][3] = copy[1][0];
			if(matrix[y][x] == 0)
			{
				// ������ �ֻ����� �ٴڸ� ����
				matrix[y][x] = dice[1][3];
			}
			else {
				dice[1][3] = matrix[y][x];
				matrix[y][x] = 0;
			}
			flag = true;
			break;
		case 4:
			// ( �� ^ )
			y += dy[c];
			x += dx[c];
			if(x < 0 || x >= M || y < 0 || y >= N)
			{
				y -= dy[c];
				x -= dx[c];
				return false;
			}
			dice[1][0] = copy[1][3];
			dice[1][1] = copy[1][0];
			dice[0][1] = copy[1][0];
			dice[1][2] = copy[1][1];
			dice[1][3] = copy[1][2];
			if(matrix[y][x] == 0)
			{
				// ������ �ֻ����� �ٴڸ� ����
				matrix[y][x] = dice[1][3];
			}
			else {
				dice[1][3] = matrix[y][x];
				matrix[y][x] = 0;
			}
			flag = true;
			break;
		}
		
		return flag;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++)
		{
			int command = Integer.parseInt(st.nextToken());
			if(solve(command))
			{
				bw.write(dice[1][1] + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}