package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author yoo
 * @commit 1002|BOJ|무한 수열|1351
 *
 */

public class Main {
	static TreeMap<Long, Long> tm = new TreeMap<Long, Long>();
	static Long N;
	static int P, Q;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		tm.put(0L, 1L);
		bw.write(solve(N) + "\n");
		bw.flush();
		bw.close();
	}

	static long solve(long n) {
		// 기저 조건
		if (tm.containsKey(n)) {
			return tm.get(n);
		}
		if (n == 0) {
			return 1;
		}
		
		tm.put(n, solve((long) Math.floor(n / P)) + solve((long) Math.floor(n / Q)));
		return tm.get(n);
	}
}