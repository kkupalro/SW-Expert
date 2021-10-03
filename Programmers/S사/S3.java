package pro;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String answer;

	static void antPermutation(int n) {
		String s = "1";
		while (n-- > 1) {
			String result = "";
			sb = new StringBuilder(s);
			int len = sb.length();
			for (int i = 0; i < len; i++) {
				char c = sb.charAt(i);
				int cnt = 1;
				for (int j = i + 1; j < len; j++) {
					if (sb.charAt(j) == c) {
						cnt++;
					} else {
						break;
					}
					i = j;
				}
				result += c + "" + cnt;
			}
			s = result;
		}
		answer = s;
	}

	static String solution(int n) {
		antPermutation(n);
		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = 10;
		System.out.println(solution(n));
	}
}