class Solution {
    public String solution(String s) {
        int len = s.length() / 2;

    if (s.length() % 2 == 0) {
      return s.substring(len - 1, len + 1);
    }
    return String.valueOf(s.charAt(len));
    }
}