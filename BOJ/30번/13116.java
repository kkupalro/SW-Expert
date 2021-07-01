import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0701|BOJ|30번|13116
 *
 */
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, A, B;
    static int result = 1;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            // A > B되게
            if(B > A) {
                A ^= B;
                B ^= A;
                A ^= B;
            }
            
            while(true) {
                if(A - B < B) break;
                A/=2;
            }
            
            int a = A;
            int b = B;
            
            while(a != b) {
                a /= 2;
                if(a == b) break;
                b /= 2;
            }
            
            bw.write(a * 10 + "\n");    
        }
        bw.flush();
        bw.close();
    }
}
