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
 * @commit 0701|BOJ|아기 상어 2|17806
 *
 */

class node {
    int y; int x;
    
    node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int matrix[][];
    static boolean visit[][];
    static int result;
    static final int dy[] = { -1,-1,-1, 0, 1, 1, 1, 0 };
    static final int dx[] = { -1, 0, 1, 1, 1, 0,-1,-1 };

    static void bfs(int y, int x) {
        int cnt = 0;
        Queue<node> q = new LinkedList<node>();
        q.offer(new node(y, x));
        
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node n = q.poll();
                // 기저 조건
                if(matrix[n.y][n.x] == 1) {
                    result = Math.max(result, cnt);
                    return;
                }
                
                for (int dir = 0; dir < 8; dir++) {
                    int ny = n.y + dy[dir];
                    int nx = n.x + dx[dir];
                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if(visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    q.offer(new node(ny, nx));
                }
            }
            cnt++;
        }
        
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    visit = new boolean[N][M];
                    visit[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}