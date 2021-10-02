package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 1002|BOJ|나는야 포켓몬 마스터 이다솜|1620
 *
 */

public class Main {
	static int N, M;
	static StringTokenizer st;
	static LinkedHashMap<String, String> keyMap = new LinkedHashMap<String, String>();
	static LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String key = String.valueOf(i);
			String value = br.readLine();
			keyMap.put(key, value);
			valueMap.put(value, key);
		}
		while (M-- > 0) {
			String input = br.readLine();
			if (keyMap.containsKey(input)) {
				bw.write(keyMap.get(input) + "\n");
			} else {
				bw.write(valueMap.get(input) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}