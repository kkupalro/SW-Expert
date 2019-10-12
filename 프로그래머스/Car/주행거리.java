import java.util.*;

class Car implements Comparable<Car> {
    String key; int num;
    Car(String key, int num)
    {
        this.key = key;
        this.num = num;
    }
    @Override
	public int compareTo(Car target) {
        if(this.num == target.num)
        {
            // 주행거리 같을 경우 키값순으로
            return this.key.compareTo(target.key);
        }
	    return this.num - target.num;
	}
}
class Solution {
    static PriorityQueue<Car> pq = new PriorityQueue<Car>();
    public String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
        for(int i = 0; i < n; i++)
        {
            pq.offer(new Car(plates[i], odo[i]));
        }
        for(int i = 0; i < k; i++)
        {
            Car c = pq.poll();
            pq.offer(new Car(c.key, c.num + drives[i]));
        }
        return pq.peek().key;
    }
}
