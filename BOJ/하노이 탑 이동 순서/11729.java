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
 * @commit 0627|BOJ|A-SA 문제집-2|11729
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int result;
    static ArrayList<String> al = new ArrayList<String>();

    static void hanoi(int n, int from, int temp, int to) {
        result++;
        if (n == 1) {
            al.add(from + " " + to);
            return;
        }
        hanoi(n - 1, from, to, temp);
        al.add(from + " " + to);
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hanoi(Integer.parseInt(br.readLine()), 1, 2, 3);

        bw.write(result + "\n");
        for (String s : al) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}