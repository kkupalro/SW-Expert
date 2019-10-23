package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int T, M, N, K;
	static int matrix[][];
	static boolean visit[][];
	static int result;
	static final int dy[] = {-1, 0, 1, 0}; // <0. ^╩С>, <1. ->©Л>, <2. v го>, <3. <-аб>
	static final int dx[] = { 0, 1, 0,-1};
	static void print() {
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("====================");
	}
	static void solve(int y, int x) {
		int nx = 0;
		int ny = 0;
		for(int l = 0; l < 4; l++)
		{
			ny = dy[l] + y;
			nx = dx[l] + x;
			if(nx < 0 || nx > M-1 || ny < 0 || ny > N-1 || visit[ny][nx]) continue;
			if(matrix[ny][nx] == 0) continue;
			visit[ny][nx] = true;
			solve(ny, nx);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // X
			N = Integer.parseInt(st.nextToken()); // Y
			K = Integer.parseInt(st.nextToken());
			matrix = new int[N][M];
			visit = new boolean[N][M];
			result = 0;
			for(int i = 0; i < K; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				matrix[Y][X] = 1;
			}
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < M; j++)
				{
					if(matrix[i][j] == 1 && !visit[i][j])
					{
						visit[i][j] = true;
						solve(i,j);
						result++;
					}
				}
			}
			bw.write(result +"\n");
			bw.flush();
		}
		bw.close();
	}

}
