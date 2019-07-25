package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D5 {
	static final int MaxV = 9;
	static Set<Integer> set;
	static int matrix[][];
	
	// 1. 가로
	static int solve1() {
		for(int i = 0; i < MaxV; i++) 
		{
			for(int j = 0; j < MaxV; j++)
			{
				set.add(matrix[i][j]);
			}
			
			if(set.size() != MaxV)
			{
				set.clear();
				return 0;
			}
			else 
			{
				set.clear();
				continue;
			}
		}
		
		set.clear();
		return 1;
	}
	
	// 2. 세로
	static int solve2() {
		for(int i = 0; i < MaxV; i++) 
		{
			for(int j = 0; j < MaxV; j++)
			{
				set.add(matrix[j][i]);
			}
			if(set.size() != MaxV)
			{
				set.clear();
				return 0;
			}
			else {
				set.clear();
				continue;
			}
		}
		set.clear();
		return 1;
	}	
	
	// 3. 구역 0 1 2 || 3 4 5 || 6 7 8
	static int solve3() {
		// k : 0 3 6
		for(int k = 0; k < MaxV; k += MaxV/3)
		{
			// i : 0 1 2 || 3 4 5 || 6 7 8
			for(int i = k; i < k + MaxV / 3; i++) 
			{
				// j : 0 1 2 || 3 4 5 || 6 7 8
				for(int j = k; j < k + MaxV / 3; j++)
				{
					set.add(matrix[j][i]);
				}
				
			}
			
			if(set.size() != MaxV)
			{
				set.clear();
				return 0;
			}
			else {
				set.clear();
				continue;
			}
		}
		set.clear();
		return 1;
	}	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		while(T-- > 0) 
		{
			matrix = new int[MaxV][MaxV];
			set = new HashSet<Integer>();
			
			for(int i=0; i < MaxV; i++) 
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j < MaxV; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}			
			System.out.printf("#%d %d\n",++t_num, (solve1() * solve2() * solve3()));
		}
		br.close();
	}
}
