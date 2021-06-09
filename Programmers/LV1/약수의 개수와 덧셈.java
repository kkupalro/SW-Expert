class Solution {
    static int solve(int n) {
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if(n % i == 0) {
        cnt++;
      }
    }
    if(cnt % 2 == 1) {
      n *= -1;
    }
    return n;
  }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
          answer += solve(i);
    }
        
        return answer;
    }
}