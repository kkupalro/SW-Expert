import java.util.*;

class Solution {
    static ArrayList<Integer> ar = new ArrayList<Integer>();
    static ArrayList<Integer> answer = new ArrayList<Integer>();
    static ArrayList<Integer> temp;
    public int[] solution(int[] array, int[][] commands) {
        // int[] answer = {};
        
        for(int n : array){
            ar.add(n);
        }
        
        for(int i = 0; i < commands.length; i++){
          temp = new ArrayList<Integer>(ar);
          List<Integer> ans = temp.subList(commands[i][0] - 1, commands[i][1]);
          ans.sort(null);
            
            answer.add(ans.get(commands[i][2] - 1));           
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}