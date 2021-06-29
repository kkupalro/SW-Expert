import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|11866
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static Deque<Integer> dq = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bw.write("<");
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int cnt = 1;
        while (!dq.isEmpty()) {
            if (cnt != K) {
                dq.offerLast(dq.pollFirst());
                cnt++;
            } else {
                if (dq.size() == 1) {
                    bw.write(dq.poll() + ">\n");
                } else {
                    bw.write(dq.poll() + ", ");
                }
                cnt = 1;
            }
        }
        bw.flush();
        bw.close();
    }
}