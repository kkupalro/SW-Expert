class Solution {
  public int solution(int n) {
      int answer = 0;
      boolean eratosthenes[] = new boolean[1000001];
      // 에라토스테네츠의 체
      for(int i = 2; i < 1000001; i ++)
      {
          for(int j = i; j < 1000001; j+=i)
          {
              if(i == j) continue;
              if(eratosthenes[j]) continue;
              eratosthenes[j] = true;
          }
      }
      for(int i = 2; i <= n; i++)
      {
          if(!eratosthenes[i]) answer++;
      }
      return answer;
  }
}
