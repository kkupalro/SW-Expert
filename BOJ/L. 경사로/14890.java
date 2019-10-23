package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, L, result;
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
		System.out.println("===========================");
	}
	
	static void solve(int n) {
		// 1. 가로 검사
		int data = matrix[n][0];
		int cnt = 1;
		boolean flag = true;
		for(int i = 1; i < N; i++)
		{
			if(matrix[n][i] == data)
			{
				cnt++;
				continue;
			}
			else if(matrix[n][i] != data)
			{
				if(Math.abs(matrix[n][i] - data) > 1)
				{
					flag = false;
					break;
				}
				else
				{
					// 내리막길
					if(matrix[n][i] < data)
					{
						if(i+L > N)
						{
							flag=false;
							break;
						}
						data = matrix[n][i];
						int count = 0;
						for(int j = i; j < N; j++)
						{
							if(matrix[n][j] == data)
							{
								count++;
							}
							else break;
						}
						if(count < L)
						{
							flag = false;
							break;
						}
						data = matrix[n][i];
						cnt = -L+1;
						continue;
					}
					// 오르막길
					else if(matrix[n][i] > data)
					{
						if(cnt < L)
						{
							flag = false;
							break;
						}						
						else
						{
							data = matrix[n][i];
							cnt = 1;
							continue;
						}
					}
				}
			}
		}
		if(flag)
		{
			result++;
		}
		// 2. 세로 검사
		data = matrix[0][n];
		cnt = 1;
		flag = true;
		for(int i = 1; i < N; i++)
		{
			if(matrix[i][n] == data)
			{
				cnt++;
				continue;
			}
			else if(matrix[i][n] != data)
			{
				if(Math.abs(matrix[i][n] - data) > 1)
				{
					flag = false;
					break;
				}
				else
				{
					// 내리막길
					if(matrix[i][n] < data)
					{
						if(i+L > N)
						{
							flag=false;
							break;
						}
						data = matrix[i][n];
						int count = 0;
						for(int j = i; j < N; j++)
						{
							if(matrix[j][n] == data)
							{
								count++;
							}
							else break;
						}
						if(count < L)
						{
							flag = false;
							break;
						}
						cnt = -L+1;
						continue;
					}
					// 오르막길
					else if(matrix[i][n] > data)
					{
						if(cnt < L)
						{
							flag = false;
							break;
						}
						else
						{
							data = matrix[i][n];
							cnt = 1;
							continue;
						}
					}
				}
			}
		}
		if(flag)
		{
			result++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new  StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		result = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++)
		{
			solve(i);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}