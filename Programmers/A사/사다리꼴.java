import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author yoo
 * @commit 0703|Programmers|사다리꼴
 *
 */
public class Main {
	static StringTokenizer st;
	static TreeSet<String> set = new TreeSet<String>();
	static TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<Integer, ArrayList<Integer>>();
	static TreeMap<Integer, Integer> subMap = new TreeMap<Integer, Integer>();
	static ArrayList<Integer> keyList = new ArrayList<Integer>();
	static int answer;

	static void calc(int idx, Integer sy, Integer sx) {
		int area = 0;
		int y = 0;
		int x = 0;
		for (int i = idx + 1; i < keyList.size(); i++) {
			x = sx + subMap.get(keyList.get(i));
			y = Math.abs(sy - keyList.get(i));
			area = x * y;
			answer = Math.max(answer, area);
		}
	}

	public static void main(String[] args) throws IOException {
		int x[] = { 1, 4, 2, 3, 1, 3, 2, 4 }; // 길이 1~10000
		int y[] = { 1, 1, 2, 2, 3, 3, 4, 4 }; // 길이 1~10000

		// step1: (y, x) 좌표 treeMap에 저장
		for (int i = 0; i < x.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (treeMap.containsKey(y[i])) {
				list = treeMap.get(y[i]);
				list.add(x[i]);
				Collections.sort(list);
			} else {
				list.add(x[i]);
			}
			treeMap.put(y[i], list);
		}

		// step2: (key : y, values : 최대x - 최소x)로 subMap에 저장
		for (int n : treeMap.keySet()) {
			if (treeMap.get(n).size() < 1)
				continue;
			int xLen = treeMap.get(n).get(treeMap.get(n).size() - 1) - treeMap.get(n).get(0);
			subMap.put(n, xLen);
		}

		// step3: 조합으로 사다리꼴 최대 넓이 계산
		keyList = new ArrayList<Integer>(subMap.keySet());
		for (int i = 0; i < keyList.size(); i++) {
			calc(i, keyList.get(i), subMap.get(keyList.get(i)));
		}
		System.out.println(answer);
	}
}