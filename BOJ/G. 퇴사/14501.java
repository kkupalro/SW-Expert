package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int T[];
	static int P[];
	static int dp[];
	static void print(int a[]) {
		for(int i = 1; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("==========================");
	}
	static void dfs(int idx, int sum) {
		if(idx == N+1)
		{
			result = Math.max(result, sum);
			return;
		}
		if(idx + T[idx] <= N + 1)
		{
			dfs(idx + T[idx], sum + P[idx]);
		}
		
		dfs(idx+1, sum);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		result = 0;
		N = Integer.parseInt(br.readLine());
		T = new int[N+10];
		P = new int[N+10];
		dp = new int[N+10];
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		// dp
		for(int i = 1; i <= N+1; i++)
		{
			dp[i] = Math.max(dp[i], result);
			dp[T[i]+i] = Math.max(dp[T[i]+i], P[i] + dp[i]);
			result = Math.max(result, dp[i]);
		}
		//dfs(1, 0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}