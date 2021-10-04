package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/**
 * @author yoo
 * @commit 1004|BOJ|서로 다른 부분 문자열의 개수|11478
 *
 */

public class Main {
	static StringBuilder sb;
	static HashSet<String> set = new HashSet<>();

	static void Combination(int idx, String word) {
		word += sb.charAt(idx);
		set.add(word);
		// 기저 조건
		if (idx >= sb.length() - 1) {
			return;
		}
		Combination(idx + 1, word);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder(br.readLine());

		/**
		 * TODO : 조합 (idx, 조합된문자)
		 */
		for (int i = 0; i < sb.length(); i++) {
			Combination(i, new String());
		}
		bw.write(set.size() + "\n");
		bw.flush();
		bw.close();
	}
}