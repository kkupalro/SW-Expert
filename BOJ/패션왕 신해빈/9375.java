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
 * @commit 1004|BOJ|패션왕 신해빈|9375
 *
 */

public class Main {
	static int T, n;
	static StringTokenizer st;
	static TreeMap<String, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int result = 1;
			n = Integer.parseInt(br.readLine());
			map = new TreeMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 1) + 1);
			}

			/** TODO : 조합
			 * value : 각의상 Key 마다 안입을경우 + 1
			 * result: 모두 안입을 경우 -1
			 * 
			 */
			for (int num : map.values()) {
				result *= num;
			}
			bw.write(--result + "\n");
		}
		bw.flush();
		bw.close();
	}
}