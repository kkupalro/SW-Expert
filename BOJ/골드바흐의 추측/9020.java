import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|9020
 *
 */
public class Main {
    static final int MAX = 10000;
    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N;
    static boolean arr[] = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            for (int j = i * i; j <= MAX; j += i) {
                arr[j] = false;
            }
        }

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int left = N / 2;
            int right = N / 2;

            while (left > 0) {
                if (arr[left] && arr[right])
                    break;
                left--;
                right++;
            }
            bw.write(left + " " + right + "\n");
        }
        bw.flush();
        bw.close();
    }
}