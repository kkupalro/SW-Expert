import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|주사위 네개|2484
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static LinkedHashMap<Integer, Integer> hm;
    static int result = Integer.MIN_VALUE;

    static int calc(int key, int value) {
        int cost = 0;
        switch (value) {
        case 1:
            cost = 100 * key;
            break;
        case 2:
            cost = 1000 + (100 * key);
            break;
        case 3:
            cost = 10000 + (1000 * key);
            break;
        case 4:
            cost = 50000 + (5000 * key);
            break;
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            hm = new LinkedHashMap<Integer, Integer>();
            int key = 0;
            int value = 0;
            for (int i = 0; i < 4; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (hm.containsKey(n)) {
                    hm.put(n, hm.get(n) + 1);
                } else {
                    hm.put(n, 1);
                }
                value = Math.max(value, hm.get(n));
            }
            
            if(hm.keySet().size() == 2 && value == 2) {
                int cost = 2000;
                for (int k : hm.keySet()) {
                    cost += 500 * k;
                }
                result = Math.max(result, cost);
            } else {
                for (int k : hm.keySet()) {
                    if (hm.get(k) == value) {
                        key = Math.max(key, k);
                    }
                }
                result = Math.max(result, calc(key, value));
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}