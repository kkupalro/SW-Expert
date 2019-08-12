import java.io.*;
import java.util.*;

class node {
	int y; int x; int size;
	node(int y, int x, int size)
	{
		this.y = y;
		this.x = x;
		this.size = size;
	}
}
public class Main {
	static int N, M, K; // N by M 행렬, 회전 횟수
	static int result; // 결과 값
	static int matrix[][] = new int[51][51];
	static boolean map[] = new boolean[6]; // 회전 번호 체크 
	static node n[] = new node[6]; // 행, 열, 회전 크기
	static void copy(int[][] a, int [][]b) {
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= M; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void calc() {
		for(int i = 1; i <= N; i++)
		{
			int sum = matrix[i][1];
			for(int j = 2; j <= M; j++)
			{
				sum = sum + matrix[i][j];
			}
			// 행마다 열 값 합산 
			result = Math.min(result, sum);
		}
	}
	static void solve(int y, int x, int size, int cnt) {
		int temp1 = 0;
		int temp2 = 0;
		if(cnt == 0)
		{
			for(int s = 1; s <= size; s++)
			{
				// 시계 방향 회전
				// 1. -> 우
				temp1 = matrix[y-s][x-s];
				temp2 = matrix[y-s][x-s+1];
				matrix[y-s][x-s+1] = temp1;
				for(int j = 2; j <= s+s; j++)
				{
					temp1 = matrix[y-s][x-s+j]; 
					matrix[y-s][x-s+j] = temp2;
					temp2 = temp1;
				}
				// 2. v 하
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y-s+j][x+s];
					matrix[y-s+j][x+s] = temp2;
					temp2 = temp1;
				}
				// 3. <- 좌
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y+s][x+s-j];
					matrix[y+s][x+s-j] = temp2;
					temp2 = temp1;
				}
				
				// 4. ^ 상
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y+s-j][x-s];
					matrix[y+s-j][x-s] = temp2;
					temp2 = temp1;
				}
			}
			calc();
			return;
		}
		else {
			int tmp[][] = new int[51][51];
			for(int s = 1; s <= size; s++)
			{
				// 시계 방향 회전
				// 1. -> 우
				temp1 = matrix[y-s][x-s];
				temp2 = matrix[y-s][x-s+1];
				matrix[y-s][x-s+1] = temp1;
				for(int j = 2; j <= s+s; j++)
				{
					temp1 = matrix[y-s][x-s+j]; 
					matrix[y-s][x-s+j] = temp2;
					temp2 = temp1;
				}
				// 2. v 하
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y-s+j][x+s];
					matrix[y-s+j][x+s] = temp2;
					temp2 = temp1;
				}
				// 3. <- 좌
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y+s][x+s-j];
					matrix[y+s][x+s-j] = temp2;
					temp2 = temp1;
				}
				
				// 4. ^ 상
				for(int j = 1; j <= s+s; j++)
				{
					temp1 = matrix[y+s-j][x-s];
					matrix[y+s-j][x-s] = temp2;
					temp2 = temp1;
				}
			}
			for(int i = 0; i < K; i++)
			{
				if(map[i]) continue;
				copy(tmp, matrix);
				map[i] = true;
				solve(n[i].y, n[i].x, n[i].size, cnt-1);
				map[i] = false;
				copy(matrix, tmp);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 배열 행
		M = Integer.parseInt(st.nextToken()); // 배열 열
		K = Integer.parseInt(st.nextToken()); // 회전연산 힛수
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			// 행 , 열 , 회전 크기;
			n[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
        result = 5000;
        int temp[][] = new int[51][51];
		for(int i = 0; i < K; i++)
		{
			map[i] = true;
			copy(temp, matrix);
			solve(n[i].y, n[i].x, n[i].size, K-1);
			copy(matrix, temp);
			map[i] = false;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
