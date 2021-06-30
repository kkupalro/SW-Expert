import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|가장 긴 감소하는 부분 수열|11722
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static StringTokenizer st;
    static int arr[];
    static int dp[];
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}