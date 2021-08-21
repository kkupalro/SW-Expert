import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author yoo
 * @commit 0703|Programmers|부정행위자
 *
 */
public class Main {
	static StringTokenizer st;
	static TreeSet<String> set = new TreeSet<String>();
	static TreeMap<String, TreeMap<Integer, Integer>> treeMap = new TreeMap<String, TreeMap<Integer,Integer>>();

	static void calc(String curKey) {
		
		for (String targetKey : treeMap.keySet()) {
			if (targetKey.equals(curKey)) continue;
			if (set.contains(curKey)) continue;

			// 조건1
			if (treeMap.get(curKey).size() == treeMap.get(targetKey).size()) {
				// 조건 2, 3 => equlas()로 판별
				if (treeMap.get(curKey).equals(treeMap.get(targetKey))) {
					set.add(curKey);
					set.add(targetKey);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String input[] = { 
				"0001 5 90", "0001 3 95", "0001 3 90", "0001 5 100", "0002 3 95", 
				"0001 7 80", "0001 8 80", "0001 10 90","0002 10 90", "0002 8 80",
				"0002 7 80", "0002 5 100","0003 99 90" 
				};

		for (int i = 0; i < input.length; i++) {
			st = new StringTokenizer(input[i], " ");
			String key = st.nextToken(); // 문제 푼사람
			int n = Integer.parseInt(st.nextToken()); // 문제 번호
			int score = Integer.parseInt(st.nextToken()); // 문제 점수
			TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>(); // <문제 번호, 문제 점수>를 담는 트리맵
			if (treeMap.containsKey(key)) {
				temp = treeMap.get(key);
				if (temp.containsKey(n)) {
					temp.put(n, Math.max(temp.get(n), score));
				} else {
					temp.put(n, score);
				}
				treeMap.put(key, temp);
			} else {
				temp.put(n, score);
				treeMap.put(key, temp);
			}
		}
		for (String key : treeMap.keySet()) {
			calc(key);
		}
		
		String[] result = set.toArray(new String[set.size()]);

		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i] + " ");
		}
	}
}