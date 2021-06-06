import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String pName : participant) {
          if(hm.containsKey(pName)) {
            hm.put(pName, hm.get(pName) + 1);
          } else {
            hm.put(pName, 1);
          }
        }
        
        for(String cName : completion) {
          if(hm.containsKey(cName) && hm.get(cName) == 1) {
            hm.remove(cName);
          } else {
            hm.put(cName, hm.get(cName) - 1);
          }
        }
        answer = hm.keySet().iterator().next();
        
        return answer;
    }
}