package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6 {
	static int result;
	static int matrix[][];
	static boolean map[];
	static int N;
	static void solve(int y, int cnt)
	{
		if(result < cnt)
		{
			result = cnt;
		}
		map[y] = true;
		for(int i = 0; i < N; i++)
		{
			if(matrix[y][i]==1 && !map[i]) {
				solve(i, cnt + 1);
			}
		}
		map[y] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			result = 0;
			matrix = new int[N][N];
			map = new boolean[N];
			for(int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				matrix[a-1][b-1] = 1;
				matrix[b-1][a-1] = 1;
			}
			for(int i=0; i < N; i++)
			{
				solve(i, 1);
			}
			System.out.printf("#%d %d\n", ++t_num, result);
		}
		br.close();
	}
}
