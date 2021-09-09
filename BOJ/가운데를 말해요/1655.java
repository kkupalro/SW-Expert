package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoo
 * @commit 0909|BOJ|가운데를 말해요|1655
 *
 */

public class Main {
    static int N;
    static PriorityQueue<Integer> head = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
    static PriorityQueue<Integer> tail = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            head.offer(n);
            
            if((head.size()+tail.size()) % 2 == 1) {
                tail.offer(head.poll());
            } else {
                if(tail.peek() > n) {
                    head.offer(tail.poll());
                    tail.offer(head.poll());
                }
            }
            bw.write(tail.peek() + "\n");
        }
        bw.flush();
        bw.close();
    }
}