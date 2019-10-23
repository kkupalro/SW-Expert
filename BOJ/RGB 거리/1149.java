package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int result, N;
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		int dp[][] = new int[3][N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			dp[0][i] = Integer.parseInt(st.nextToken());
			dp[1][i] = Integer.parseInt(st.nextToken());
			dp[2][i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++)
		{
			dp[0][i] += Math.min(dp[1][i-1], dp[2][i-1]);
			dp[1][i] += Math.min(dp[0][i-1], dp[2][i-1]);
			dp[2][i] += Math.min(dp[0][i-1], dp[1][i-1]);
		}
		result = Math.min(dp[0][N-1], Math.min(dp[1][N-1], dp[2][N-1]));
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
