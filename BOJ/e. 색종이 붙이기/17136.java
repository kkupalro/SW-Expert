import java.io.*;
import java.util.*;

public class Main {
	static int matrix[][] = new int[10][10];
	static int map[] = new int[5];
	static int result = Integer.MAX_VALUE;
	static void draw(int y, int x, int l) {
		for(int r = y; r <= y + l; r++)
		{
			for(int c = x; c <= x + l; c++)
			{
				matrix[r][c] = 0;
			}
		}
	}
	static void backtracking(int y, int x, int l) {
		for(int r = y; r <= y + l; r++)
		{
			for(int c = x; c <= x + l; c++)
			{
				matrix[r][c] = 1;
			}
		}
	}
	static boolean check(int y, int x, int l) {
		if(map[l] <= 0 || y + l >= 10 || x + l >= 10) return false;
		for(int r = y; r <= y + l; r++)
		{
			for(int c = x; c <= x + l; c++)
			{
				if(matrix[r][c] == 0) return false;
			}
		}
		return true;
	}
	static void solve(int y, int cnt) {
		// 기저 조건
		if(cnt >= result) return;
		for(int i = y; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(matrix[i][j] == 1)
				{
					
					for(int l = 4; l >= 0; l--)
					{
						if(!check(i, j, l)) continue;
						map[l]--;
						draw(i, j, l);
						solve(i, cnt + 1);
						backtracking(i, j, l);
						map[l]++;
					}
					return;
				}
				if(i == 9 && j == 9)
				{
					result = Math.min(result, cnt);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for(int i = 0; i < 10; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(map, 5);
		solve(0, 0);
		result = (result==Integer.MAX_VALUE)?-1:result;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}