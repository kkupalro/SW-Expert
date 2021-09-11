class Solution {
	static int N;
	static int score = 0;
	static int answer[];
	static boolean visit[];

	static void calcScore(int[] info) {
		for (int i = 0; i < info.length; i++) {
			if(visit[i]) {
				answer[i] = info[i] + 1;
			} else {
				answer[i] = 0;
			}
		}
	}    
    
	static void comb(int idx, int[] info) {
		// 기저 조건
		if(idx == info.length - 1) {
			// TODO 계산
			int num = 0;
			int cnt = N;
			for (int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					cnt -= info[i] + 1;
					if(cnt < 0) {
						return;
					}
					num = num + (10 - i);
				} else {
					if(info[i] > 0) {
						num = num - (10 - i);
					}
				}
			}
		
			if(num > 0) {
				if(num > score) {
					// TODO 결과값 옮기기
					score = num;
					calcScore(info);
					// TC 18번 반례 찾기 실패
                    if(cnt > 0){
                        answer[10] += cnt;
                    }
                    
				} else if(num == score) {
					// TODO 낮은점수 우선순위
					for (int i = 10; i > 0; i--) {
						if(visit[i] && answer[i] == 0) {
							calcScore(info);
                            return;
						}
					}
				}
			}
			return;
		}

		idx += 1;
		if(idx <= info.length) {
	        visit[idx] = true;
	        comb(idx, info);
	        visit[idx] = false;
	        comb(idx, info);
		}
	} 
    
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        visit = new boolean[info.length];

        N = n;
        
        // 조합
        visit[0] = true;
        comb(0, info);
        visit[0] = false;
        comb(0, info);

        if(score == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}