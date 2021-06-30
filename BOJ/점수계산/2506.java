import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|점수계산|2506
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int dp[] = new int[101];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            if (i == 0)
                continue;
            if (dp[i] == 0)
                continue;
            dp[i] += dp[i - 1];
            sum += dp[i];
        }

        bw.write(sum + dp[0] + "\n");
        bw.flush();
        bw.close();
    }
}