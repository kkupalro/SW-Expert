package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int dp[] = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= N; i++)
		{
			dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
		}
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
	}
}
