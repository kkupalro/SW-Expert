class Solution {
  public String solution(String phone_number) {
      String answer = "";
      int size = phone_number.length() - 4;
      for(int i = 0; i < phone_number.length(); i++)
      {
          if(i < size) answer += "*";
          else answer += phone_number.charAt(i);
      }
      return answer;
  }
}
