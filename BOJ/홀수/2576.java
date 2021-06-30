import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoo
 * @commit 0630|BOJ|홀수 |2576
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? 1 : -1;
        }
    });

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n % 2 == 1) {
                sum += n;
                pq.offer(n);
            }
        }
        
        if(pq.isEmpty()) {
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n" + pq.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}