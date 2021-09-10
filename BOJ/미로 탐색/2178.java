package BOJ;

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
 * @commit 0910|BOJ|미로 탐색|2178
 *
 */

class node {
    int y, x, cnt;

    node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int matrix[][];
    static boolean visit[][];
    static StringTokenizer st;
    final static int dy[] = { 0, -1, 0, 1 }; // < ^ > v
    final static int dx[] = { -1, 0, 1, 0 };

    static void bfs(int y, int x) {
        
        Queue<node> q = new LinkedList<node>();
        q.offer(new node(y, x, 1));
        
        while (!q.isEmpty()) {
            node n = q.poll();
            int ny = 0;
            int nx = 0;
            
            // 기저 조건
            if (n.y == N - 1 && n.x == M - 1) {
                result = Math.min(result, n.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                ny = n.y + dy[i];
                nx = n.x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;
                if (matrix[ny][nx] == 0 || visit[ny][nx])
                    continue;
                visit[ny][nx] = true;
                q.offer(new node(ny, nx, n.cnt + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sb.charAt(j) - '0';
            }
        }
        visit[0][0] = true;
        bfs(0, 0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
