import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0702|BOJ|음식물 피하기|1743
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, K;
    static int matrix[][];
    static boolean visit[][];
    static final int dy[] = { 0,-1,0,1}; // < ^ > v
    static final int dx[] = {-1, 0,1,0};
    static int result;

    static int bfs(int y, int x) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{y, x});
        
        while(!q.isEmpty()) {
            int n[] = q.poll();
            int ny = 0;
            int nx = 0;
            for (int i = 0; i < 4; i++) {
                ny = n[0] + dy[i];
                nx = n[1] + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(visit[ny][nx]) continue;
                if(matrix[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    q.offer(new int[] {ny, nx});
                }
            }
            cnt++;
        }
        
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            matrix[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 1) {
                    if (visit[i][j]) continue;
                    visit[i][j] = true;
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}