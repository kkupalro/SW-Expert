import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|1904
 *
 */
public class Main {
    static final int MAX = 1000000;
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int dp[] = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i-2] + dp[i -1]) % 15746;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
}