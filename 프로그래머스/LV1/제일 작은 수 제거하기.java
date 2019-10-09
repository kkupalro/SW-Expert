class Solution {
  public int[] solution(int[] arr) {
      int[] answer = {};
      int min = Integer.MAX_VALUE;
      for(int i : arr)
      {
          min = Math.min(min, i);
      }
      int cnt = 0;
      for(int i = 0; i < arr.length; i++)
      {
          if(arr[i] == min)
          {
              arr[i] = -1;
              cnt++;
          }
      }
      int len = arr.length - cnt;
      if(len == 0)
      {
          answer = new int[1];
          answer[0] = -1;
      }
      else
      {
          answer = new int[len];
          int idx = 0;
          for(int i : arr)
          {
              if(i > 0)
              {
                  answer[idx++] = i;
              }
          }    
      }
      return answer;
  }
}
