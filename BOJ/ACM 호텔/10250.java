import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|10250
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, H, W, N;
    static int matrix[][] = new int[100][100];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int result = 0;
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken()); // 6
            W = Integer.parseInt(st.nextToken()); // 12
            N = Integer.parseInt(st.nextToken()); // 10

            int y = 0;
            int x = 0;

            if (N % H == 0) {
                y = H;
                x = N / H;
            } else {
                y = N % H; // 4 , 12
                x = (N / H) + 1; // 1, 2
            }

            result = (y * 100) + x;

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}