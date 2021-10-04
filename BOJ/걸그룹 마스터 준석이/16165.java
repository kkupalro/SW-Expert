package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author yoo
 * @commit 1004|BOJ|걸그룹 마스터 준석이|16165
 *
 */

public class Main {
	static int N, M;
	static StringTokenizer st;
	static TreeMap<String, ArrayList<String>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new TreeMap<String, ArrayList<String>>();

		// TODO : <걸그룹명, 멤버명(사전순)>
		for (int i = 0; i < N; i++) {
			String key = br.readLine();
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> list = new ArrayList<String>();
			while (n-- > 0) {
				list.add(br.readLine());
			}
			Collections.sort(list);
			map.put(key, list);
		}

		/**
		 * TODO : 퀴즈 정답 
		 * 0 : key(걸그룹명), 1 : value(멤버명)
		 */
		for (int i = 0; i < M; i++) {
			String answer = br.readLine();
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				ArrayList<String> list = map.get(answer);
				for (String member : list) {
					bw.write(member + "\n");
				}
			} else {
				for (String key : map.keySet()) {
					ArrayList<String> list = map.get(key);
					if (list.contains(answer)) {
						bw.write(key + "\n");
						break;
					}
				}
			}

		}

		bw.flush();
		bw.close();
	}
}