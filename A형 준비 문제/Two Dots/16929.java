import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {1, 0,-1, 0}; // ^ > v <
	static final int dx[] = {0, 1, 0,-1};
	static int Y, X;
	static boolean flag = false;
	static char matrix[][] = new char[51][51];
	static boolean visit[][] = new boolean[51][51];
	static StringBuilder sb = new StringBuilder();
	static void solve(int r, int c, int y, int x, int cnt) {
		int ny = 0; int nx = 0;
		for(int l = 0; l < 4; l++)
		{
			ny = y + dy[l];
			nx = x + dx[l];
			if(ny < 0 || ny >= Y || nx < 0 || nx >= X) continue;
			if(matrix[ny][nx] != matrix[y][x]) continue;
			if(!visit[ny][nx])
			{
				visit[ny][nx] = true;
				solve(r, c, ny, nx, cnt + 1);
				visit[ny][nx] = false;
			}
			else if(visit[ny][nx])
			{
				if(ny == r && nx == c && cnt >= 4)
				{
					flag = true;
					return;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = sb.charAt(j);
			}
			sb.setLength(0);
		}
		loop:
		for(int i = 0; i < Y-1; i++)
		{
			for(int j = 0; j < X-1; j++)
			{
				if(!flag)
				{
					visit[i][j] = true;
					solve(i, j, i, j, 1);
					visit[i][j] = false;
				}
				else break loop;
			}
		}
		String result = (flag)?"Yes":"No";
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
