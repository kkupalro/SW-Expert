import java.util.*;

class Solution {
    static HashMap<String, Integer> hm;
    static String key[];
    static int answer;
    static void comb(int idx, int cnt, int sum){
        answer += 1 * sum;
        // 기저 조건
        if(cnt == key.length-1)
        {
            return;
        }
        for(int i = idx+1; i < key.length; i++)
        {
            comb(i, cnt+1, sum * hm.get(key[i]));
        }
    }
    public int solution(String[][] clothes) {
        hm = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++)
        {
            String s = clothes[i][clothes[i].length-1]; 
            if(hm.containsKey(clothes[i][clothes[i].length-1]))
            {
                 hm.put(s, hm.get(s) + clothes[i].length - 1);
            }
            else hm.put(s, clothes[i].length - 1);
        }
        key = hm.keySet().toArray(new String[0]); // 키 값
        for(int i = 0; i < key.length; i++)
        {
            comb(i, 0, hm.get(key[i]));
        }
        return answer;
    }
}
