package TEST;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][];
	static int Y, X, result;
	static Queue<Point> q = new LinkedList<Point>();
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve() {
		int ny = 0; int nx = 0; int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			for(int i = 0; i < size; i++)
			{
				Point p = q.poll();
				int y = p.y;
				int x = p.x;
				for(int l = 0; l < 4; l++)
				{
					ny = y + dy[l];
					nx = x + dx[l];
					if(ny < 0 || ny > Y-1 || nx < 0 || nx > X-1) continue;
					if(matrix[ny][nx] == -1 || matrix[ny][nx] == 1) continue;
					matrix[ny][nx] = 1;
					q.offer(new Point(nx, ny));
				}
			}
			result++;
		}
		result--;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		matrix = new int[Y][X];
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 1)
				{
					q.offer(new Point(j, i));
				}
			}
		}
		solve();
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				if(matrix[i][j] == 0)
				{
					result = -1;
					break;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}