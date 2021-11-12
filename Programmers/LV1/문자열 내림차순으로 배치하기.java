import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    static ArrayList<Character> list = new ArrayList<Character>();
    public String solution(String s) {
    for (int i = 0; i < s.length(); i++) {
      list.add(s.charAt(i));
    }
    Collections.sort(list, new Comparator<Character>() {
      @Override
      public int compare(Character o1, Character o2) {
        return o2 - o1;
      }
    });
    return list.stream().map(Object::toString).collect(Collectors.joining(""));
  }
}