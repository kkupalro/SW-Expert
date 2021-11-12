class Solution {
    public String solution(String s, int n) {
    String answer = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        answer += " ";
      } else {
        int num = s.charAt(i);
        if (num >= 65 && num <= 90) {
          if (num + n > 90) {
            num += n - 26;
          } else {
            num += n;
          }
          answer += (char) num;

        } else if (num >= 97 && num <= 122) {
          if (num + n > 122) {
            num += n - 26;
          } else {
            num += n;
          }
          answer += (char) num;
        }
      }
    }

    return answer;
  }
}