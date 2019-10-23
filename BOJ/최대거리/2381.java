package TEST;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Point p[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		p = new Point[N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++)
		{
			max1 = Math.max(max1, p[i].x + p[i].y);
			min1 = Math.min(min1, p[i].x + p[i].y);
			max2 = Math.max(max2, p[i].x - p[i].y);
			min2 = Math.min(min2, p[i].x - p[i].y);
		}
		bw.write(Math.max(max1-min1, max2-min2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}