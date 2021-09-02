package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author yoo
 * @commit 0901|BOJ|K번째 수|1300
 *
 */
public class Main {
	static int N, K;
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = K;
		long mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			long cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			if (cnt < K) {
				left = mid + 1;
			} else {
				result = mid;
				right = mid - 1;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();

	}
}