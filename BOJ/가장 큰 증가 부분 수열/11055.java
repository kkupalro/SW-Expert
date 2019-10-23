import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int dp[];
	static int A[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++)
		{
			dp[i] = A[i];
			for(int j = 0; j < i; j++)
			{
				if(A[j] < A[i])
				{
					dp[i] = Math.max(dp[i], dp[j] + A[i]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

