public class Solution {
	static StringBuilder sb = new StringBuilder();
	public int solution(int n) {
		int answer = 0;
		sb.append(n);
		for (int i = 0; i < sb.length(); i++) {
			answer += Character.getNumericValue(sb.charAt(i));
		}
		return answer;
	}
}