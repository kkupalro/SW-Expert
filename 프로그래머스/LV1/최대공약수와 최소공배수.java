class Solution {
  public int[] solution(int n, int m) {
      int answer[] = new int[2];
      if(n > m){
          n ^= m;
          m ^= n;
          n ^= m;
      }
      int a = n;
      int b = m;
      int r = 1;
      while(r>0){
          r = a % b;
          a = b;
          b = r;
      }
      answer[0] = a;
      answer[1] = (n*m) / a;
      return answer;
  }
    
}
