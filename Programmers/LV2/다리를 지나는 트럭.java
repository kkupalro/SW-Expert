import java.util.*;

class node {
    int w; int d;
    node(int w, int d){
        this.w = w;
        this.d = d;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<node> q = new LinkedList<node>(); // 아직 출발하지 않은 트럭
        LinkedList<node> bridge_list = new LinkedList<node>(); // 다리 안에 있는 트럭 리스트
        for(int i = 0; i < truck_weights.length; i++)
        {
            q.offer(new node(truck_weights[i], bridge_length)); // 트럭 무게, 남은 거리
        }
        while(!(bridge_list.isEmpty() && q.isEmpty()))
        {
            answer++; // 매 1초씩 증가
            // 1. 다리 통과 검사 -> 트럭 남은 거리(d)가 0이면 다리 통과
            if(!bridge_list.isEmpty() && bridge_list.get(0).d == 0)
            {
                // 다리 무게(weight) 증가 -> 다리 리스트에서 제거함
                weight += bridge_list.get(0).w;
                bridge_list.remove(0);
            }
            // 2. (다리 무게(weight) >= 트럭 무게(w)) -> 리스트에 삽입 -> 다리 무게(weight) 감소
            if(!q.isEmpty() && weight >= q.peek().w)
            {
                node n = q.poll();
                bridge_list.offer(new node(n.w, n.d));
                weight -= n.w;
            }
            // 3. 다리 안에 있는 모든 트럭의 남은 거리(d) 1만큼 감소
            for(int i = 0; i < bridge_list.size(); i++)
            {
                bridge_list.get(i).d--;
            }
        }
        return answer;
    }
}
