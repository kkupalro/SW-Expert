package TEST;

import java.io.*;

public class Main {
	static int N, y, x, ny, nx, data;
	static int matrix[][] = new int[301][301];
	static int map[][] = new int[301][301];
	static void check(int a[][], int n)
	{
		int ans1 = 0; int ans2 = 0;
		for(int k = 0; k < N; k++)
		{
			ans1 = 0; ans2 = 0;
			for(int i = 0; i < N; i++)
			{
				ans1 += matrix[k][i];
			}
			for(int i = 0; i < N; i++)
			{
				ans2 += matrix[i][k];
			}
			System.out.println(ans1 + " " + ans2);
		}
	}
	static void print(int b[][]) {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.print(b[i][j] + " ");
			}
			if(i != b.length-1)
			{
				System.out.println();
			}
		}
	}
	static void make(int row, int col) {
		// 0 0 = (0~4) (0~4)
		// 0 1 = (4)   (4~8)
		// 1 0 = (4~8) (0~4)
		// 1 1 = (4~8) (4~8)
		for(int i = 0, j = 0; i < 4; i++, j++)
		{
			map[(row*4)+i][(col*4)+j] = 1;
			map[(row*4)+ 4 -i-1][(col*4)+j] = 1;
		}
	}
	static void make4(int n, int c) {
		int tmp = 0;
		int s_idx = n-1; // 0
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < c; j++)
			{
				tmp = matrix[j][i];
				matrix[j][i] = matrix[j+c][i];
				matrix[j+c][i] = tmp;
			}
		}
		for(int i = 0; i < n-1; i++)
		{
			for(int j = 0; j < c; j++)
			{
				tmp = matrix[j][N-1-i];
				matrix[j][N-1-i] = matrix[j+c][N-1-i];
				matrix[j+c][N-1-i] = tmp;
			}
		}
		for(int i = s_idx; i < s_idx + 2; i++)
		{
			tmp = matrix[c/2][i];
			matrix[c/2][i] = matrix[c/2+c][i];
			matrix[c/2+c][i] = tmp;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N % 2 == 1)
		{
			data = 1;
			matrix[0][N/2] = data;
			y = 0; x = N/2;
			while(data++ < N*N)
			{
				ny = (y==0)?N-1:y-1;
				nx = (x==N-1)?0:x+1;
				if(matrix[ny][nx] == 0)
				{
					matrix[ny][nx] = data;
					y = ny;
					x = nx;
				}
				else if(matrix[ny][nx] != 0)
				{
					for(int i = y; i < N; i++)
					{
						if(matrix[i][x] == 0)
						{
							matrix[i][x] = data;
							y = i;
							break;
						}
					}
				}
			}
		}
		else if(N % 2 == 0) // 짝수
		{
			if(N % 4 == 0)
			{
				// 순서대로 채움
				// 이부분에서 문제가 있엇음
				data = 1; // 데이터 1로 초기화
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						matrix[i][j] = data++; // 후위 증가
					}
				}
				int size = N / 4;
				for(int r = 0; r < size; r++)
				{
					for(int c = 0; c < size; c++)
					{
						make(r, c);
					}
				}
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						data--;
						if(map[i][j]==0)
						{
							matrix[i][j] = data;
						}
					}
				}
			}
			// 4의 배수가 아닐 경우 -> 6의 배수
			else if(N % 4 != 0)
			{
				// 왼쪽 위
				int n = (N-2)/4;
				int r = 0;
				int c = (2 * n) + 1;
				data = 1;
				matrix[r][c/2] = data; // 시작 지점
				y = r; x = c/2;
				while(data <= c * c)
				{
					data++;
					ny = (y==0)?c-1:y-1;
					nx = (x==c-1)?0:x+1;
					if(matrix[ny][nx] == 0)
					{
						matrix[ny][nx] = data;
						y = ny;
						x = nx;
					}
					else if(matrix[ny][nx] != 0)
					{
						for(int i = y; i < N; i++)
						{
							if(matrix[i][x] == 0)
							{
								matrix[i][x] = data;
								y = i;
								break;
							}
						}
					}
				}
				// 오른쪽 아래
				r = c;
				matrix[r][c+n] = data; // 시작 지점
				y = r; x = c + n;
				// (n ~ 2n)
				while(data <= c * c * 2)
				{
					data++;
					ny = (y==c)?N-1:y-1;
					nx = (x==N-1)?c:x+1;
					if(matrix[ny][nx] == 0)
					{
						matrix[ny][nx] = data;
						y = ny;
						x = nx;
					}
					else if(matrix[ny][nx] != 0)
					{
						for(int i = y; i < N; i++)
						{
							if(matrix[i][x] == 0)
							{
								matrix[i][x] = data;
								y = i;
								break;
							}
						}
					}
				}
				// 오른쪽 위
				r = 0;
				matrix[0][c+n] = data; // 시작 지점
				y = r; x = c + n;
				// (n ~ 2n)
				while(data <= c * c * 3)
				{
					data++;
					ny = (y==0)?c-1:y-1;
					nx = (x==N-1)?c:x+1;
					if(matrix[ny][nx] == 0)
					{
						matrix[ny][nx] = data;
						y = ny;
						x = nx;
					}
					else if(matrix[ny][nx] != 0)
					{
						for(int i = y; i < N; i++)
						{
							if(matrix[i][x] == 0)
							{
								matrix[i][x] = data;
								y = i;
								break;
							}
						}
					}
				}
				// 왼쪽 아래
				r = c;
				matrix[c][c/2] = data; // 시작 지점
				y = r; x = c/2;
				// (n ~ 2n)
				while(data <= c * c * 4)
				{
					data++;
					ny = (y==c)?N-1:y-1;
					nx = (x==c-1)?0:x+1;
					if(matrix[ny][nx] == 0)
					{
						matrix[ny][nx] = data;
						y = ny;
						x = nx;
					}
					else if(matrix[ny][nx] != 0)
					{
						for(int i = y; i < N; i++)
						{
							if(matrix[i][x] == 0)
							{
								matrix[i][x] = data;
								y = i;
								break;
							}
						}
					}
				}
				make4(n, c);
			}
			// end else
		}
		// 출력 부문
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}