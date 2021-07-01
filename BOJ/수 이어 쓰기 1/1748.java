import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author yoo
 * @commit 0701|BOJ|수 이어 쓰기 1|1748
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int n = i;
            while(n > 0) {
                n /= 10;
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}