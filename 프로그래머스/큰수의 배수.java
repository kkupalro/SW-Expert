import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
				while(T-- > 0)
				{
				BigInteger N = new BigInteger(br.readLine());
				int ans = 9 - N.mod(new BigInteger("9")).intValue();
				bw.write(ans + "\n");
				}
				bw.flush();
				bw.close();
		}
}
