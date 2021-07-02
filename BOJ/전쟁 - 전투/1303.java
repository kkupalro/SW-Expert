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
 * @commit 0702|BOJ|전쟁 - 전투|1303
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int A, B;
    static int matrix[][];
    static boolean visitA[][];
    static boolean visitB[][];
    static final int dy[] = { 0,-1, 0, 1}; // < ^ > v
    static final int dx[] = {-1, 0, 1, 0};

    static void bfs(int y, int x, int t) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});

        while(!q.isEmpty()) {
            int n[] = q.poll();
            int ny = 0;
            int nx = 0;
            for(int i = 0; i < 4; i++) {
                ny = n[0] + dy[i];
                nx = n[1] + dx[i];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(t == 0) {
                    if(visitA[ny][nx]) continue;
                    if(matrix[ny][nx] == 1 - t) continue;
                    visitA[ny][nx] = true;
                    q.offer(new int[] {ny, nx});
                    
                } else if(t == 1) {
                    if(visitB[ny][nx]) continue;
                    if(matrix[ny][nx] == 1 - t) continue;
                    visitB[ny][nx] = true;
                    q.offer(new int[] {ny, nx});
                }
            }
            cnt++;
        }
        
        if(t == 0) {
            A += cnt * cnt;
        } else {
            B += cnt * cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = s.charAt(j) == 'W' ? 0 : 1;
            }
        }

        visitA = new boolean[N][M];
        visitB = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int n = matrix[i][j];
                if(n == 0) {
                    if(visitA[i][j]) continue;
                    visitA[i][j] = true;
                    bfs(i, j, n);
                } else if(n == 1) {
                    if(visitB[i][j]) continue;
                    visitB[i][j] = true;
                    bfs(i, j, n);
                }
            }
        }
        bw.write(A + " " + B + "\n");
        bw.flush();
        bw.close();
    }
}