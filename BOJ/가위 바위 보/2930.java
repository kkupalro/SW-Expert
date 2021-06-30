import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|가위 바위 보|2930
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int R, N;
    static int target[][];

    static int calc() {
        int score = 0;
        for (int i = 0; i < R; i++) {
            int s = 0;
            int p = 0;
            int r = 0;
            for (int j = 0; j < N; j++) {
                s += target[j][i] == 1?2:target[j][i] == 0?1:0;
                p += target[j][i] == 2?2:target[j][i] == 1?1:0;
                r += target[j][i] == 0?2:target[j][i] == 2?1:0;
            }
            score += Math.max(s, Math.max(p, r));
        }
        return score;
    }

    static int calc(int arr[]) {
        int score = 0;
        for (int i = 0; i < R; i++) {
            int n = arr[i];
            for (int j = 0; j < N; j++) {
                if (n == 0) {
                    // 가위
                    if (target[j][i] == 1) {
                        score += 2;
                    } else if (target[j][i] == n) {
                        score += 1;
                    }

                } else if (n == 1) {
                    // 보
                    if (target[j][i] == 2) {
                        score += 2;

                    } else if (target[j][i] == n) {
                        score += 1;
                    }

                } else if (n == 2) {
                    // 바위
                    if (target[j][i] == 0) {
                        score += 2;

                    } else if (target[j][i] == n) {
                        score += 1;
                    }
                }
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        R = Integer.parseInt(br.readLine());
        int arr[] = new int[R];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(st.nextToken());
        for (int i = 0; i < R; i++) {
            char c = sb.charAt(i);
            arr[i] = c == 'S' ? 0 : c == 'P' ? 1 : 2;
        }

        N = Integer.parseInt(br.readLine());
        target = new int[N][R];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder(st.nextToken());
            for (int j = 0; j < R; j++) {
                char c = sb.charAt(j);
                target[i][j] = c == 'S' ? 0 : c == 'P' ? 1 : 2;
            }
        }
        bw.write(calc(arr) + "\n" + calc() + "\n");
        bw.flush();
        bw.close();
    }
}