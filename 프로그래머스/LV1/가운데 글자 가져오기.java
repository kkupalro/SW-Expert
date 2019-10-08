class Solution {
  public String solution(String s) {
      String answer = "";
      int len = s.length() / 2;
      // 홀 수
      if(s.length() % 2 == 1)
      {
          answer = Character.toString(s.charAt(len));
      }
      // 짝 수
      else
      {
          len--;
          answer = Character.toString(s.charAt(len)) + Character.toString(s.charAt(len+1));
      }
      return answer;
  }
}
