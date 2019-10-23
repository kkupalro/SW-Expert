package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int result;
	static int x, y, w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		result = Math.min(Math.min(Math.abs(x-w), x), Math.min(Math.abs(y-h), y));
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
