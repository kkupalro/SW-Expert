import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static ArrayList<String> result = new ArrayList<String>();
    static int N, M;
    static boolean visit[];
    static int arr[];

    static void comb(int idx, int cnt) {
        // 기저 조건
        if (cnt == M) {
            String s = "";
            for (int a : arr) {
                s += a + " ";
            }
            if (!result.contains(s)) {
                result.add(s.trim());
            }
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (visit[i]) continue;
            
            visit[i] = true;
            arr[cnt] = i;
            comb(i + 1, cnt + 1);
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
        visit = new boolean[N + 1];
        comb(1, 0);
        
        for (String res : result) {
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }
}