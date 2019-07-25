package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2 {
	static int matrix[][];
	static int result;
	static final int dx[] = {-1, 1, 0, 0}; // <-, ->, ^, v 
	static final int dy[] = { 0, 0,-1, 1};
	static int W;
	static int H;
	static int N;
	static void init() {
		// 빈공간 있을 시, 벽돌을 밑으로 떨어뜨림
		for(int x = 0; x < W; x++)
		{
			for(int y = H-1; y >= 0; y--)
			{
				for(int k = y-1; k >= 0; k--)
				{
					if(matrix[y][x] != 0) break;
					if(matrix[k][x] != 0)
					{
						matrix[y][x] = matrix[k][x];
						matrix[k][x] = 0;
						break;
					} // end for k
				} // end for y
			} // end for x
		}
	} // end init
	static void copy(int[][] a, int[][] b){
		for(int i = 0; i < H; i++)
		{
			for(int j = 0; j < W; j++)
			{
				a[i][j] = b[i][j];
			} // end j
		} // end i
	} // end copy
	static void bomb(int y, int x)
	{
		int v = matrix[y][x]; 
		matrix[y][x] = 0;
		for(int m = 1; m < v; m++)
		{
			for(int l = 0; l < 4; l++)
			{
				int nx = x + dx[l] * m;
				int ny = y + dy[l] * m;
				if(nx >= 0 && ny >= 0 && nx < W && ny < H && matrix[ny][nx] != 0)
				{
					bomb(ny, nx);
				}
			} // end l
		} // end m
	} // end bomb
	static void solve(int cnt)
	{
		// 종료 조건
		if(cnt == 0)
		{
			int res = 0;
			for(int i = 0; i < H; i++)
			{
				for(int j = 0; j < W; j++)
				{
					if(matrix[i][j] != 0)
					{
						res++;
					}
				} // end j
			} // end i
			result = Math.min(result, res);
			return;
		} // end end
		// 백트래킹 해야함
		int temp[][] = new int[H][W];
		copy(temp, matrix);
		for(int x = 0; x < W; x++)
		{
			int y = 0;
			while(x >= 0 && x <= W-1 && y >= 0 && y < H-1 && matrix[y][x] == 0)	y++;
			bomb(y, x);
			init();
			solve(cnt-1);
			copy(matrix, temp);
		} // end x
	} // end solve
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
		int t_num = 0; // 출력용 테스트 케이스 번호
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); //  구슬 횟수
			W = Integer.parseInt(st.nextToken()); //  배열 행
			H = Integer.parseInt(st.nextToken()); //  배열 열
			matrix = new int[H][W];
			result = Integer.MAX_VALUE;
			for(int i = 0; i < H; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < W; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				} // end j
			} // end i
			solve(N);
			System.out.printf("#%d %d\n", ++t_num, result);
		} // end T
	}
}
