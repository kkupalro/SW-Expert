import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|2775
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int T, K, N;
    static int matrix[][] = new int[15][15];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        
        
        
        
        for(int i = 0; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                if(i == 0) {
                    matrix[i][j] = j;
                } else if(j == 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
            
        }

        while (T-- > 0) {
            K = Integer.parseInt(br.readLine()); // 1, 2
            N = Integer.parseInt(br.readLine()); // 3, 3

            /*
             *  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 15
             *  1, 3, 6,10,15,21,28,36,45,55,66, ....
             *  matrix[K][N] = matrix[K-1][N] + matrix[K][N-1]
             */

            bw.write(matrix[K][N] + "\n");
        }
        bw.flush();
        bw.close();
    }
}