package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4 {
	static final int MAX = 100;
	static int matrix[];
	static int result;
	static void solve(int cnt)
	{
		int max = Integer.MIN_VALUE; // 최대값
		int min = Integer.MAX_VALUE; // 최솟값
		int max_idx = 0; // 최대값 인덱스
		int min_idx = 0; // 최솟값 인덱스
		for(int i = 0; i < MAX; i++)
		{
			if(matrix[i] > max)
			{
				max = matrix[i];
				max_idx = i;
			}
			if(matrix[i] < min)
			{
				min = matrix[i];
				min_idx = i;
			}
		}
		if(cnt == 0)
		{
			result = max - min;
			return;
		}
		matrix[min_idx] +=1;
		matrix[max_idx] -=1;
		solve(cnt-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10; // 테스트 케이스 갯수
		int t_num = 0; // 출력용 테스트 케이스
		while(T-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken()); // 덤프 카운트
			st = new StringTokenizer(br.readLine(), " ");
			matrix = new int[MAX];
			for(int i = 0; i < MAX; i++)
			{
				matrix[i] = Integer.parseInt(st.nextToken());
			}
			result = 0;
			solve(count);
			System.out.printf("#%d %d\n", ++t_num, result);
		}
		br.close();
	}
}
