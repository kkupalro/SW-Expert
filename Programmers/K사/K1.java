import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    static HashSet<String> ts;
    static HashMap<String, HashSet<String>> tm = new HashMap<>();
    static HashMap<String, Integer> detectMap = new HashMap<>();
    static StringTokenizer st;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // TODO 신고당한횟수
        for (String s : report) {
            st = new StringTokenizer(s, " ");
            String key = st.nextToken();
            String value = st.nextToken();          
            
            if(tm.containsKey(key)) {
                ts = tm.get(key);
                ts.add(value);
                tm.put(key, ts);
            } else {
                ts = new HashSet<>();
                ts.add(value);
                tm.put(key, ts);
            }
        }
        
        for (String key : tm.keySet()) {
            ts = tm.get(key);
            for (String s : ts) {
                detectMap.put(s, detectMap.containsKey(s)?detectMap.get(s)+1:1);
            }
        }        
        
        loop:
        for (int i = 0; i < id_list.length; i++) {
            ts = tm.get(id_list[i]);
        
            if(ts == null) {
                continue loop;
            }
            
            for (String key : ts) {
                if(detectMap.get(key) >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}