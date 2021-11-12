import java.util.Comparator;
import java.util.LinkedList;

class Solution {
  static StringBuilder sb = new StringBuilder();
  static LinkedList<Integer> list = new LinkedList<Integer>();
  
  static public long solution(long n) {
    sb.append(n);
    for (int i = 0; i < sb.length(); i++) {
      list.add(Integer.parseInt(sb.charAt(i) + ""));
    }

    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    
    sb = new StringBuilder();
    
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
    }
    return Long.parseLong(sb.toString());
  }
}