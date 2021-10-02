import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 1002|BOJ|수강신청|13414
 *
 */

public class Main {
	static int K, L;
	static StringTokenizer st;
	static LinkedHashMap<String, Boolean> map = new LinkedHashMap<String, Boolean>(1, 1, true);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; i++) {
			map.put(br.readLine(), false);
		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext() && K-- > 0) {
			bw.write(it.next() + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}