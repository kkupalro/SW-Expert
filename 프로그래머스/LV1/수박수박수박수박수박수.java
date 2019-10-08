class Solution {
  public String solution(int n) {
      String answer = "";
      boolean check[] = new boolean[10001];
      boolean flag = false;
      for(int i = 0; i <= 10000; i++)
      {
          flag ^= true;
          check[i] = flag;
      }
      for(int i = 0; i < n; i++)
      {
          if(check[i]) answer += "수";
          else answer += "박";
      }
      return answer;
  }
}
