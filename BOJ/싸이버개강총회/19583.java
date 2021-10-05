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
 * @commit 1005|BOJ|싸이버개강총회|19583
 *
 */

class Node {
	boolean start, end;
	Node(boolean start, boolean end){
		this.start = start;
		this.end = end;
	}
}

public class Main {
	static int result;
	static int S, E, Q;
	static StringBuilder sb;
	static StringTokenizer st;
	static String str[];
	static String input[];
	static TreeMap<String, Node> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		str = st.nextToken().split(":");
		S = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
		str = st.nextToken().split(":");
		E = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
		str = st.nextToken().split(":");
		Q = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
		
		String s = null;
		while((s = br.readLine()) != null) {
			input = s.split(" "); // input[0] : 23:00, input[1] : 906bc
			str = input[0].split(":");
			int time = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
			String key = input[1];
			Node n = new Node(false, false);

			if(time <= S) {
				// 입장
				if(map.containsKey(key)) {
					n = map.get(key);
				}
				n.start = true;
				map.put(key, n);
				
			} else if(time >= E && time <= Q) {
				// 퇴장
				if(map.containsKey(key)) {
					n = map.get(key);
				}
				n.end = true;
				map.put(key, n);
			}
		}
		
		for (String k : map.keySet()) {
			Node n = map.get(k);
			if(n.start && n.end) {
				result++;
			}
		}
		
		bw.write(result +  "\n");
		bw.flush();
		bw.close();
	}
}