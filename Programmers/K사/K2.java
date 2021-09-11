package pro;

import java.util.ArrayList;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean eratosthenes[] = new boolean[1000001];
	static ArrayList<Long> al = new ArrayList<Long>();

	static void eratosthenes() {
		for (int i = 2; i < 100000; i++) {
			for (int j = i; j < 1000001; j += i) {
				if (i == j)
					continue;
				if (eratosthenes[j])
					continue;
				eratosthenes[j] = true;
			}
		}
	}

	static boolean bigSosu(long size) {
		for (long i = 2; i < size / 1000001; i++) {
			if (size % i == 0) {
				return false;
			}
		}

		return true;
	}

	static public int solution(int n, int k) {
		int answer = 0;
		// TODO 에라토스테네츠의 체
		eratosthenes();

		// TODO K진법 변환
		while (n >= 1) {
			sb.insert(0, n % k);
			n /= k;
		}

		// TODO 조합
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '0')
				continue;
			if (i > 0 && sb.charAt(i - 1) != '0')
				continue;
			comb(i, sb.charAt(i) + "");
		}

		// TODO 소수판별
		for (long num : al) {
			if (num == 1)
				continue;
			if (num > 1000001) {
				if (bigSosu(num)) {
					answer++;
				}
			} else {
				int idx = (int) num;
				if (!eratosthenes[idx]) {
					answer++;
				}
			}
		}
		return answer;
	}

	static void comb(int idx, String str) {
		// 기저 조건
		if (sb.charAt(idx) == '0' || idx == sb.length() - 1) {

			if (sb.charAt(idx) == '0') {
				al.add(Long.parseLong(str.substring(0, str.length() - 1)));
			} else {
				al.add(Long.parseLong(str));
			}
			return;
		}

		idx = idx + 1;
		if (idx < sb.length()) {
			str += sb.charAt(idx);
			comb(idx, str);
		}
	}

	public static void main(String[] args) throws Exception {
		int n = 1000000;
		int k = 6;
		System.out.println(solution(n, k));
	}
}