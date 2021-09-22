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
 * @commit 0922|BOJ|치즈|2638
 *
 */

class Node {
    int y, x;
    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int N, M, result;
    static int matrix[][];
    static boolean visit[][];
    static StringTokenizer st;
    static final int dy[] = { 0,-1, 0, 1}; // < ^ > v
    static final int dx[] = {-1, 0, 1, 0};
    
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        
        // TODO : 실내온도의 공기와 접촉한 것은 정확히 한시간만에 녹아 없어져 버림
        while(isEnd()) {
            bfs();
            deleteCheese();
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void deleteCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }

    static void bfs() {
        result++;
        boolean v[][] = new boolean[N][M];
        visit = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        v[0][0] = true;
        int ny = 0;
        int nx = 0;
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            for (int d = 0; d < 4; d++) {
                ny = n.y + dy[d];
                nx = n.x + dx[d];
                
                // 기저 조건
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(v[ny][nx]) continue;
                if(matrix[ny][nx] == 1) {
                    // < ^ > v 2면 이상 0 여부
                    int cnt = calcCheese(ny, nx, v);
                    if(cnt >= 2) {
                        visit[ny][nx] = true;
                    }
                } else {
                    q.offer(new Node(ny, nx));
                    v[ny][nx] = true;
                }
            } 
        }
    }

    static int calcCheese(int y, int x, boolean v[][]) {
        int n = 0;
        int ny = 0;
        int nx = 0;
        for (int d = 0; d < 4; d++) {
            ny = y + dy[d];
            nx = x + dx[d];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if(matrix[ny][nx] == 0 && v[ny][nx]) {
                n++;
            }
        }
        return n;
    }

    static boolean isEnd() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}