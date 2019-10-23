package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x;
	node(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int R, C, T, result;
	static int matrix[][];
	static final int dy[] = {0, 1, 0,-1};
	static final int dx[] = {1, 0,-1, 0};
	static node clean[] = new node[2];
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void solve(int t) {
		// 기저 사례
		if(t == T)
		{
			for(int i = 0; i < R; i++)
			{
				for(int j = 0; j < C; j++)
				{
					if(matrix[i][j] != -1 && matrix[i][j] != 0)
					{
						result += matrix[i][j];
					}
				}
			}
			return;
		}
		// 1. 확산
		boolean visit[][] = new boolean[R][C];
		int temp[][] = new int[R][C];
		for(int i = 0; i < R; i++)
		{
			for(int j = 0; j < C; j++)
			{
				if(matrix[i][j] != -1 && matrix[i][j] != 0)
				{
					visit[i][j] = true;
				}
			}
		}
		for(int i = 0; i < R; i++)
		{
			for(int j = 0; j < C; j++)
			{
				if(visit[i][j])
				{
					int cnt = 0;
					// 4방향 확산
					for(int l = 0; l < 4; l++)
					{
						int ny = i + dy[l];
						int nx = j + dx[l];
						if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
						if(matrix[ny][nx] == -1) continue;
						cnt++;
					}
					int data = matrix[i][j];
					int dust = data/5;
					matrix[i][j] = data - (dust * cnt);  
					for(int l = 0; l < 4; l++)
					{
						int ny = i + dy[l];
						int nx = j + dx[l];
						if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
						if(matrix[ny][nx] == -1) continue;
						temp[ny][nx] += dust;
					}
				}
			}
		}
		for(int i = 0; i < R; i++)
		{
			for(int j = 0; j < C; j++)
			{
				matrix[i][j] += temp[i][j];
			}
		}
		// 2. 공기 청정기 이동
		// 0번(위) 공기 청정기
		// > ^ < v
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i = 1; i < C; i++)
		{
			tmp1 = matrix[clean[0].y][i];
			matrix[clean[0].y][i] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = clean[0].y-1; i > 0; i--)
		{
			tmp1 = matrix[i][C-1];
			matrix[i][C-1] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = C-1; i > 0; i--)
		{
			tmp1 = matrix[0][i];
			matrix[0][i] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = 0; i < clean[0].y; i++)
		{
			tmp1 = matrix[i][0];
			matrix[i][0] = tmp2;
			tmp2 = tmp1;
		}
		// 1번(아래) 공기 청정기
		// > v < ^
		tmp1 = 0;
		tmp2 = 0;
		for(int i = 1; i < C; i++)
		{
			tmp1 = matrix[clean[1].y][i];
			matrix[clean[1].y][i] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = clean[1].y+1; i < R; i++)
		{
			tmp1 = matrix[i][C-1];
			matrix[i][C-1] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = C-2; i >= 0; i--)
		{
			tmp1 = matrix[R-1][i];
			matrix[R-1][i] = tmp2;
			tmp2 = tmp1;
		}
		for(int i = R-2; i > clean[1].y; i--)
		{
			tmp1 = matrix[i][0];
			matrix[i][0] = tmp2;
			tmp2 = tmp1;
		}
		solve(t + 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // Y 좌표
		C = Integer.parseInt(st.nextToken()); // X 좌표
		T = Integer.parseInt(st.nextToken()); // 시간
		int idx = 0;
		matrix = new int[R][C];
		for(int i = 0; i < R; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == -1)
				{
					clean[idx++] = new node(i, j);
				}
			}
		}
		solve(0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}