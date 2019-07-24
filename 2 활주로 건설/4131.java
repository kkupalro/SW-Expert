package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2 {
	static int result;
	static int matrix[][];
	static int temp[];
	static int N, X;
	static boolean solve(int start, int type)
	{
		temp = new int[N];
		// 0. 가로
		if(type == 0)
		{
			for(int i=0; i<N; i++)
			{
				temp[i] = matrix[start][i];
			}
		}
		// 1. 세로
		else if(type == 1)
		{
			for(int i=0; i<N; i++)
			{
				temp[i] = matrix[i][start];
			}
		}
		
		boolean check[] = new boolean[20]; // 활주로 건설
		for(int i=0; i<N; i++)
		{
			// 내리막길
			if(i != N-1 && temp[i] == temp[i+1] +1)
			{
				int count = 0;
				for(int j = 1; j<=X; j++)
				{
					if(i+j >= N)
					{
						break;
					}
					if(temp[i+1] == temp[i+j] && !check[i+1])
					{
						count = count + 1;
					}
				}
				if(count != X) {
					return false;
				}
				else
				{
					for(int j = 1; j<=X; j++)
					{
						check[i+j] = true;
					}
				}
			}
			// 2칸 내려가야 할시 활주로 건설 불가
			else if(i != N-1 && temp[i] > temp[i+1] + 1)
			{
				return false;
			}
			// 오르막길
			if(i != 0 && temp[i] == temp[i-1] + 1)
			{
				int count = 0;
				for(int j = 1; j <= X; j++)
				{
					if(i-j < 0)
					{
						break;
					}
					if(temp[i-1] == temp[i-j] && !check[i-j])
					{
						count = count + 1;
					}
				}
				if(count != X) return false;
				else
				{
					for(int j = 1; j <= X; j++)
					{
						check[i-j] = true;
					}
				}
			}
			// 2칸 올라가야 할시 활주로 건설 불가
			else if(i != 0 && temp[i] > temp[i-1] + 1)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
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
				result += (solve(i, 0)?1:0) + (solve(i, 1)?1:0);
			}
			
			System.out.printf("#%d %d\n", ++t_num, result);
			result = 0;
		}
		br.close();
	}
}
