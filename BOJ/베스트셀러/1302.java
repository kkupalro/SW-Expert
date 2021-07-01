import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yoo
 * @commit 0701|BOJ|베스트셀러|1302
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int max;
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            if (hm.containsKey(title)) {
                hm.put(title, hm.get(title) + 1);
            } else {
                hm.put(title, 1);
            }
            max = Math.max(max, hm.get(title));
        }

        ArrayList<String> al = new ArrayList<String>();
        for (String key : hm.keySet()) {
            if (hm.get(key) == max) {
                al.add(key);
            }
        }
        al.sort(null);
        bw.write(al.get(0) + "\n");
        bw.flush();
        bw.close();
    }
}