class Solution {
  public boolean solution(int x) {
      boolean answer = true;
      int n = x;
      int sum = 0;
      while(x >= 1)
      {
          sum += x%10;
          x = x / 10;
      }
      answer = (n%sum == 0)?true:false;
      return answer;
  }
}
