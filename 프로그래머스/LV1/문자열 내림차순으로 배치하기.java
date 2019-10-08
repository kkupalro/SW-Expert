class Solution {
  public String solution(String s) {
      String answer = "";
      int ans[] = new int[s.length()];
      for(int i = 0; i < s.length(); i++)
      {
          ans[i] = (int)s.charAt(i);
      }
      for(int i = 0; i < ans.length; i++)
      {
          for(int j = i+1; j < ans.length; j++)
          {
              if(ans[i] < ans[j])
              {
                  ans[i] ^= ans[j];
                  ans[j] ^= ans[i];
                  ans[i] ^= ans[j];
              }
          }
      }
      for(int i = 0; i < ans.length; i++)
      {
          answer += (char)ans[i];
      }
      return answer;
  }
}
