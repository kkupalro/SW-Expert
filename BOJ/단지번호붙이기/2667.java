import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoo
 * @commit 0702|BOJ|단지번호붙이기|2667
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int matrix[][];
    static boolean visit[][];
    static final int dy[] = { 0,-1,0,1}; // < ^ > v
    static final int dx[] = {-1, 0,1,0};
    static ArrayList<Integer> al = new ArrayList<Integer>();

    static void bfs(int y, int x) {
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
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(visit[ny][nx]) continue;
                if(matrix[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    q.offer(new int[] {ny, nx});
                }
            }
            cnt++;
        }
        
        al.add(cnt);
        
        return;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == 1) {
                    if(visit[i][j]) continue;
                    visit[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(al);
        bw.write(al.size() + "\n");
        for(int n : al) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}