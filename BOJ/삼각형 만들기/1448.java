import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @author yoo
 * @commit 0701|BOJ|삼각형 만들기|1448
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int arr[];
    static int result = -1;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = N-1; i > 1; i--) {
            if (arr[i] < arr[i-1] + arr[i-2]) {
                result = Math.max(result, arr[i] + arr[i-1] + arr[i-2]);
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}