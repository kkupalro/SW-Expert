import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yoo
 * @commit 0701|BOJ|최대 힙|11279
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1>o2?-1:1;
                    }
                });
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.offer(n);
            }
        }

        bw.flush();
        bw.close();
    }
}
