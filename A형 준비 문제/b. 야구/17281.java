package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int score = 0;
	static int matrix[][];
	static boolean map[] = new boolean[9];
	static int ground[]; 
	//     2
	//  3  X  1
	//    0(H)
	static int hit() {
		int score = ground[3];
		ground[3] = ground[2];
		ground[2] = ground[1];
		ground[1] = 1;
		return score;
	}
	static int two_hit() {
		int score = ground[3] + ground[2];
		ground[3] = ground[1];
		ground[2] = 1;
		ground[1] = 0;
		ground[0] = 0;
		return score;
	}
	static int three_hit() {
		int score = ground[3] + ground[2] + ground[1];
		ground[3] = 1;
		ground[2] = 0;
		ground[1] = 0;
		ground[0] = 0;
		return score;
	}
	static int homerun() {
		int score = ground[3] + ground[2] + ground[1] + 1;
		ground[3] = 0;
		ground[2] = 0;
		ground[1] = 0;
		ground[0] = 0;
		return score;
	}
	static void play(String s) {
		int num = 0; // 점수
		int idx = 0; // 현재 선수
		int cur = s.charAt(idx) - '0'; // 현재 선수  역량
		for(int i = 0; i < N; i++)
		{
			int out = 0;
			ground = new int[4];
			while(out < 3)
			{
				if(matrix[i][cur] == 0)
				{
					// 아웃
					out++;
				}
				else if(matrix[i][cur] == 1)
				{
					num += hit();
				}
				else if(matrix[i][cur] == 2)
				{
					num += two_hit();
				}
				else if(matrix[i][cur] == 3)
				{
					num += three_hit();
				}
				else if(matrix[i][cur] == 4)
				{
					num += homerun();	
				}
				idx = (idx==8)?0:idx+1;
				cur = s.charAt(idx) - '0';
			}
		}
		score = Math.max(score, num);
	}
	static void solve(int idx, int cnt, String s) {
		// 기저 조건 : 9명의 선수 조합 완료
		if(cnt == 9)
		{
			play(s);
			return;
		}
		// 4번 타자는 무조건 1번선수
		if(cnt == 3)
		{
			map[0] = true;
			solve(0, cnt+1, s + 0);
			map[0] = false;
			return;
		}
		for(int i = 1; i < 9; i++)
		{
			if(map[i]) continue;
			map[i] = true;
			solve(i, cnt+1, s + i);
			map[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][9];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		 *  Index : |1|2|3|4|5|6|7|8|9|
		 *  Player: |0|1,2,3,4,5,6,7,8|
		 */
		for(int i = 1; i < 9; i++)
		{
			if(map[i]) continue;
			map[i] = true;
			solve(i, 1, String.valueOf(i));
			map[i] = false;
		}
		bw.write(score + "\n");
		bw.flush();
		bw.close();
	}
}
