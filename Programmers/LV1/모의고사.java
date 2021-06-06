import java.util.*;

class Solution {
    static int[][] arr = new int[4][];
  static int max = Integer.MIN_VALUE;
    
    static void solve(int n, int[] answers) {
    int cnt = 0;
    for(int i = 0; i < answers.length; i++) {
      if(arr[n][i % arr[n].length] == answers[i]) {
        cnt++;
      }
    }
    max = Math.max(max, cnt);
    arr[3][n] = cnt;
  }
    
    static void init() {
    arr[0] = new int[]{1,2,3,4,5};
    arr[1] = new int[]{2,1,2,3,2,4,2,5};
    arr[2] = new int[]{3,3,1,1,2,2,4,4,5,5};
    arr[3] = new int[3];
  }
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        init();
        
        for(int i = 0; i < arr.length; i++) {
          if(i == arr.length-1) {
            for(int j = 0; j < arr[i].length; j++) {
              if(arr[3][j] == max) {
                answer.add(j+1);
              } 
            }
          } else {
            solve(i, answers);
          }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}