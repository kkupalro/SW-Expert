package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static long X, Y;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			X = Long.parseLong(st.nextToken());
			Y = Long.parseLong(st.nextToken());
			X = Y - X;
			Y = (long)Math.sqrt(X);
			if(Y*Y == X) {
				bw.write(2*Y-1 + "\n");
			}
			else if(Y*(Y+1) < X)
			{
				bw.write(2*Y+1 + "\n");
			}
			else bw.write(2*Y + "\n");
		}
		bw.flush();
		bw.close();
	}
}
