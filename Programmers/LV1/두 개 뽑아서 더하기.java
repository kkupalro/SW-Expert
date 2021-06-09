import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<Integer>();
    
    public int[] solution(int[] numbers) {
        int[] answer = {};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}