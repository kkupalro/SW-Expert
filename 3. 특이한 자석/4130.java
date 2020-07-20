package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2 {
	static int matrix[][];
	static final int row = 4;
	static final int col = 8;
	
	static void solve(int number, int rotate)
	{
		boolean map[] = new boolean[4];
		int rt[] = new int[4];
		int temp = 0;
		if(number == 0)
		{
			map[number] = true;
			if(map[0] && matrix[0][2] != matrix[1][6]) map[1] = true;
			if(map[1] && matrix[1][2] != matrix[2][6]) map[2] = true;
			if(map[2] && matrix[2][2] != matrix[3][6]) map[3] = true;
		}
		else if(number == 1)
		{
			map[number] = true;
			if(matrix[0][2] != matrix[1][6]) map[0] = true;
			if(matrix[1][2] != matrix[2][6]) map[2] = true;
			if(map[2] && (matrix[2][2] != matrix[3][6])) map[3] = true;
		}
		else if(number == 2)
		{
			map[number] = true;
			if(matrix[2][2] != matrix[3][6]) map[3] = true;
			if(matrix[1][2] != matrix[2][6]) map[1] = true;
			if(map[1] && matrix[0][2] != matrix[1][6]) map[0] = true;
		}
		else if(number == 3)
		{
			map[number] = true;
			if(map[3] && (matrix[2][2] != matrix[3][6])) map[2] = true;
			if(map[2] && (matrix[1][2] != matrix[2][6])) map[1] = true;
			if(map[1] && (matrix[0][2] != matrix[1][6])) map[0] = true;
		}
		for(int i =0; i<4; i++)
		{
				if(map[i] && number % 2 == 0)
				{
					if(i % 2 == 0) rt[i] = rotate;
					else if(i % 2 ==1) rt[i] = rotate * -1;
				}
				else if(map[i] && number % 2 == 1)
				{
					if(i % 2 == 1) rt[i] = rotate;
					else if(i % 2 == 0) rt[i] = rotate * -1;
				}
		}
		for(int i = 0; i < row; i++)
		{
			// 1
			if(rt[i] == 1 && map[i])
			{
				temp = matrix[i][7];
				for(int j = 0; j < col-1; j++)
				{
					matrix[i][7-j] = matrix[i][6-j];
				}
				matrix[i][0] = temp;
			}	
			// -1
			else if(rt[i] == -1 && map[i])
			{
				temp = matrix[i][0];
				for(int j = 0; j < col-1; j++)
				{
					matrix[i][j] = matrix[i][j+1];
				}
				matrix[i][7] = temp;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0; // 출렬용 테스트 케이스 변수
		while(T-- > 0)
		{
			matrix = new int[row][col];
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken()); // 자석을 회전시키는 횟수
			for(int i = 0; i < row; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < col; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < K; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int number = Integer.parseInt(st.nextToken());
				int rotate = Integer.parseInt(st.nextToken());
				solve(number-1, rotate);
			}
			int result = (matrix[0][0]==1?1:0) + (matrix[1][0]==1?2:0) + (matrix[2][0]==1?4:0) + (matrix[3][0]==1?8:0);
			System.out.printf("#%d %d\n", ++t_num, result);
		}
		br.close();
	}
}
