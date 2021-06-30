import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|최소, 최대|10818
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.offer(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        bw.write(list.get(0) + " " + list.get(N - 1) + "\n");
        bw.flush();
        bw.close();
    }
}