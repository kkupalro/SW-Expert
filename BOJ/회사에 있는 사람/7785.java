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
 * @commit 1002|BOJ|회사에 있는 사람|7785
 *
 */

public class Main {
	static int N;
	static StringTokenizer st;
	static TreeMap<String, Boolean> tm = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			tm.put(key, st.nextToken().equals("enter") ? true : false);
		}
		for (String key : tm.descendingKeySet()) {
			if (tm.get(key)) {
				bw.write(key + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}