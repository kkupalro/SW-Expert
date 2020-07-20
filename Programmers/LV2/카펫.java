class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int sum = brown + red;
        for(int i = 2; i <= sum; i++)
        {
            // 약수
            if(sum % i == 0)
            {
                int Y = i;
                int X = sum / i;
                if(X > Y) continue;
                int cnt = (Y-2)*2 + (2*X);
                if(brown == cnt && red == ((Y*X) - cnt))
                {
                    answer[0] = Y;
                    answer[1] = X;
                    break;
                }
            }
        }
        return answer;
    }
}
