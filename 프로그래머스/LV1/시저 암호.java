class Solution {
  public String solution(String s, int n) {
      String answer = "";
      // A : 65 , Z : 90, A ~ Z : 25
      // a : 97 , z :122. a ~ z : 25
      for(int i = 0; i < s.length(); i++)
      {
          int num = (int)s.charAt(i);
          if(num >= 65 && num <= 90) 
          {
              num += n;
              num = (num>90)?num-26:num;
              answer += (char)num;
          }
          else if(num >= 97 && num <= 122)
          {
              num += n;
              num = (num>122)?num-26:num;
              answer += (char)num;
          }
          else answer += " ";
      }
      return answer;
  }
}
