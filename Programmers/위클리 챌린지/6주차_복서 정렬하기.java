import java.util.*;

class Boxer implements Comparable<Boxer>{
    int num; 
    double rate;
    int win;
    int weight;
    
    Boxer(int num, double rate, int win, int weight){
        this.num = num;
        this.rate = rate;
        this.win = win;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Boxer o){
        if(o.rate == this.rate){
            if(o.win == this.win){
                if(o.weight == this.weight){
                    return this.num - o.num;
                } return o.weight - this.weight;
            } return o.win - this.win;
        } return Double.compare(o.rate, this.rate);
    }
}

class Solution {
    static ArrayList<Boxer> list = new ArrayList<>();
    
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        for(int i = 0; i < weights.length; i++){
            int num = i + 1;
            int total = 0;
            int rate = 0;
            int win = 0;
            int weight = weights[i];
            for(int j = 0; j < head2head[i].length(); j++){
                char c = head2head[i].charAt(j);
                if(c == 'W') {
                    total++;
                    rate++;
                    win += weight < weights[j]?1:0;
                } else if(c == 'L') {
                    total++;
                }
            }
            if(rate == 0 || total == 0){
                list.add(new Boxer(num, (double) 0, win, weight));
            } else {
                list.add(new Boxer(num, (double) rate / total * 100, win, weight));
            }
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).num;
        }
        return answer;
    }
}