package TEST;

import java.io.*;

public class Main {
	static int map[][] = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 0},
						  {5, 20, 21, 22, 23, 24, 15, 16, 17, 18, 19, 0},
						  {10, 25, 26, 22, 27, 28, 0},
						  {22, 27, 28, 0}
						  };
	static int input[] = {4, 4, 2, 4, -1, -1};
	static int result;
	static boolean flag;
	static void solve(int cy, int y, int x, int cnt) {
		int ny = y; 
		int nx = x;
		// 기저 조건
		if(flag && x == 0 && y == 0)
		{
			result = 0;
			return;
		}
		if(cnt == input.length)
		{
			if(map[y].length <= x)
			{
				result = 0;
				return;
			}
			else
			{
				result = map[y][x];
				return;
			} 
		}
		// 1. 백 도
		if(input[cnt] == -1)
		{
			
			if(y == 1)
			{
				if(x == 0)
				{
					ny = 0;
					nx = 4;
				}
				else if(x == 6)
				{
					ny = 1;
					nx = 0;
				}
				else if(x == 11)
				{
					ny = 2;
					nx = 0;
				}
				else nx = x + input[cnt];
			}
			else if(y == 2)
			{
				if(x == 0)
				{
					ny = 0;
					nx = 9;
				}
				else nx = x + input[cnt];
			}
			else if(y == 3)
			{
				if(x == 0)
				{
					if(cy == 1)
					{
						ny = 1;
						nx = 2;
					}
					else if(cy == 2)
					{
						ny = 2;
						nx = 2;
					}
				}
				else if(x == 1) {
					nx = x + input[cnt];
				}
			}
			else 
			{
				nx = x + input[cnt];
			}
		}
		// 도, 개, 걸, 윳, 모
		else if(input[cnt] > 0)
		{
			nx = x + input[cnt];
			if(y == 0)
			{
				if(nx == 5)
				{
					cy = y;
					ny = 1;
					nx = 0;
				}
				else if(nx == 10)
				{
					cy = y;
					ny = 2;
					nx = 0;
				}
			}
			else if(y == 1)
			{
				if(nx == 3)
				{
					cy = y;
					ny = 3;
					nx = 0;
				}
			}
		}
		solve(cy, ny, nx, cnt + 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int y = 0, x = 0;
		if(input[0] == -1)
		{
			x = 0;
		}
		else if(input[0] == 5)
		{
			x = 0; y = 1;
			flag = true;
		}
		else 
		{
			x += input[0];
			flag = true;
		}
		solve(0, y, x, 1);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
