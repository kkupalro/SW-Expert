package TEST;

import java.io.*;

public class Main {
	static int T, t_num;
	static long N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			N = Long.parseLong(br.readLine());
			long max = 2 * N * N - 1;
			long min = max - (4 * N) + 4;
			bw.write("#" + ++t_num + " " + min + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
}

