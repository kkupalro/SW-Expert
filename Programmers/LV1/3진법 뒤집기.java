class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 3); // 0, 0, 2, 1
			n /= 3; // 15, 5, 1, 0
		}

		for (int i = sb.length() - 1; i >= 0; i--) {
			answer += (sb.charAt(i) - '0') * (Math.pow(3, sb.length() - i - 1));
		}
        return answer;
    }
}