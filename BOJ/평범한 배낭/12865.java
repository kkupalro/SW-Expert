package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0902|BOJ|평범한 배낭|12865
 *
 */
public class Main {
	static int N, K;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int W[] = new int[N + 1];
		int V[] = new int[N + 1];
		int dp[][] = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - W[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - W[i]] + V[i]);
				}
			}
		}
		bw.write(dp[N][K] + "\n");
		bw.flush();
		bw.close();
	}
}