class Solution {
  static final String[] str = {"Even", "Odd"};
  public String solution(int num) {
      String answer = "";
      answer = str[Math.abs(num%2)];
      return answer;
  }
}
