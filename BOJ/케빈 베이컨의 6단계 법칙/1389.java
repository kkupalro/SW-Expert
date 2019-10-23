package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int min = Integer.MAX_VALUE;
	static int result = 0;
	static int N, M;
	static int matrix[][] = new int[101][101];
	static void floyd() {
		for(int k = 1; k <= N; k++)
		{
			for(int i = 1; i <= N; i++)
			{
				for(int j = 1; j <= N; j++)
				{
					if(i == j) continue;
					else if(matrix[i][k] != 0 && matrix[k][j] != 0)
					{
						if(matrix[i][j] == 0)
						{
							matrix[i][j] = matrix[i][k] + matrix[k][j]; 
						}
						else
						{
							matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
						}
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
		result = 0;
		min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = 1;
			// 양방향 그래프
		}
		floyd();
		for(int i = 1; i <= N; i++)
		{
			int sum = 0;
			for(int j = 1; j <= N; j++)
			{
				sum += matrix[i][j];
			}
			if(min > sum)
			{
				result = i;
				min = sum;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
