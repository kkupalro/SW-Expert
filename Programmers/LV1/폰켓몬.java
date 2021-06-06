import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet<Integer>(Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList()));
        
        answer = answer>set.size()?set.size():answer;
        
        return answer;
    }
}