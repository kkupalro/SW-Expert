import java.util.*;

class node {
    int num; int idx;
    node(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<node> q = new LinkedList<node>();
        for(int i = 0; i < priorities.length; i++)
        {
            q.offer(new node(priorities[i], i));
        }
        loop:
        while(!q.isEmpty())
        {
            node n = q.poll();
            int num = n.num; // 번호
            int idx = n.idx; // 위치
            for(node nn : q)
            {
                if(num < nn.num)
                {
                    q.offer(n);
                    continue loop;
                }
            }
            if(idx == location)
            {
                break;
            }
            else answer++;
        }
        return answer;
    }
}
