package TEST;

import java.awt.Point;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int T, N, result, sx, sy, ex, ey;
	static double sd, ed;
	static Point S;
	static Point E;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			S = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			E = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sx = x - S.x;
				sy = y - S.y;
				sd = Math.sqrt(sx*sx + sy*sy);
				ex = x - E.x;
				ey = y - E.y;
				ed = Math.sqrt(ex*ex + ey*ey);
				if(sd <= c && ed <= c)
				{
					continue;
				}
				else if(sd <= c || ed <= c)
				{
					result++;
				}
			}
			bw.write(result + "\n");
			result = 0;
		}
		bw.flush();
		bw.close();
	}
}
