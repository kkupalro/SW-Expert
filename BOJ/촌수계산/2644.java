import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0701|BOJ|촌수계산|2644
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, X, Y;
    static int matrix[][];
    static boolean visit[];
    static int result;

    public static void dfs(int start, int end, int cnt) {

        for (int i = 1; i <= N; i++) {
            if (visit[i])
                continue;
            if (matrix[start][i] == 1) {
                if (i == end) {
                    result = cnt + 1;
                    return;
                }

                visit[i] = true;
                dfs(i, end, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            matrix[y][x] = 1;
            matrix[x][y] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (matrix[Y][i] == 1) {
                visit[i] = true;
                dfs(i, X, 1);
            }
        }

        result = result == 0 ? -1 : result;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}