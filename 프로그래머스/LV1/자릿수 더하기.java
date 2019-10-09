public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>0)
        {
            answer += n % 10; // 3
            n /= 10;
        }
        return answer;
    }
}
