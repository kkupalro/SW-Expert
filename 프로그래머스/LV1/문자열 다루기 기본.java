class Solution {
  public boolean solution(String s) {
      boolean answer = true;
      // 48(0) ~ 57(9)
      if(s.length() == 4 || s.length() == 6)
      {
          for(int i = 0; i < s.length(); i++)
          {
            int n = (int)s.charAt(i);
            if(n < 48 || n > 57) 
            {
                answer = false;
                break;
            }
          }
      }
      else
      {
          answer = false;
          
      }
      return answer;
  }
}
