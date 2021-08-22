class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
		long res = 0L;

		for (int i = 1; i <= count; i++) {
			res += price * i;
		}

		if (money >= res) {
			answer = 0L;
		} else {
			answer = res - money;
		}

        return answer;
    }
}