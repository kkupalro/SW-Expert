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
 * @commit 1004|BOJ|비밀번호 찾기|17219
 *
 */

public class Main {
	static int N, M;
	static StringTokenizer st;
	static TreeMap<String, String> map = new TreeMap<String, String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String value = st.nextToken();
			map.put(key, value);
		}

		while (M-- > 0) {
			bw.write(map.get(br.readLine()) + "\n");
		}

		bw.flush();
		bw.close();
	}
}