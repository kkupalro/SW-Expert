import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0630|BOJ|변수명|16205
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb[] = new StringBuilder[3];
    static int N;

    private static void convert(StringBuilder str) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        if (N == 1) {
            /*
             * 카멜 표기법 camelCase, variableN, thisIsCamelCase, howToSolveThisProblem
             */
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                    a.append("_");
                    a.append((char) (str.charAt(i) + 32));
                } else {
                    a.append(str.charAt(i));
                }

                if (i == 0) {
                    b.append((char) (str.charAt(i) - 32));
                } else {
                    b.append(str.charAt(i));
                }
            }

            sb[1].append(a);
            sb[2].append(b);

        } else if (N == 2) {
            /*
             * 스네이크 표기법 snake_case, variable_n, this_is_snake_case,
             * how_to_solve_this_problem
             */
            for (int i = 0; i < str.length(); i++) {
                
                if(str.charAt(i) == 95) {
                    i += 1;
                    a.append((char) (str.charAt(i) - 32));
                    b.append((char) (str.charAt(i) - 32));
                } else {
                    a.append(str.charAt(i));
                    if(i == 0) {
                        b.append((char) (str.charAt(i) - 32));
                    } else {
                        b.append(str.charAt(i));
                    }
                }
            }
            sb[0].append(a);
            sb[2].append(b);

        } else if (N == 3) {
            /*
             * 파스칼 표기법 PascalCase, VariableN, ThisIsPascalCase, HowToSolveThisProblem
             */
            for (int i = 0; i < str.length(); i++) {
                
                if (i == 0) {
                    a.append((char) (str.charAt(i) + 32));
                    b.append((char) (str.charAt(i) + 32));
                } else {
                    a.append(str.charAt(i));
                    if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                        b.append("_");
                        b.append((char)(str.charAt(i) + 32));
                    } else {
                        b.append(str.charAt(i));
                    }
                }
            }
            // a 97, z 122, _ 95, A 65, Z 90
            sb[0].append(a);
            sb[1].append(b);
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < sb.length; i++) {
            if (i == N - 1) {
                sb[i] = new StringBuilder(st.nextToken());
            } else {
                sb[i] = new StringBuilder();
            }

        }

        convert(sb[N - 1]);

        for (int i = 0; i < sb.length; i++) {
            // a 97, z 122, _ 95, A 65, Z 90
            bw.write(sb[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
