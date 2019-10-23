package TEST;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = { 0, 1, 0,-1};
	static final int dx[] = { 1, 0,-1, 0};
	static int R, C, T;
	static boolean visit[] = new boolean[6];
	static int matrix[][] = new int[51][51];
	static int temp[][];
	static int result;
	static LinkedList<Point> list = new LinkedList<Point>();
	static void print(int a[][]) {
		System.out.println("=================================");
		for (int i = 1; i <= R ; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void cal(int a[][]) {
		for (int i = 1; i <= R ; i++) 
		{
			for (int j = 1; j <= C; j++) 
			{
				if(a[i][j] > 0) result += a[i][j];
			}
		}
	}
	static int check(int y, int x) {
		int ans = 0;
		for(int l = 0; l < 4; l++)
		{
			int ny = y + dy[l];
			int nx = x + dx[l];
			if(ny < 1 || ny > R || nx < 1 || nx  > C) continue;
			if(matrix[ny][nx] == -1) continue;
			ans++;
		}
		return ans;
	}
	static void up(int y, int x) {
		// 1. >
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i = 2; i <= C; i++)
		{
			tmp1 = matrix[y][i];
			matrix[y][i] = tmp2;
			tmp2 = tmp1;
		}
		// 2. ^
		for(int i = y-1; i > 1; i--)
		{
			tmp1 = matrix[i][C];
			matrix[i][C] = tmp2;
			tmp2 = tmp1;
		}
		// 3. <
		for(int i = C; i > 1; i--)
		{
			tmp1 = matrix[1][i];
			matrix[1][i] = tmp2;
			tmp2 = tmp1;
		}
		// 4. v
		for(int i = 1; i < y; i++)
		{
			tmp1 = matrix[i][1];
			matrix[i][1] = tmp2;
			tmp2 = tmp1;
		}
	}
	static void down(int y, int x) {
		// 1. >
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i = 2; i <= C; i++)
		{
			tmp1 = matrix[y][i];
			matrix[y][i] = tmp2;
			tmp2 = tmp1;
		}
	    // 2. v
		for(int i = y+1; i <= R; i++)
		{
			tmp1 = matrix[i][C];
			matrix[i][C] = tmp2;
			tmp2 = tmp1;
		}	
		// 3. <
		for(int i = C-1; i >= 1; i--)
		{
			tmp1 = matrix[R][i];
			matrix[R][i] = tmp2;
			tmp2 = tmp1;
		}
	    // 4. ^
		for(int i = R-1; i > y; i--)
		{
			tmp1 = matrix[i][1];
			matrix[i][1] = tmp2;
			tmp2 = tmp1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= R; i++)
		{
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j = 1; j <= C; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == -1)
				{
					list.add(new Point(j, i));
				}
			}
		}
		// 1. 확산, 2. 공기청정기 작동
		while(T-- > 0)
		{
			temp = new int[51][51];
			// 1. 확산
			for(int i = 1; i <= R; i++)
			{
				for(int j = 1; j <= C; j++)
				{
					if(matrix[i][j] > 0)
					{
						int cnt = check(i,j);
						int data = matrix[i][j]/5;
						if(cnt > 0)
						{
							matrix[i][j] -= (matrix[i][j] / 5) * cnt;
							for(int l = 0; l < 4; l++)
							{
								int ny = i + dy[l];
								int nx = j + dx[l];
								if(ny < 1 || ny > R || nx < 1 || nx  > C) continue;
								if(matrix[ny][nx] == -1) continue;
								temp[ny][nx] += data;
							}
						}
					}
				}
			}
			for(int i = 1; i <= R; i++)
			{
				for(int j = 1; j <= C; j++)
				{
					if(temp[i][j] > 0)
					{
						matrix[i][j] += temp[i][j];
					}
				}
			}
			// 2. 공기청정기 이동
			up(list.get(0).y , list.get(0).x);
			down(list.get(1).y , list.get(1).x);
		}
		cal(matrix);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}