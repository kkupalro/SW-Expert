package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int matrix[][] = new int[21][21];
	static boolean map[][];
	static int P[];
	static void print(int a[][]) {
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve(int y, int x, int d1, int d2) {
		map = new boolean[21][21];
		P = new int[5];
		// 경계선 (5번 선거구)
		for(int i = 0; i <= d1; i++)
		{
			map[y + i][x - i] = true;
			map[y + d2 + i][x + d2 - i] = true;
			P[4] += matrix[y + i][x - i] + matrix[y + d2 + i][x + d2 - i];
		}
		for(int i = 1; i < d2; i++)
		{
			map[y + i][x + i] = true;
			map[y + d1 + i][x - d1 + i] = true;
			P[4] += matrix[y + i][x + i] + matrix[y + d1 + i][x - d1 + i];
		}
		
		// 경계선 내부
		for(int i = 0; i < d1; i++)
		{
			int j = 0;
			while(!map[y + i + j + 1][x - i])
			{
				map[y + i + j + 1][x - i] = true;
				P[4] += matrix[y + i + j + 1][x - i];
				j += 1;
			}
		}
		for(int i = 1; i < d2; i++)
		{
			int j = 0;
			while(!map[y + i + j + 1][x + i])
			{
				map[y + i + j + 1][x + i] = true;
				P[4] += matrix[y + i + j + 1][x + i];
				j += 1;
			}
		} // end (5번 선거구)
		
		// 나머지 (1, 2, 3, 4 번 선거구)
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				if(map[i][j]) continue;
				
				if(i < y + d1 && j <= x) P[0] += matrix[i][j];
				else if(i <= y + d2 && x < j) P[1] += matrix[i][j];
				else if(y + d1 <= i && j < x - d1 + d2) P[2] += matrix[i][j];
				else if(y + d2 < i && x - d1 + d2 <= j) P[3] += matrix[i][j];
			}
		}
		// 각 선거구 최대 최소 인구수 계산
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 5; i++)
		{
			max = Math.max(max, P[i]);
			min = Math.min(min, P[i]);
		}
		result = Math.min(result, max - min);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N-2; i++)
		{
			for(int j = 2; j <= N-1; j++)
			{
				int d1 = 1, d2 = 1;
				while(true)
				{
					if(i + d1 + d2 <= N && 1 <= j - d1 && j + d2 <= N)
					{
						d2 += 1;
						solve(i, j, d1, d2);
					}
					else
					{
						d1 += 1; d2 = 1;
						if(!(i + d1 + d2 <= N && 1 <= j - d1 && j + d2 <= N))
						{ 
							break;
						}
					}
				}
			}
		}
		//print(matrix);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
