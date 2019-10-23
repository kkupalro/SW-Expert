package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {-1, 0, 1, 0};
	static final int dx[] = {0, 1, 0, -1};
	static int Y, X;
	static int matrix[][];
	static int dp[][];
	static void print(int a[][]) {
		System.out.println("===================");
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		matrix = new int[Y+1][X+1];
		dp = new int[Y+1][X+1];
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				for(int l = 0; l < 4; l++)
				{
					int ny = i + dy[l];
					int nx = j + dx[l];
					if(ny < 0 || ny >= Y || nx < 0 || nx >= X) continue;
					dp[i][j] = Math.max(dp[i][j], matrix[i][j] + dp[ny][nx]);
				}
			}
		}
		bw.write(dp[Y-1][X-1] + "\n");
		bw.flush();
		bw.close();
	}
}
