class Solution {
    static int calc(int krw, int min, int add_min, int add_krw, int minutes) {
        int cost = 0;
        cost += krw;
        minutes -= min;
        while (minutes > 0) {
            minutes -= add_min;
            cost += add_krw;
        }
        return cost;
    }
    public int solution(int[][] passes, int minutes) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < passes.length; i++) {
            answer = Math.min(calc(passes[i][0], passes[i][1], passes[i][2], passes[i][3], minutes), answer);
        }

        return answer;
    }
}