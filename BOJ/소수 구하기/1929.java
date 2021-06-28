import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|1929
 *
 */
public class Main {
    static final int MAX = 1000000;
    static BufferedReader br;
    static BufferedWriter bw;
    static int M, N;
    static StringTokenizer st;
    static boolean arr[] = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            for (int j = i * i; j <= MAX; j += i) {
                arr[j] = false;
            }
        }

        for (int i = N; i <= M; i++) {
            if (arr[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}