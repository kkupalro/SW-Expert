package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0921|BOJ|싸지방에 간 준하|12764
 *
 */

class Computer implements Comparable<Computer> {
    int idx, end;

    Computer(int idx, int end) {
        this.idx = idx;
        this.end = end;
    }

    @Override
    public int compareTo(Computer o) {
        return this.end - o.end;
    }

}

public class Main {
    static int N;
    static int seat[] = new int[100001];
    static int matrix[][];
    static StringTokenizer st;
    static PriorityQueue<Computer> pq = new PriorityQueue<Computer>();
    static PriorityQueue<Integer> tq = new PriorityQueue<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            matrix[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            int P = matrix[i][0]; // 시작 시간
            int Q = matrix[i][1]; // 종료 시간

            while (!pq.isEmpty() && P >= pq.peek().end) {
                tq.offer(pq.poll().idx);
            }
            seat[tq.isEmpty() ? pq.size() : tq.peek()]++;
            pq.offer(new Computer(tq.isEmpty() ? pq.size() : tq.poll(), Q));

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100001; i++) {
            if (seat[i] == 0) {
                bw.write(i + "\n");
                break;
            }
            sb.append(seat[i] + " ");
        }
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}