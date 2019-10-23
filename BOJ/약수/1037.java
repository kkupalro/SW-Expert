package TEST;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long result;
	static long dp[];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		result = 1;
		dp = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			dp[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(dp);
		result = dp[0] * dp[N-1];
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
