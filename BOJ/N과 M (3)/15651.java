import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static ArrayList<String> result = new ArrayList<String>();
    static int N, M;
    static int arr[];

    static void comb(int cnt) {
        // 기저 조건
        if (cnt == M) {
            result.add(Arrays.toString(arr).replaceAll("[^0-9 ]", ""));
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[cnt] = i;
            comb(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        comb(0);
        
        for (String res : result) {
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }
}