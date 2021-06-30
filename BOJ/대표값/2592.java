import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @author yoo
 * @commit 0630|BOJ|대표값|2592
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int result;
    static int div;
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            div += n;
            if (hm.containsKey(n)) {
                hm.put(n, hm.get(n) + 1);
            } else {
                hm.put(n, 1);
            }

            if (min < hm.get(n)) {
                min = hm.get(n);
                result = n;
            }
        }
        div /= 10;

        bw.write(div + "\n" + result + "\n");
        bw.flush();
        bw.close();
    }
}
