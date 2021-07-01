import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0701|BOJ|행렬|1080
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int result;
    static int A[][];
    static int B[][];

    static void convert(int y, int x, int n) {

        for (int i = y; i <= y + 2; i++) {
            for (int j = x; j <= x + 2; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j) == '0' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j) == '0' ? 0 : 1;
            }
        }

        // 변환
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    convert(i, j, A[i][j]);
                    result++;
                }
            }
        }

        // 바꿀 수 없는 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    result = -1;
                    break;
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
