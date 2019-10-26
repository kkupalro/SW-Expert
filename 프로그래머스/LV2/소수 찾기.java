import java.util.*;

class Solution {
    static String str = "";
    static boolean sosu[] = new boolean[10000000];
    static boolean visit[];
    static LinkedList<Integer> list = new LinkedList<>();
    static void comb(String s){
        if(s.length() > str.length())
        {
            return;
        }
        if(!list.contains(Integer.parseInt(s)))
        {
            list.offer(Integer.parseInt(s));
        }
        for(int i = 0; i < str.length(); i++)
        {
            if(visit[i]) continue;
            visit[i] = true;
            comb(s + str.charAt(i));
            visit[i] = false;
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        str = numbers;
        visit = new boolean[str.length()];
        for(int i = 2; i < sosu.length; i++)
        {
            for(int j = i; j < sosu.length; j+=i)
            {
                if(j == i || sosu[j]) continue;
                sosu[j] = true;
            }
        }
        for(int i = 0; i < str.length(); i++)
        {
            visit[i] = true;
            comb(numbers.charAt(i) + "");
            visit[i] = false;
        }
        for(int i = 0; i < list.size(); i++)
        {
            if(!sosu[list.get(i)] && list.get(i) > 1)
            {
                answer++;
            }
        }
        return answer;
    }
}
