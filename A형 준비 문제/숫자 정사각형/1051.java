package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result, size;
	static int matrix[][];
	static final int dy[] = {0, 1, 1}; // 0. -> 우,1. v 하, 3. \ 우하
	static final int dx[] = {1, 0, 1};
	static void print(int p[][])
	{
		for(int i = 0; i < p.length; i++)
		{
			for(int j = 0; j < p[i].length; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve(int y, int x, int data) {
		int ans = 1;
		int cnt = 0;
		for(int i = 1; i < size; i++)
		{
			cnt = 0;
			 for(int l = 0; l < 3; l++)
			 {
				 int ny = dy[l]*i + y;
				 int nx = dx[l]*i + x;
				 if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				 if(matrix[ny][nx] == data) {
					 cnt += 1;
				 }
			 }
			 if(cnt == 3)
			 {
				 ans = i+1;
			 }
		}
		
		result = Math.max(result, (int)Math.pow(ans, 2));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size = Math.min(N, M);
		matrix = new int[N][M];
		result = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < M; j++)
			{
				matrix[i][j] = (int)(sb.charAt(j) - '0');
			}
			sb.setLength(0);
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				solve(i,j, matrix[i][j]);
			}
		}
		//print(matrix);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
