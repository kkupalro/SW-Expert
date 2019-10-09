class Solution {
  public int solution(int num) {
      int answer = -1;
      int t = 500;
      while(t-- > 0 && num != 1)
      {
          if(num % 2 == 0)
          {
              num /= 2;
          }
          else if(num % 2 == 1)
          {
              num = (num * 3) + 1;
          }
      }
      if(t < 0) answer = -1;
      else answer = 499-t;
      return answer;
  }
}
