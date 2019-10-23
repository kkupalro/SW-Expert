package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, A, B, result;
	static int play;
	static int dp[][];
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
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		if(N % 2 == 1) {
			play = N+1;
		}
		else play = N;
		int tmp = play;
		int cnt = 0;
		while(tmp > 0)
		{
			tmp /= 2;
			cnt++;
		}
		dp = new int[cnt+1][];
		dp[0] = new int[N];
		for(int i = 1; i <= N; i++)
		{
			dp[0][i-1] = i;
		}
		for(int i = 1; i <= cnt; i++)
		{
			int len = dp[i-1].length;
			if(len % 2 == 1) {
				dp[i] = new int[(len / 2) + 1];
				dp[i][dp[i].length-1] = dp[i-1][dp[i-1].length-1];
			}
			else dp[i] = new int[len / 2];
			int idx = 0;
			for(int j = 0; j < dp[i-1].length - 1; j+=2)
			{
				if(dp[i-1][j] == A && dp[i-1][j+1] == B || dp[i-1][j] == B && dp[i-1][j+1] == A )
				{
					result = i;
					break;
				}
				else {
					if(dp[i-1][j] == A)
					{
						dp[i][idx++] = A;
						continue;
					}
					else if(dp[i-1][j] == B)
					{
						dp[i][idx++] = B;
						continue;
					}
					else if(dp[i-1][j+1] == A)
					{
						dp[i][idx++] = A;
						continue;
					}
					else if(dp[i-1][j+1] == B)
					{
						dp[i][idx++] = B;
						continue;
					}
					else 
						dp[i][idx++] = Math.max(dp[i-1][j], dp[i-1][j+1]);
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
