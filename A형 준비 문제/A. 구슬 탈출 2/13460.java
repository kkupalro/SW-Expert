package A;

import java.io.*;
import java.util.*;

public class Main {
	static int result = Integer.MAX_VALUE;
	static final int dy[] = {-1, 0, 0, 1};
	static final int dx[] = { 0,-1, 1, 0};
	static class Point {
		int x; int y;
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static void copy(char a[][], char b[][]) {
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 11; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void solve(char matrix[][], int cnt, int dir, Point R, Point B) {
		if(++cnt > 10)
		{
			return;
		}
		char temp[][] = new char[11][11];
		copy(temp, matrix);
		boolean red = false;
		boolean blue = false;
		int check = 0;
		switch (dir) {
		case 0:
			if(B.y < R.y) 
				check = 1;
			break;
		case 1:	
			if(B.x < R.x) 
				check = 1;
			break;
		case 2:	
			if(R.x < B.x) 
				check = 1;
			break;
		case 3:	
			if(R.y < B.y) 
				check = 1;
			break;
		}
		if(check == 0)
		{
			// R ����
			while(true)
			{
				int ny = dy[dir] + R.y;
				int nx = dx[dir] + R.x;
				if(temp[ny][nx] == '#')
				{
					break;
				}
				if(temp[ny][nx] == 'O')
				{
					temp[R.y][R.x] = '.';
					R = null;
					red = true;
					break;
				}
				temp[R.y][R.x] = '.';
				temp[ny][nx] = 'R';
				R = new Point(nx, ny);
			}
			while(true)
			{
				int ny = dy[dir] + B.y;
				int nx = dx[dir] + B.x;
				if(temp[ny][nx] == '#' || temp[ny][nx] == 'R')
				{
					break;
				}
				if(temp[ny][nx] == 'O')
				{
					temp[B.y][B.x] = '.';
					B = null;
					blue = true;
					break;
				}
				temp[B.y][B.x] = '.';
				temp[ny][nx] = 'B';
				B = new Point(nx, ny);
			}
		}
		else if(check == 1)
		{
			// B ����
			while(true)
			{
				int ny = dy[dir] + B.y;
				int nx = dx[dir] + B.x;
				if(temp[ny][nx] == '#')
				{
					break;
				}
				if(temp[ny][nx] == 'O')
				{
					// B�� Ż��� ����
					temp[B.y][B.x] = '.';
					B = null;
					blue = true;
					break;
				}
				temp[B.y][B.x] = '.';
				temp[ny][nx] = 'B';
				B = new Point(nx, ny);
			}
			while(true)
			{
				int ny = dy[dir] + R.y;
				int nx = dx[dir] + R.x;
				if(temp[ny][nx] == '#' || temp[ny][nx] == 'B')
				{
					break;
				}
				if(temp[ny][nx] == 'O')
				{
					temp[R.y][R.x] = '.';
					R = null;
					red = true;
					break;
				}
				temp[R.y][R.x] = '.';
				temp[ny][nx] = 'R';
				R = new Point(nx, ny);
			}
		}
		if(blue)
		{
			return;
		}
		else if(red)
		{
			result = Math.min(result, cnt);
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			if(i != dir || i != (3 - dir))
			{
				solve(temp, cnt, i, R, B);
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Point r = null;
		Point b = null;
		char matrix[][] = new char[11][11];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < X; j++)
			{
				if(sb.charAt(j) == 'R')
				{
					r = new Point(j,i);
				}
				else if(sb.charAt(j) == 'B')
				{
					b = new Point(j,i);
				}
				matrix[i][j] = sb.charAt(j);
			}
			sb.setLength(0);
		} 
		for(int l = 0; l < 4; l++)
		{
			solve(matrix, 0, l, r, b);
		}
		if(result == Integer.MAX_VALUE)
		{
			bw.write(-1 + "\n");
		}
		else {
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
