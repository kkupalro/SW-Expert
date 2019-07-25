package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3 {
	static int matrix[][];
	static int map[][];
	static int N;
	static int result = 0;
	
	static void solve() {
		int cnt = 0;
		for(int i = 0; i < N/2; i++)
		{
			cnt = i; // 0, 1, 2..
			map[i][N/2] = 1;
			int k = 1;
			while(cnt-- > 0)
			{
				map[i][N/2 -k] = 1;
				map[i][N/2 +k] = 1;
				k++;
			}
		}
		for(int i = N/2; i < N; i++)
		{
			cnt = ((N-1-i)); // 2, 1, 0..
			map[i][N/2] = 1;
			int k = 1;
			while(cnt-- > 0)
			{
				map[i][N/2 -k] = 1;
				map[i][N/2 +k] = 1;
				k++;
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[i][j] == 1)
				{
					result = result + matrix[i][j];
				}
					
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
		int t_num = 0; // 출력용 테스트 케이스
		while(T-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // N * N
			matrix = new int[N][N];
			map = new int[N][N];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				StringBuffer sb = new StringBuffer(st.nextToken());
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = sb.charAt(j) - '0';
				}
				sb.setLength(0);
			}
			solve();
			System.out.printf("#%d %d\n", ++t_num, result);
			result = 0;
		}
		br.close();

	}

}
