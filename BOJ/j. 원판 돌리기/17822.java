package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int dy[] = {0, 0, 1,-1};
	static final int dx[] = {1,-1, 0, 0};
	static int Y, X, T;
	static int result;
	static int matrix[][];
	static boolean visit[][];
	static void print(int a[][]) {
		System.out.println("==================");
		for (int i = 1; i < a.length; i++) 
		{
			for (int j = 1; j < a[i].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==================");
	}
	static void rotate(int x, int d, int k) {
		if(d == 0)
		{
			// 시계
			for(int r = 0; r < k; r++)
			{
				int tmp1 = matrix[x][1];
				matrix[x][1] = matrix[x][X];
				int tmp2 = tmp1;
				for(int i = 2; i <= X; i++)
				{
					tmp1 = matrix[x][i];
					matrix[x][i] = tmp2;
					tmp2 = tmp1;
				}
			}
		}
		else if(d == 1)
		{
			// 반 시계
			for(int r = 0; r < k; r++)
			{
				int tmp1 = matrix[x][X];
				matrix[x][X] = matrix[x][1];
				int tmp2 = tmp1;
				for(int i = X-1; i >= 1; i--)
				{
					tmp1 = matrix[x][i];
					matrix[x][i] = tmp2;
					tmp2 = tmp1;
				}
			}
		}
	}
	static void check() {
		boolean flag = false;
		visit = new boolean[Y+1][X+1];
		int sum = 0;
		int cnt = 0;
		int ny = 0, nx = 0;
		for(int i = 1; i <= Y; i++)
		{
			for(int j = 1; j <= X; j++)
			{
				if(matrix[i][j] > 0 && !visit[i][j])
				{
					// (1) x -1 , (2) x + 1, (3) y + 1, (4) y - 1;
					if(i == 1)
					{
						for(int l = 0; l < 3; l++)
						{
							ny = i + dy[l];
							nx = j + dx[l];
							if(nx > X)
							{
								nx = 1;
							}
							else if(nx < 1)
							{
								nx = X;
							}
							
							if(matrix[i][j] == matrix[ny][nx])
							{
								flag = true;
								visit[i][j] = true;
								visit[ny][nx] = true;
							}
						}
					}
					else if(i == Y)
					{
						for(int l = 0; l < 4; l++)
						{
							if(l == 2) continue;
							ny = i + dy[l];
							nx = j + dx[l];
							if(nx > X)
							{
								nx = 1;
							}
							else if(nx < 1)
							{
								nx = X;
							}
							
							if(matrix[i][j] == matrix[ny][nx])
							{
								flag = true;
								visit[i][j] = true;
								visit[ny][nx] = true;
							}
						}
					}
					else
					{
						for(int l = 0; l < 4; l++)
						{
							ny = i + dy[l];
							nx = j + dx[l];
							if(nx > X)
							{
								nx = 1;
							}
							else if(nx < 1)
							{
								nx = X;
							}
							
							if(matrix[i][j] == matrix[ny][nx])
							{
								flag = true;
								visit[i][j] = true;
								visit[ny][nx] = true;
							}
						}
					}
				}
			}
		}
		if(!flag)
		{
			for(int i = 1; i <= Y; i++)
			{
				for(int j = 1; j <= X; j++)
				{
					if(matrix[i][j] > 0 && !visit[i][j])
					{
						sum += matrix[i][j];
						cnt += 1;
					}
				}
			}
			double avg = (double)sum / cnt;
			for(int i = 1; i <= Y; i++)
			{
				for(int j = 1; j <= X; j++)
				{
					if(matrix[i][j] > 0)
					{
						if(matrix[i][j] < avg)
						{
							matrix[i][j]++;
						}
						else if(matrix[i][j] > avg)
						{
							matrix[i][j]--;
						}
					}
				}
			}
		}
		else if(flag)
		{
			for(int i = 1; i <= Y; i++)
			{
				for(int j = 1; j <= X; j++)
				{
					if(visit[i][j])
					{
						matrix[i][j] = 0;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 회전 수
		matrix = new int[Y+1][X+1];
		// 1. 입력
		for(int i = 1; i <= Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 2. 회전
		for(int i = 0; i < T; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 0 >, 1 <
			int k = Integer.parseInt(st.nextToken()) % X;
			for(int j = x; j <= Y; j += x)
			{
				rotate(j, d, k);
			}
			check();
		}
		// 3. 계산
		for(int i = 1; i <= Y; i++)
		{
			for(int j = 1; j <= X; j++)
			{
				result += matrix[i][j];
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
