import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 1003|BOJ|차이를 최대로|10819
 *
 */

public class Main {
	static int N;
	static StringTokenizer st;
	static int input[];
	static int answer = -1;
	static boolean visit[];
	static int arr[];

	static void comb(int idx, int cnt, int[] input) {

		// 기저 조건
		if (cnt == N) {
			answer = Math.max(answer, calc());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			arr[cnt] = input[i];
			comb(i, cnt + 1, input);
			visit[i] = false;
		}
	}

	static int calc() {
		int result = 0;
		for (int i = 1; i < N; i++) {
			result += Math.abs(arr[i - 1] - arr[i]);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[N];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			arr[0] = input[i];
			comb(i, 1, input);
			visit[i] = false;
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}