package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author yoo
 * @commit 0922|BOJ|암호 만들기|1759
 *
 */

public class Main {
    static int L, C;
    static StringTokenizer st;
    static TreeSet<String> ts = new TreeSet<String>();
    static String code[];

    static boolean isValid(String s) {
        int m = 0;
        int j = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                m++;
            } else {
                j++;
            }
        }
        if (m >= 1 && j >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        code = new String[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            code[i] = st.nextToken();
        }
        Arrays.sort(code);

        // TODO : 조합
        for (int i = 0; i < C; i++) {
            combination(i, code[i]);
        }

        for (String str : ts) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void combination(int idx, String s) {
        // 기저 조건
        if (s.length() == L) {
            /**
             * FIXME : 최소 한개의 모음 + 두개의 자음으로 구성
             */
            if (isValid(s)) {
                ts.add(s);
            }
            return;
        }

        for (int i = idx + 1; i < C; i++) {
            combination(i, s + code[i]);
        }

    }
}