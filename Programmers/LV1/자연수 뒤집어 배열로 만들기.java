class Solution {
  static StringBuilder sb = new StringBuilder();
    public int[] solution(long n) {
        sb.append(n).reverse();
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
      answer[i] = Character.getNumericValue(sb.charAt(i));
    }
        return answer;
    }
}