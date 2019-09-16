package TEST;

import java.io.*;

public class Main {
	static int N, y, x, ny, nx, data;
	static int matrix[][] = new int[301][301]; // 마방진 행렬
	static int map[][] = new int[301][301]; // (4의 배수의 짝수 마방진의 경우) 대각선 채우기시 사용되는 행렬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N % 2 == 1) // [홀수 마방진]
		{
			/*
			 * (1) 0행, N/2 열에 1을 채움.
			 * (2) N * N번 반복함 -> 현재위치의 오른쪽 위 검사
			 * (3) (0일 경우) 숫자가 커지도록 채움
			 * (4) (0이 아닐 경우) 탐색 전 위치의 아래값에 숫자가 커지도록 채움
			 */
			data = 1;
			matrix[0][N/2] = data; // (1)
			y = 0; x = N/2;
			// (2~4)
			while(data++ < N*N)
			{
				ny = (y==0)?N-1:y-1; // 0행 에서 내려갈 경우, 최대 행값에서 검사
				nx = (x==N-1)?0:x+1; // 최대 열값일 경우, 0열에서 검사
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
		// end [홀수 마방진]
		else if(N % 2 == 0) // [짝수 마방진]
		{
			if(N % 4 == 0)
			{
				/*
				 *  [4의 배수 짝수 마방진]
				 *  (1) matrix 행렬에 정방향으로 왼쪽 위부터 숫자가 커지도록 채움
				 *  (2) map 행렬에 대각선(\, /)을 1로 채움
				 *  (3) 정방향으로 왼쪽 위부터 끝까지 탐색 -> 만약 map값이 0일 경우 matrix에 숫자가 작아지도록 채움 
				 */
				// (1)
				data = 1; // 데이터 1로 초기화 <- 이부분에서 문제가 있어서 실패함 
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						matrix[i][j] = data++; // 후위 증가
					}
				}
				// (2)
				int size = N / 4;
				for(int r = 0; r < size; r++)
				{
					for(int c = 0; c < size; c++)
					{
						// (2)
						make(r, c);
					}
				}
				// (3)
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
			// end [4의 배수 짝수 마방진]
			else if(N % 4 != 0)
			{
				/*
				 *  [4의 배수가 아닌 짝수 마방진] n = (N-2)/4
				 *  (1) 네 개의 홀수 마방진으로 영역을 나눔
				 *      ex) [1] [3]
				 *          [4] [2]
				 *  (2) [1],[2],[3],[4] 영역에 각각 홀수 마방진을 구하는 로직을 적용
				 *  (3) [1]과 [4]의 가장 왼쪽에서 (0 ~ n)개의 세로줄을 서로 교환
				 *  (4) [3]과 [2]의 가장 오른쪽에서 (0 ~ n-1)개의 세로줄을 교환
				 *  (5) [1]의 (정가운데)행(n)열값과 [4]의 (정가운데)행(n)열값을 교환
				 *  (6) [1]의 (정가운데)행(n+1)열값과 [4]의 (정가운데)행(n+1)열값을 교환
				 */  
				// (1 ~ 2)
				// [1]
				int n = (N-2)/4;
				int r = 0;
				int c = (2 * n) + 1;
				data = 1;
				matrix[r][c/2] = data;
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
				} // end [1]
				// [2]
				r = c;
				matrix[r][c+n] = data;
				y = r; x = c + n;
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
				} // end [2]
				// [3]
				r = 0;
				matrix[0][c+n] = data;
				y = r; x = c + n;
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
				} // end [3]
				// [4]
				r = c;
				matrix[c][c/2] = data;
				y = r; x = c/2;
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
				} // end [4]
				// (3 ~ 6)
				make4(n, c);
			} 
			// end [4의 배수가아닌 짝수 마방진]
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
	static void make(int row, int col) {
		for(int i = 0, j = 0; i < 4; i++, j++)
		{
			map[(row*4)+i][(col*4)+j] = 1;
			map[(row*4)+ 4 -i-1][(col*4)+j] = 1;
		}
	}
	static void make4(int n, int c) {
		int tmp = 0;
		int s_idx = n-1;
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
}
