package pro;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

class node {
    int time, type;
    node(int time, int type){
        this.time = time;
        this.type = type;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean eratosthenes[] = new boolean[1000001];
    static TreeMap<String, ArrayList<node>> tm = new TreeMap<>();
    static StringTokenizer st;
    static ArrayList<node> list;

    static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // TODO 입/출차 기록 변환
        for (String s : records) {
            st = new StringTokenizer(s, " ");
            String[] str = st.nextToken().split(":");
            
            int time = (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
            String key = st.nextToken();
            int type = st.nextToken().equals("IN")?0:1;
            
            node n = new node(time, type);
            
            if(tm.containsKey(key)) {
                list = tm.get(key);
            } else {
                list = new ArrayList<node>();
            }
            list.add(n);
            tm.put(key, list);
        }
        
        answer = new int[tm.keySet().size()];
        int idx = 0;
        for (String key : tm.keySet()) {
            /*
             *  TODO 요금계산
             *  fees[0] = 기본시간  180
             *  fees[1] = 기본요금 5000
             *  fees[2] = 단위시간 10
             *  fees[3] = 단위요금 600
             */
            int res_time = 0;
            boolean flag = false;
            for (node n : tm.get(key)) {
                if(n.type == 1) {
                    // 출차
                    flag = true;
                    res_time += n.time;
                } else {
                    flag = false;
                    res_time -= n.time;
                }
            }
            
            if(!flag) {
                res_time += 1439;
            }
            
            answer[idx] += fees[1];
            
            if(res_time > fees[0]) {
                
                res_time -= fees[0];
                double rdx = res_time;
                rdx /= fees[2];
                rdx = Math.ceil(rdx);
                answer[idx] += rdx * fees[3];
            }
            idx += 1;
        }

        return answer;
    }
    
    public static void main(String[] args) throws Exception {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(solution(fees, records));
    }
}