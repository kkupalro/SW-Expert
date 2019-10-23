package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int C[][] = new int[8][8];
	static int matrix[][];
	static int result;
	static void print(int a[][]) {
		System.out.println("=================");
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve(int y, int x) {
		int ans = 0;
		for(int i = y; i < y + 8; i++)
		{
			for(int j = x; j < x + 8; j++)
			{
				if(matrix[i][j] != C[i-y][j-x])
				{
					ans++;
				}
			}
		}
		ans = (ans>32)?64-ans:ans;
		result = Math.min(result, ans);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		matrix = new int[N][M];
		for(int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < M; j++) {
				if(sb.charAt(j) == 'B')
				{
					matrix[i][j] = 1;
				}
				else matrix[i][j] = 0;
			}
			sb.setLength(0);
		}
		boolean flag = false;
		for(int i = 0; i < 8; i++)
		{
			flag ^= true;
			for(int j = 0; j < 8; j++)
			{
				flag ^= true;
				if(flag)
				{
					C[i][j] = 1;
				}
				else
				{
					C[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(i + 8 > N || j + 8 > M) continue;			
				solve(i, j);
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

