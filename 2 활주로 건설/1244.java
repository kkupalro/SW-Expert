package D12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D12 {
	static char matrix[];
	static int number;
	static boolean visit[][];
	static void dfs(int num, int count) {
		if(count == 0)
		{
			number = Math.max(toint(matrix), number);
			return;
		}

		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = i; j < matrix.length; j++)
			{
				if(i == j) continue;
				swap(i,j);
				num = toint(matrix);
				if(!visit[num][count])
				{
					visit[num][count] = true;
					dfs(num, count-1);
				}
				swap(i,j);
			}
		}
	}
	static void swap(int max, int min) {
		char temp = '-';
		temp = matrix[max];
		matrix[max] = matrix[min];
		matrix[min] = temp;
	}
	static int toint(char array[]) {
		int toint = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <matrix.length; i++)
		{
			sb.append(Character.toString(matrix[i]));
		}
		toint = Integer.parseInt(sb.toString());
		sb.setLength(0);
		return toint;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0; // 출력용 번호
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			StringBuffer stb = new StringBuffer(st.nextToken()); // 숫자판의 정보
			int C = Integer.parseInt(st.nextToken()); // 정보 교환 횟
			matrix = new char[stb.length()];
			visit = new boolean[999999][C+1];
			number = Integer.parseInt(stb.toString()); // 결과 값
			for(int i = 0; i < stb.length(); i++)
			{
				matrix[i] = stb.charAt(i);
			}
			stb.setLength(0);
			dfs(number, C);
			System.out.printf("#%d %d\n", ++t_num, number);
		}
		br.close();

	}

}
