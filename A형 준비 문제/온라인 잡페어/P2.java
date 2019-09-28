package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {-1,-1, 1,1};
	static final int dx[] = {-1, 1,-1,1};
	static int matrix[][] = new int[8][8]; 
	static String[] bishops = {"D5", "E8", "G2"};
	static int result = 0;
	static void solve(int y, int x) {
		int ny = 0; int nx = 0;
		for(int i = 1; i < 8; i++)
		{
			for(int l = 0; l < 4; l++)
			{
				ny = y + dy[l] * i;
				nx = x + dx[l] * i;
				if(ny < 0 || ny >= 8 || nx < 0 || nx >= 8) continue;
				matrix[ny][nx] = 1;
			}
		}
	}
	static int check() {
		int ans = 0;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(matrix[i][j] == 0)
				{
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < bishops.length; i++)
		{
			int y = 9 - (bishops[i].charAt(1) - '0');
			int x = bishops[i].charAt(0) - 65;
			matrix[y-1][x] = 1;
			solve(y-1, x);
		}
		bw.write(check() + "\n");
		bw.flush();
		bw.close();
	}
}
