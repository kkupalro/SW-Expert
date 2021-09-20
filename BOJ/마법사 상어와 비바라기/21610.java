package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0920|BOJ|마법사 상어와 비바라기|21610
 *
 */

public class Main {
    static int N, M, result;
    static int A[][];
    static boolean visit[][];
    static StringTokenizer st;
    static final int dy[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // X,←,↖,↑,↗,→,↘,↓,↙
    static final int dx[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 }; // 0, 1,2, 3, 4, 5,6,7, 8
    
    static void moveCloud(int d) {
        boolean copy[][] = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    ny = (ny < 0) ? N - 1 : (ny > N - 1) ? 0 : ny;
                    nx = (nx < 0) ? N - 1 : (nx > N - 1) ? 0 : nx;
                    copy[ny][nx] = true;
                }
            }
        }
        visit = copy.clone();
    }

    static void rainCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) {
                    A[i][j] += 1;
                }
            }
        }
    }
    
    static void waterCopy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 2, 4, 6, 8
                if(visit[i][j]) {
                    int cnt = 0;
                    for (int d = 2; d <= 8; d+=2) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        if(A[ny][nx] == 0) continue;
                        cnt++;
                    }
                    A[i][j] += cnt;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * FIXME : 구현 (N, 1),(N, 2),(N-1, 1),(N-1, 2) 비구름 
         * 1. 모든 구름이 di 방향으로 si칸 이동한다. 
         * 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다. 
         * 3. 구름이 모두 사라진다. 
         * 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다. 
         * 5. 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다. 
         * 6. 예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다. 
         * 7. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
         */

        visit[N - 1][0] = visit[N - 1][1] = visit[N - 2][0] = visit[N - 2][1] = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // TODO : 1.모든 구름이 di 방향으로 si칸 이동한다. 
            for (int j = 0; j < s; j++) {
                moveCloud(d);
            }
            // TODO : 2.각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            rainCloud();

            // TODO : 4. 구름칸에서, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
            waterCopy();
            
            // TODO : 7. 구름칸을 제외한 물이 2이상인 곳에 구름 생성
            makeCloud();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += A[i][j];
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void makeCloud() {
        boolean temp[][] = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && A[i][j] >= 2) {
                    A[i][j] -= 2;
                    temp[i][j] = true;
                }
            }
        }
        
        visit = temp.clone();
    }
}