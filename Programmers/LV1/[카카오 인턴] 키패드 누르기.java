class Solution {
      static StringBuilder sb = new StringBuilder();
  final static String pattern = "[~!@#$%\\\\^&*\\\\(\\\\)=+\\\\[\\\\{\\\\]\\\\}:?,<>/]";
    public String solution(String new_id) {
        String answer = "";
        sb = new StringBuilder(
        sb.append(new_id.toLowerCase())
        .toString().replaceAll(pattern, ""));
    
    // 3단계
    while(sb.toString().contains("..")) {
      sb = new StringBuilder(
          sb.toString().replace("..", "."));
    }
    
    // 4단계
    sb = (!sb.toString().isEmpty() && sb.toString().charAt(0)=='.')?sb.deleteCharAt(0):sb;
    sb = (!sb.toString().isEmpty() && sb.toString().charAt(sb.length()-1)=='.')?sb.deleteCharAt(sb.length()-1):sb;
    if(!sb.toString().isEmpty()) {
      sb = sb.toString().charAt(sb.length()-1) == '.'?sb.deleteCharAt(sb.length()-1):sb;
    }
    // 5단계
    sb = sb.toString().isEmpty()?sb.append("a"):sb;
    
    // 6단계
    sb = sb.length()>=16?new StringBuilder(sb.substring(0, 15).toString()):sb;
    sb = sb.toString().charAt(sb.length()-1)=='.'?sb.deleteCharAt(sb.length()-1):sb;

    // 7단계
    while(sb.length() < 3) {
      sb.append(sb.charAt(sb.length()-1));
    }
        return sb.toString();
    }
}class Solution {
  static int phone[][] = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
  static int cur_dir[][] = {{ 3, 0 }, { 3, 2 }};
    
    static int getDistance(int x, int y, int tx, int ty) {
    return Math.abs(x - tx) + Math.abs(y - ty);
  }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        loop: 
    for (int idx = 0; idx < numbers.length; idx++) {
      // Left
      if(numbers[idx] == 1 || numbers[idx] == 4 || numbers[idx] == 7) {
        cur_dir[0][0] = phone[numbers[idx]][0];
        cur_dir[0][1] = phone[numbers[idx]][1];
        answer += "L";
        continue loop;
      }
      
      // Right
      if(numbers[idx] == 3 || numbers[idx] == 6 || numbers[idx] == 9) {
        cur_dir[1][0] = phone[numbers[idx]][0];
        cur_dir[1][1] = phone[numbers[idx]][1];
        answer += "R";
        continue loop;
      }

      // Center
      int lCnt = getDistance(cur_dir[0][1], cur_dir[0][0], phone[numbers[idx]][1], phone[numbers[idx]][0]);
      int rCnt = getDistance(cur_dir[1][1], cur_dir[1][0], phone[numbers[idx]][1], phone[numbers[idx]][0]);
  
      if (lCnt == rCnt) {
        if (hand.equals("left")) {
          cur_dir[0][0] = phone[numbers[idx]][0];
          cur_dir[0][1] = phone[numbers[idx]][1];
          answer += "L";
        } else {
          cur_dir[1][0] = phone[numbers[idx]][0];
          cur_dir[1][1] = phone[numbers[idx]][1];
          answer += "R";
        }
      } else if (lCnt < rCnt) {
        cur_dir[0][0] = phone[numbers[idx]][0];
        cur_dir[0][1] = phone[numbers[idx]][1];
        answer += "L";
      } else if (rCnt < lCnt) {
        cur_dir[1][0] = phone[numbers[idx]][0];
        cur_dir[1][1] = phone[numbers[idx]][1];
        answer += "R";
      }
    }
        return answer;
    }
}