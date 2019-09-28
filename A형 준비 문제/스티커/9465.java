import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int matrix[][] = new int[2][100001];
	static int dp[][] = new int[2][100001];
	static int T, N;
	static void print(int a[][]) {
		System.out.println("=================");
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 1; j <= N; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());			
			for(int i = 0; i < 2; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = matrix[0][1];
			dp[1][1] = matrix[1][1];
			for(int i = 2; i <= N; i++)
			{
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + matrix[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + matrix[1][i];
			}
			bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
