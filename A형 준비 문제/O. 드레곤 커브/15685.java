package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {0,-1, 0, 1}; // > ^ < v
	static final int dx[] = {1, 0,-1, 0};
	static boolean map[][] = new boolean[101][101];
	static int matrix[][] = new int[4][1024];
	static int N;
	static int result;
	static void print(int a[][]) {
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void solve(int x, int y, int d, int g) {
		map[y][x] = true;
		int ny = 0; int nx = 0; int cy = y; int cx = x;
		int e = (int) Math.pow(2, g);
		for(int i = 0; i < e; i++)
		{
			ny = cy + dy[matrix[d][i]];
			nx = cx + dx[matrix[d][i]];
			if(ny < 0 || ny > 100 || nx < 0 || nx > 100) continue;
			map[ny][nx] = true;
			cy = ny;
			cx = nx;		
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix[0][0] = 0;
		matrix[1][0] = 1;
		matrix[2][0] = 2;
		matrix[3][0] = 3;
		result = 0;
		for(int l = 0; l < 4; l++)
		{
			for(int i = 1; i <= 10; i++)
			{
				int s = (int) Math.pow(2, i-1);
				int e = (int) Math.pow(2, i);
				for(int j = s, k = 1; j < e; j++, k+=2)
				{
					matrix[l][j] = (matrix[l][j-k] + 1) % 4;
				}
			}
		}
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x 좌표 (0 ~ 100)
			int y = Integer.parseInt(st.nextToken()); // y 좌표 (0 ~ 100)
			int d = Integer.parseInt(st.nextToken()); // d 방향 (> ^ < v) (0 ~ 3)
			int g = Integer.parseInt(st.nextToken()); // 세대 (0 ~ 10)
			solve(x, y, d, g);
		}
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100; j++)
			{
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
				{
					result++;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
