import java.util.*;



class Solution {
    public String solution(String[] participant, String[] completion) {
	// 항상 참가자수는 완주자수보다 1 많음
	// hm 에 마지막 참가자 수 삽입 후, 0 ~ (참가자수-1) hm에 더함
        // hm<key : 이름, value : 누적 값> -> 누적값이 짝수가 아닐 경우 완주하지 못함
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(participant[participant.length-1], 1);
        for(int i = 0; i < participant.length-1; i++)
        {
            if(hm.containsKey(participant[i]))
            {
                hm.put(participant[i], hm.get(participant[i]) + 1);
            }
            else hm.put(participant[i], 1);
            
            if(hm.containsKey(completion[i]))
            {
                hm.put(completion[i], hm.get(completion[i]) + 1);
            }
            else hm.put(completion[i], 1);
        }
        
        Set<String> set = hm.keySet();
        for(String s : set)
        {
            if(hm.get(s) % 2 == 1)
            {
                answer = s;
                break;
            }
        }
        return answer;
    }
}
