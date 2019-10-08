class Solution {
  public int[] solution(int[] arr, int divisor) {
      int cnt = 0, idx = 0;
      int[] answer = {};
      for(int i = 0; i < arr.length; i++)
      {
          if(arr[i] % divisor == 0)
          {
              cnt++;
          }
      }
      if(cnt > 0)
      {
          answer = new int[cnt];
          for(int i = 0; i < arr.length; i++)
          {
              if(arr[i] % divisor == 0)
              {
                  answer[idx++] = arr[i];
              }
          }
          // 버블 정렬
          for(int i = 0; i < answer.length; i++)
          {
              for(int j = i+1; j < answer.length; j++)
              {
                  if(answer[i] > answer[j])
                  {
                      answer[i] ^= answer[j];
                      answer[j] ^= answer[i];
                      answer[i] ^= answer[j];
                  }
              }
          }
      }
      else
      {
          answer = new int[1];
          answer[0] = -1;
      }
      return answer;
  }
}
