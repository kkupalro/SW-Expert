package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, R;
	static int matrix[][] = new int[100][100];
	static int temp[][] = new int[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x = 1, y = 1, r = 0, m = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < R; i++)
		{
			int type = Integer.parseInt(st.nextToken());
			switch (type) {
			case 1:
				y *= - 1;
				break;
			case 2:
				x *= - 1;
				break;
			case 3:
				r = (r + 2 - x * y) % 4;
				break;
			case 4:
				r = (r + 2 + x * y) % 4;
				break;
			case 5:
				m = (m + 2 - x * y) % 4;
				break;
			case 6:
				m = (m + 2 + x * y) % 4;
				break;
			default:
				break;
			}
		}
		for(int yy = Y >> 1, xx = X >> 1, rotate = 0; rotate < m; rotate++)
		{
			for(int i = 0; i < yy; i++)
			{
				for(int j = 0; j < xx; j++)
				{
					matrix[i][j] ^= matrix[i][j+xx];
					matrix[i][j+xx] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i][j+xx];
					
					matrix[i][j] ^= matrix[i+yy][j+xx];
					matrix[i+yy][j+xx] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i+yy][j+xx];
					
					matrix[i][j] ^= matrix[i+yy][j];
					matrix[i+yy][j] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i+yy][j];
				}
			}
		}
		if(x * y < 0)
		{
			r = (4 - r) % 4;
		}
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				int nx = i, ny = j;
				if (x < 0) ny = X - 1 - ny;
				if (y < 0) nx = Y - 1 - nx;
				int tx = nx, ty = ny;
				if (r == 1) {
					nx = ty;
					ny = Y - 1 - tx;
				}
				else if (r == 2) {
					nx = Y - 1 - tx;
					ny = X - 1 - ty;
				}
				else if (r == 3) {
					nx = X - 1 - ty;
					ny = tx;
				}
				temp[nx][ny] = matrix[i][j];
			}
		}
		if(r % 2 == 1)
		{
			Y ^= X;
			X ^= Y;
			Y ^= X;
		}
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
