package pro;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int answer = Integer.MAX_VALUE;
	static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

	static int solution(int input[]) {
		
		for (int i = 0; i < input.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			if(map.containsKey(input[i])) {
				list = map.get(input[i]);
				list.add(i);
			} else {
				list.add(i);
			}
			map.put(input[i], list);
		}
		
		for (int n : map.keySet()) {
			if(map.get(n).size() == 0) continue;
			ArrayList<Integer> list = map.get(n);
			for (int i = 1; i < list.size(); i++) {
				answer = Math.min(answer, list.get(i) - list.get(i-1));
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	public static void main(String[] args) throws Exception {
		int input[] = { 1, 2, 1, 1, 3 };
		System.out.println(solution(input));
	}
}