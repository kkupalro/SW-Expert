package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, R, result;
	static int matrix[][] = new int[100][100];
	static int A[];
	static void copy(int a[][], int b[][]) {
		for(int i = 0; i < b.length; i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void solve(int idx) throws IOException {
		if(idx == R)
		{
			return;
		}
		int mid = 0;
		if(A[idx] == 1)
		{
			mid = Y/2; // 6/2 - > 3
			for(int j = 0; j < X; j++)
			{
				for(int i = 0; i < mid; i++)
				{
					matrix[i][j] ^= matrix[Y-i-1][j];
					matrix[Y-i-1][j] ^= matrix[i][j];
					matrix[i][j] ^= matrix[Y-i-1][j];
				}
			}
			solve(idx + 1);
		}
		else if(A[idx] == 2)
		{
			mid = X/2;
			for(int i = 0; i < Y; i++)
			{
				for(int j = 0; j < mid; j++)
				{
					matrix[i][j] ^= matrix[i][X-j-1];
					matrix[i][X-j-1] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i][X-j-1];
				}
			}
			solve(idx + 1);
		}
		else if(A[idx] == 3)
		{
			mid = Y/2;
			int temp[][] = new int[X][Y];
			for(int i = 0; i < X; i++)
			{
				// 0 1 2 3 4 5
				for(int j = 0; j < Y; j++)
				{
					// 0 1 2 3 4 5 6 7
					// 00 -> 70, 01 -> 60 ... 05 ->00
					temp[i][j] = matrix[Y-j-1][i];
				}
			}
			Y ^= X;
			X ^= Y;
			Y ^= X;
			copy(matrix, temp);
			solve(idx + 1);
		}
		else if(A[idx] == 4)
		{
			mid = Y/2;
			int temp[][] = new int[X][Y];
			for(int i = 0; i < X; i++)
			{
				// 0 1 2 3 4 5
				for(int j = 0; j < Y; j++)
				{
					// 0 1 2 3 4 5 6 7
					// 00 -> 07, 01 -> 17 ... 05 ->57
					temp[i][j] = matrix[j][X-i-1];
				}
			}
			Y ^= X;
			X ^= Y;
			Y ^= X;
			copy(matrix, temp);
			solve(idx + 1);
		}
		else
		{
			// 3 3
			int nx = X/2;
			int ny = Y/2;
			int temp[][] = new int[Y][X];
			if(A[idx] == 5)
			{
				for(int i = 0; i < ny; i++)
				{
					// 1
					for(int j = 0; j < nx; j++)
					{
						temp[i][j] = matrix[ny+i][j];
					}
					// 2
					for(int j = nx; j < X; j++)
					{
						temp[i][j] = matrix[i][j-nx];
					}
				}
				for(int i = ny; i < Y; i++)
				{
					// 3
					for(int j = nx; j < X; j++)
					{
						temp[i][j] = matrix[i-ny][j];
					}
					// 4
					for(int j = 0; j < nx; j++)
					{
						temp[i][j] = matrix[i][j+nx];
					}
				}
			}
			else if(A[idx] == 6)
			{
				for(int i = 0; i < ny; i++)
				{
					// 1
					for(int j = 0; j < nx; j++)
					{
						temp[i][j] = matrix[i][j+nx];
					}
					// 2
					for(int j = nx; j < X; j++)
					{
						temp[i][j] = matrix[i+ny][j];
					}
				}
				for(int i = ny; i < Y; i++)
				{
					// 3
					for(int j = nx; j < X; j++)
					{
						temp[i][j] = matrix[i][j-nx];
					}
					// 4
					for(int j = 0; j < nx; j++)
					{
						temp[i][j] = matrix[i-ny][j];
					}
				}
			}
			copy(matrix, temp);
			solve(idx + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<Integer>();
		A = new int[R];
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < R; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			if(list.size() > 0)
			{
				if(num == 1 || num == 2)
				{
					if(num == list.peek())
					{
						list.remove();
						continue;
					}
				}
				else
				{
					if(list.size() >= 3)
					{
						int last = list.size()-1;
						int cnt = 0;
						for(int j = last; j > last - 3; j--)
						{
							if(num == list.get(j))
							{
								cnt++;
							}
						}
						if(cnt == 3)
						{
							list.remove();
							list.remove();
							list.remove();
							continue;
						}
						
					}
				}
			}
			list.add(num);
		}
		// 이부분에서 예를 들어, [1 (2)번, 2 (2)번, 3,4,5,6 (4)번 제자리] 는 원래 자리이므로 연산 횟수 줄이는 로직 구현
		R = list.size();
		if(R > 0)
		{
			A = new int[R];
			for(int i = 0; i < R; i++)
			{
				A[i] = list.get(i);
			}
			solve(0);
		}
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
