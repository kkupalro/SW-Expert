import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
         @Override
         public int compare(Integer o1, Integer o2){
             return o1 - o2;
         }                               
        });
        for(int i = 0; i < scoville.length; i++)
        {
            pq.offer(scoville[i]);
        }
        boolean flag = false;
        while(pq.size() > 1)
        {
            answer++;
            pq.offer(pq.poll() + (pq.poll() * 2));
            if(pq.peek() >= K)
            {
                flag = true;
                break;
            }
        }
        answer = (flag)?answer:-1;
        return answer;
    }
}
