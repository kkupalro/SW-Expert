package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6 {
	static int matrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N * N 배열
			// 배열 생성
			matrix = new int[N][N];
			
			int cnt = 0;
			int x = 0;
			int y = -1;
			int k = 1;
			int solve = N; // 5번 -> 3 2 2 1 1, 7번 -> 4 3 3 2 2 1 1 ,9번-> 5 4 4 3 3 2 2 1 1
			int check = N * N;
			
			while(check > 0)
			{
				for(int i=0; i<solve; i++)
				{
					y = y + k;
					matrix[x][y] = ++cnt;
					check--;
				}
				solve--;
				
				for(int i=0; i<solve; i++)
				{
					x = x + k;
					matrix[x][y] = ++cnt;
					check--;
				}
				k = -k;
			}
			
			System.out.println("#" + ++t_num);
			for(int i=0; i<matrix.length; i++) {
				for(int j=0; j<matrix[i].length; j++)
				{
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		br.close();
	}
}
