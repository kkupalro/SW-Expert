class Solution {
  static final String code[] = {"4", "1", "2"};
  public String solution(int n) {
      String answer = "";
      int idx = 0;
      while(n > 0)
      {
          idx =  n % 3;
          n /= 3;
          n = (idx==0)?n-1:n;
          answer = code[idx] + answer;
      }
      return answer;
  }
}
