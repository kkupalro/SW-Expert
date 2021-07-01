import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author yoo
 * @commit 0701|BOJ|1로 만들기|1463
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int X;
    static int dp[];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        X = Integer.parseInt(br.readLine());

        dp = new int[X + 1];

        for (int i = 1; i <= X; i++) {
            if(i == 1) {
                dp[i] = 0;
            } else if(i == 2) {
                dp[i] = 1;
            } else if(i == 3) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 4; i <= X; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }

        bw.write(dp[X] + "\n");
        bw.flush();
        bw.close();
    }
}