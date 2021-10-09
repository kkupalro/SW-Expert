class Solution {
    static String answer = "";
    
	static void calcScore(int score) {
		if (score >= 90) {
			answer += "A";
		} else if (score >= 80 && score < 90) {
			answer += "B";
		} else if (score >= 70 && score < 80) {
			answer += "C";
		} else if (score >= 50 && score < 70) {
			answer += "D";
		} else if (score < 50) {
			answer += "F";
		}
	}
    
    public String solution(int[][] scores) {
		for (int i = 0; i < scores.length; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int cnt = 0;

			for (int j = 0; j < scores[i].length; j++) {
				max = Math.max(max, scores[j][i]);
				min = Math.min(min, scores[j][i]);
				sum += scores[j][i];
				cnt += 1;
			}

			isMax:
			if (scores[i][i] == max) {
				for (int j = 0; j < scores[i].length; j++) {
					if (i == j) continue;
					if (scores[j][i] == max) {
						break isMax;
					}
				}
				sum -= scores[i][i];
				cnt -= 1;
			}
			
			isMin:
			if (scores[i][i] == min) {
				for (int j = 0; j < scores[i].length; j++) {
					if (i == j) continue;
					if (scores[j][i] == min) {
						break isMin;
					}
				}
				sum -= scores[i][i];
				cnt -= 1;
			}

			calcScore(sum / cnt);
		}
        return answer;
    }
}