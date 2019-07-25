package D7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D7 {
	static int matrix[][];
	static final int MaxV = 100;
	static int T = 10; // 테스트 케이스 갯수
	static int t_num;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		while(T-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t_num = Integer.parseInt(st.nextToken()); // 출력용 테스트 케이스
			matrix = new int[MaxV][MaxV];
			
			int sum = 0;
			for(int i = 0; i < MaxV; i++)
			{
				st = new StringTokenizer(br.readLine() , " ");
				for(int j = 0; j < MaxV; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken()); // 배열에 저장
					sum += matrix[i][j];
				}
				// 가로 로직
				result = Math.max(sum, result); // 최대값 저장
				sum = 0;
			}
			
			sum = 0;
			for(int i = 0; i < MaxV; i++)
			{
				for(int j = 0; j < MaxV; j++)
				{
					sum += matrix[j][i];
				}
				// 세로 로직
				result = Math.max(sum, result);
				sum = 0;
			}
			
			for(int i = 0; i < MaxV; i++)
			{
				for(int j = 0; j < MaxV; j++)
				{
					if(i==j)
					{
						sum += matrix[i][j];
					}
					else
					{
						continue;
					}
						
				}
				// 대각선 1로직
				result = Math.max(sum, result);
				sum = 0;
			}
			
			sum = 0;
			for(int i = 0; i < MaxV; i++)
			{
				for(int j = MaxV-i-1; j > 0; j--)
				{
					if(i+j == MaxV - 1)
					{
						sum += matrix[i][j];
						break;
					}
					else
					{
						continue;
					}
						
				}
				// 대각선 2로직
				result = Math.max(sum, result);
			}

			System.out.printf("#%d %d\n" , t_num, result);
			result = 0;
			
		}
		br.close();
	}
}
