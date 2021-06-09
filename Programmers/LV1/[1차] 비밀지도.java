import java.util.Arrays;

class Solution {
    static Integer matrix[][];
    public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    matrix = new Integer[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(matrix[i], 0);
    }

    for (int i = 0; i < n; i++) {
      StringBuilder sb1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
      StringBuilder sb2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
      while (sb1.length() < n) {
        sb1.insert(0, "0");
      }
      
      while (sb2.length() < n) {
        sb2.insert(0, "0");
      }
      String result = "";
      for (int j = 0; j < n; j++) {
        if (sb1.charAt(j) == '1' || sb2.charAt(j) == '1') {
          result += "#";
        } else {
          result += " ";
        }
      }
      answer[i] = result;

    }
        
        return answer;
    }
}