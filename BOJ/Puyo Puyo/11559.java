package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yoo
 * @commit 0925|BOJ|Puyo Puyo|11559
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
    static final char word[] = { '.', 'R', 'G', 'B', 'P', 'Y' };
    static final int dy[] = { 0, -1, 0, 1 }; // < ^ > v
    static final int dx[] = { -1, 0, 1, 0 };
    static int result;
    static int matrix[][] = new int[12][6];
    static boolean visit[][] = new boolean[12][6];
    static StringBuilder sb = new StringBuilder();

    static void moveDown(int y, int x) {
        for (int i = y + 1; i < 12; i++) {
            if (matrix[i][x] == 0) {
                matrix[i - 1][x] ^= matrix[i][x];
                matrix[i][x] ^= matrix[i - 1][x];
                matrix[i - 1][x] ^= matrix[i][x];
            }
        }

    }

    static int bfs(int y, int x, int w) {
        boolean isBomb[][] = new boolean[12][6]; // 터뜨릴 대상여부
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(y, x));
        isBomb[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int ny = 0;
            int nx = 0;
            Node n = q.poll();

            for (int d = 0; d < 4; d++) {
                ny = n.y + dy[d];
                nx = n.x + dx[d];
                if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6)
                    continue;
                if (visit[ny][nx])
                    continue;
                if (matrix[ny][nx] != w)
                    continue;
                visit[ny][nx] = true;
                isBomb[ny][nx] = true;
                q.offer(new Node(ny, nx));
                cnt++;
            }
        }

        if (cnt >= 4) {
            explode(isBomb);
            return 1;
        } else {
            return 0;
        }
    }

    /** TODO : 뿌요 터뜨림 */
    static void explode(boolean[][] isBomb) {
        for (int i = 0; i < isBomb.length; i++) {
            for (int j = 0; j < isBomb[i].length; j++) {
                if (isBomb[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /** TODO : 출력 */
    static void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * TODO : 필드 변환
         */
        for (int i = 0; i < matrix.length; i++) {
            sb = new StringBuilder(br.readLine());
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < word.length; k++) {
                    if (word[k] == sb.charAt(j)) {
                        matrix[i][j] = k;
                        break;
                    }
                }
            }
        }

        while (true) {
            /**
             * FIXME : 여러 그룹 터뜨리고 밑으로 떨어뜨리기 반드시 아래서 부터 진행
             */
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > 0) {
                        if (i + 1 >= 12)
                            continue;
                        if (matrix[i + 1][j] == 0) {
                            moveDown(i, j);
                        }
                    }
                }
            }

            /**
             * TODO : 상하좌우 검색
             */
            visit = new boolean[12][6];
            int check = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        if (visit[i][j])
                            continue;
                        visit[i][j] = true;
                        check += bfs(i, j, matrix[i][j]);
                    }
                }
            }
            if (check > 0) {
                result++;
            } else {
                break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}