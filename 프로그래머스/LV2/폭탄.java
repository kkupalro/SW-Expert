import java.util.*;

class Solution {
    public int solution(int[] bombs) {
        int answer = 0;
        Arrays.sort(bombs);
        for(int i = 0; i < bombs.length; i++)
        {
            if(bombs[i] >= i+1) answer++;
            else break;
        }
        
        return answer;
    }
}
