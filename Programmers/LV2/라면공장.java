import java.util.*;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); 
        // 내림차순 정렬
        while(stock < k)
        {
            while(idx < dates.length && dates[idx] <= stock)
            {
                pq.offer(supplies[idx]);
                idx++;
            }
            stock += pq.poll();
            answer++;
        }
        return answer;
    }
}
