import java.util.*;

class node {
    int p; int s;
    node(int p, int s){
        this.p = p;
        this.s = s;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<node> q = new LinkedList<node>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < progresses.length; i++)
        {
            q.offer(new node(progresses[i], speeds[i]));
        }
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                node n = q.poll();
                q.offer(new node(n.p + n.s, n.s));
            }
            int cnt = 0;
            while(!q.isEmpty() && q.peek().p >= 100)
            {
                q.poll();
                cnt++;    
            }
            if(cnt > 0)
            {
                list.offer(cnt);    
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
