import java.util.*;

class Solution {
  public long solution(long n) {
      long answer = 0;
      String str = Long.toString(n);
      Integer arr[] = new Integer[str.length()];
      for(int i = 0; i < str.length(); i++)
      {
          arr[i] = str.charAt(i) - '0';
      }
      Arrays.sort(arr, Collections.reverseOrder()); // 내림 차순, int(X) -> Integer(O)
      str = "";
      for(int i = 0; i < arr.length; i++)
      {
          str += arr[i];
      }
      answer = Long.valueOf(str);
      return answer;
  }
}
