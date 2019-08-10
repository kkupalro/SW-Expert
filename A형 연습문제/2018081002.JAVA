package T2;

import java.io.*;
import java.util.*;

class node {
	int x; int y; int size;
	node(int x, int y, int size)
	{
		this.x = x;
		this.y = y;
		this.size = size;
	}
}

public class Main {
	static int T, N, K; // 테스트 케이스, N by N 행렬, 마법 횟수
	static int result = Integer.MAX_VALUE; // 결과 값
	static int matrix[][];
	static int temp[][];
	static boolean map[][]; // 같은 Y X 일때 마법 불가능 
	static node n[]; // 마법 좌표, 범위
	static void copy(int[][] a, int [][]b) {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void calc() {
		for(int i = 0; i < N; i++)
		{
			int sum = matrix[i][0];
			for(int j = 1; j < N; j++)
			{
				sum += matrix[i][j];
			}
			// 행마다 열 값 합산 
			result = Math.min(result, sum);
		}
	}
	static void solve(int x, int y, int size, int cnt) {
		calc();
		if(cnt == K)
		{
			// 마법횟수 K번일시 일시 종료
			return;
		}
		int temp1 = 0;
		int temp2 = 0;
		for(int s = 1; s <= size; s++)
		{
			// 시계 방향 회전
			// 1. -> 우
			for(int j = 1; j <= s*2; j++)
			{
				if(j == 1)
				{
					temp1 = matrix[y-s][x-s];
					temp2 = matrix[y-s][x-s+j];
					matrix[y-s][x-s+j] = temp1;
				}
				else {
					temp1 = matrix[y-s][x-s+j]; 
					matrix[y-s][x-s+j] = temp2;
					temp2 = temp1;
				}
			}
			// 2. v 하
			for(int j = 1; j <= s*2; j++)
			{
				temp1 = matrix[y-s+j][x+s];
				matrix[y-s+j][x+s] = temp2;
				temp2 = temp1;
			}
			// 3. <- 좌
			for(int j = 1; j <= s*2; j++)
			{
				temp1 = matrix[y+s][x+s-j];
				matrix[y+s][x+s-j] = temp2;
				temp2 = temp1;
			}
			
			// 4. ^ 상
			for(int j = 1; j <= s*2; j++)
			{
				temp1 = matrix[y+s-j][x-s];
				matrix[y+s-j][x-s] = temp2;
				temp2 = temp1;
			}
		}
		calc();
		copy(temp, matrix);
		// 재귀 호출
		for(int i = 0; i < K; i++)
		{
			int col = n[i].x;
			int row = n[i].y;
			int len = n[i].size;
			// 이미 방문된 마법 좌표일시 마법 불가능 
			if(map[row][col]) continue;
			map[row][col] = true;
			solve(col, row, len, cnt + 1);
			copy(matrix, temp);
			map[row][col] = false;			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		int t_num = 0; // 출력용 테스트 케이스 번호
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // N by N 배열
			K = Integer.parseInt(st.nextToken()); // 마법 횟수
			matrix = new int[N][N];
			map = new boolean[N][N];
			temp = new int[N][N];
			n = new node[N];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < K; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				n[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				// x, y, size;
			}
			for(int i = 0; i < K; i++)
			{
				copy(temp, matrix);
				map[n[i].y][n[i].x] = true;
				solve(n[i].x, n[i].y, n[i].size, 0);
				map[n[i].y][n[i].x] = false;
				copy(matrix, temp);
			}
			bw.write("#" + ++t_num + " " + result);
			bw.flush();
			result = Integer.MAX_VALUE;
		}
		bw.close();
	}
}
