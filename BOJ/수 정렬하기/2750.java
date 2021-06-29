import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|2750
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1>o2)?1:-1;
        }
    });

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}