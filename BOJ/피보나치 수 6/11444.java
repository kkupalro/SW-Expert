import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

/**
 * @author yoo
 * @commit 0630|BOJ|A-SA 문제집-2|11444|acmicpc.net/blog/view/28
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static long N;
    static long MOD = 1000000007;
    static LinkedHashMap<Long, Long> hm = new LinkedHashMap<Long, Long>();

    private static long fibo(long n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (hm.containsKey(n)) {
            return hm.get(n);
        } else {
            if (n % 2 == 1) {
                long m = (n + 1) / 2;
                long t1 = fibo(m);
                long t2 = fibo(m - 1);
                hm.put(n, (t1 * t1 + t2 * t2) % MOD);
                return hm.get(n);
            } else {
                long m = n / 2;
                long t1 = fibo(m - 1);
                long t2 = fibo(m);
                hm.put(n, ((2L * t1 + t2) * t2) % MOD);
                return hm.get(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Long.parseLong(br.readLine());
        bw.write(fibo(N) + "\n");
        bw.flush();
        bw.close();
    }

}