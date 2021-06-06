class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int dupCnt = 0; // lost와 reserve가 같은경우
        int resCnt = 0; // 빌려준 횟수
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1; // 자신에게 빌려줌
                    dupCnt++;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1){
                    reserve[j] = -1; // 더이상 빌려줄수없음
                    resCnt++;
                    break;
                }
            }
        }
        
        return answer = n + dupCnt - lost.length + resCnt;
    }
}