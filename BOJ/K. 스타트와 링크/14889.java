package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int count;
	static boolean visit[] = new boolean[20];
	static int matrix[][] = new int[20][20];
	static int R[][] = new int[2][10];
	static int min = Integer.MAX_VALUE;
	static void solve(int y, int cnt) {
		if(cnt == count)
		{
			// 기저 사례
			int A_idx = 0; int B_idx = 0; int a = 0; int b = 0;
			for(int i = 0; i < N; i++)
			{
				if(visit[i])
				{
					R[0][A_idx++] = i; 
				}
				else
				{
					R[1][B_idx++] = i;
				}
			}
			for(int i = 0; i < count; i++)
			{
				for(int j = 0; j < count; j++)
				{
					if(i == j) continue;
					a += matrix[R[0][i]][R[0][j]];
					b += matrix[R[1][i]][R[1][j]];
				}
			}
			min = Math.min(min, Math.abs(a-b));
			return;
		}
		// i를 0부터 진행해서 시간초과
		// (1, 2) 결과값과 (2, 1) 결과 값이 같으므로 현재 행값 보다 큰수부터 탐색함.
		for(int i = y+1; i < N; i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			solve(i, cnt+1);
			visit[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		count = N/2;
		matrix = new int[N][N];
		visit = new boolean[N];
		R = new int[2][count];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			solve(i, 1);
			visit[i] = false;
		}
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}
}