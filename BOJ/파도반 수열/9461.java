import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|9461
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N;
    static long arr[] = new long[101];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        arr[1] = arr[2] = arr[3] = 1;
        for (int i = 4; i <= 100; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            bw.write(arr[N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}