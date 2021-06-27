import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|N과 M|15656
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static ArrayList<String> result = new ArrayList<String>();
    static int N, M;
    static int arr[];
    static int input[];
    static boolean visit[];

    static void comb(int idx, int cnt) {
        // 기저 조건
        if (cnt == M) {
            result.add(Arrays.toString(arr).replaceAll("[^0-9 ]", ""));
            return;
        }

        for (int i = idx + 1; i <= N; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            arr[cnt] = input[i];
            comb(i, cnt + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        input = new int[N + 1];
        visit = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        comb(0, 0);

        for (String res : result) {
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }
}