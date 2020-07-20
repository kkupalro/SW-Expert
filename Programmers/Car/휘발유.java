class Solution {
    public int solution(int n, int[] P) {
        int cost = P[0];
        int answer = cost;
        for(int i = 1; i < n; i++)
        {
            if(cost <= P[i])
            {
                answer += cost;
            }
            else
            {
                cost = P[i];
                answer += cost;
            }
        }
        return answer;
    }
}
