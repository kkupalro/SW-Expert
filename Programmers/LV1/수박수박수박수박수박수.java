class Solution {
    public String solution(int n) {
    String answer = "";
    boolean flag = false;
    while (n-- > 0) {
      if (flag ^= true) {
        answer += "수";
      } else {
        answer += "박";
      }
    }
    return answer;
  }
}