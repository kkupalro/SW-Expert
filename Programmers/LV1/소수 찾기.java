class Solution {
  final static int SIZE = 1000001;
  static boolean arr[] = new boolean[1000001];
  
    public int solution(int n) {
        int answer = 0;
        
        init();
        for (int i = 2; i <= n; i++) {
      if(!arr[i]) {
        answer++;
      }
    }
        
        return answer;
    }

  static public void init() {
    for (int i = 2; i < SIZE; i++) {
      if(arr[i]) continue;
      arr[i] = false;
      if(!arr[i]) {
        for (int j = i * 2; j < SIZE; j+= i) {
          arr[j] = true;
        }
      }
    }
  }
}