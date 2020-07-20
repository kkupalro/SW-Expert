class Solution {
  public int solution(int[] d, int budget) {
      int answer = 0;
      for(int i = 0; i < d.length-1; i++)
      {
          for(int j = i+1; j < d.length; j++)
          {
              if(d[i] > d[j])
              {
                  d[i] ^= d[j];
                  d[j] ^= d[i];
                  d[i] ^= d[j];
              }
          }
      }
      for(int i = 0; i < d.length; i++)
      {
          if(budget >= d[i]) 
          {
              budget -= d[i];
              answer++;
          }
          else break;
      }
      return answer;
  }
}
