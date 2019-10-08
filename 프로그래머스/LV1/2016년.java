class Solution {
  static final String DAY[] = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
  static int dp[] = new int[13];
  public String solution(int a, int b) {
      String answer = "";
      for(int i = 2; i <= 12; i++)
      {
          dp[i] += dp[i-1];
          if(i == 3)
          {
              dp[i] += 29;
          }
          else if(i == 5 || i == 7 || i == 10 || i == 12)
          {
              dp[i] += 30;
          }
          else dp[i] += 31;
      }
      answer = DAY[(dp[a] + b) % 7];
      return answer;
  }
}
