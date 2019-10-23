package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int matrix[][];
	static int W[][] = new int[8][8];
	static int B[][] = new int[8][8];
	static int N, M, result;
	static void print(int a[][]) {
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve(int y, int x) {
		int r = 0; int c = 0; int ans = 0;
		for(int i = y; i < y+8; i++)
		{
			c = 0;
			for(int j = x; j < x+8; j++)
			{
				if(matrix[i][j] != W[r][c])
				{
					ans++;
				}
				c++;
			}
			r++;
		}
		result = Math.min(result, ans);
		ans = 0; r = 0; c = 0;
		for(int i = y; i < y+8; i++)
		{
			c = 0;
			for(int j = x; j < x+8; j++)
			{
				if(matrix[i][j] != B[r][c])
				{
					ans++;
				}
				c++;
			}
			r++;
		}
		result = Math.min(result, ans);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		result = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		boolean flag = false;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				flag ^= true;
				if(flag)
				{
					W[i][j] = 0;
					B[i][j] = 1;
				}
				else
				{
					W[i][j] = 1;
					B[i][j] = 0;
				}
			}
			flag ^= true;
		}
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < M; j++)
			{
				if(sb.charAt(j) == 'B')
				{
					matrix[i][j] = 1;
				}
				else
				{
					matrix[i][j] = 0;
				}
			}
			sb.setLength(0);
		}
		for(int i = 0; i < N; i++)
		{
			if(i+8 > N) continue;
			for(int j = 0; j < M; j++)
			{
				if(j+8 > M) continue;
				solve(i, j);
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
