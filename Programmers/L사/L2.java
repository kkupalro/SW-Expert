package pro;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static int result;
	static int value;
	static TreeSet<Character> ts = new TreeSet<>();
	static TreeMap<Character, ArrayList<Integer>> tm = new TreeMap<Character, ArrayList<Integer>>();
	static String answer = "";

	static String solution(String[] research, int n, int k) {
		// TODO 중복 문자제거
		for (String s : research) {
			for (char c : s.toCharArray()) {
				tm.put(c, new ArrayList<>());
			}
		}

		// TODO 일자별 계산
		for (char c : tm.keySet()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (String s : research) {
				int cnt = 0;
				for (char w : s.toCharArray()) {
					if (w == c) {
						cnt++;
					}
				}
				list.add(cnt<k?0:cnt);
			}
			tm.put(c, list);
		}

		// TODO 이슈 결과 : n 연속, k 이상, result 총 이상
		for (char c : tm.keySet()) {
			ArrayList<Integer> list = tm.get(c);
			value = 0;
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) == 0) continue;
				comb(1, 0, i, n, k, list);
			}
			
			if (value >= result) {				
				if(!answer.equals("")){
					answer = answer.charAt(0) < c ? answer : c + "";
				}
				else {
					answer = c + "";
				}
			}
		}
		return answer;
	}

	static void comb(int cnt, int score, int idx, int n, int k, ArrayList<Integer> list) {
		score += list.get(idx);
		// TODO 기저 조건
		if(cnt == n) {
			value += score;
			return;
		}

		// TODO 계산
		idx = idx + 1;
		if(idx < list.size() - 1) {
			if (list.get(idx) > 0) {
				comb(cnt + 1, score, idx, n, k, list);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String[] research = { "abaaaa", "aaa", "abaaaaaa", "fzfffffffa" };
		int n = 2;
		int k = 2;
		result = 2 * n * k;
		System.out.println(solution(research, n, k));
	}
}