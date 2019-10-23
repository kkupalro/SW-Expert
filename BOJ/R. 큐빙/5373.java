package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int T, N;
	static char TEMP[] = new char[3];
	static char cube[][][];
	static final char C[] = {'w', 'y', 'r', 'o', 'g', 'b'};
	static void print(char a[][][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				for(int k = 0; k < a[i][j].length; k++)
				{
					System.out.print(a[i][j][k] + " ");
				}
				System.out.println();
			}
			if(i !=  a.length-1)
			{
				System.out.println("=====");
			}
		}
		System.out.println("===========================");
	}
	static void init(int idx, char c) {
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				cube[idx][i][j] = c;
			}
		}
	}
	static void self_rotate(int idx) {
		char tmp[][] = {{cube[idx][2][0], cube[idx][1][0], cube[idx][0][0]},
				{cube[idx][2][1], cube[idx][1][1], cube[idx][0][1]},
				{cube[idx][2][2], cube[idx][1][2], cube[idx][0][2]}};
		for(int i = 0; i< 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				cube[idx][i][j] = tmp[i][j];
			}				
		}
	}
	static void left(char c) {
		right(c);
		right(c);
		right(c);
	}
	static void right(char c) {
		if(c == 'U')
		{
			// 0. À­ ¸é
			self_rotate(0);
			// 2. 4 2 5 3 -> 2 5 3 4 (O)
			TEMP[0] = cube[2][0][0];
			TEMP[1] = cube[2][0][1];
			TEMP[2] = cube[2][0][2];
			cube[2][0][0] = cube[5][0][0];
			cube[2][0][1] = cube[5][0][1];
			cube[2][0][2] = cube[5][0][2];
			cube[5][0][0] = cube[3][0][0];
			cube[5][0][1] = cube[3][0][1];
			cube[5][0][2] = cube[3][0][2];
			cube[3][0][0] = cube[4][0][0];
			cube[3][0][1] = cube[4][0][1];
			cube[3][0][2] = cube[4][0][2];
			cube[4][0][0] = TEMP[0];
			cube[4][0][1] = TEMP[1];
			cube[4][0][2] = TEMP[2];
		}
		else if(c == 'D')
		{
			// 1. ¾Æ·§ ¸é
			self_rotate(1);
			// 2. 4 2 5 3  -> 3 4 2 5(O)
			TEMP[0] = cube[2][2][0];
			TEMP[1] = cube[2][2][1];
			TEMP[2] = cube[2][2][2];
			cube[2][2][0] = cube[4][2][0];
			cube[2][2][1] = cube[4][2][1];
			cube[2][2][2] = cube[4][2][2];
			cube[4][2][0] = cube[3][2][0];
			cube[4][2][1] = cube[3][2][1];
			cube[4][2][2] = cube[3][2][2];
			cube[3][2][0] = cube[5][2][0];
			cube[3][2][1] = cube[5][2][1];
			cube[3][2][2] = cube[5][2][2];
			cube[5][2][0] = TEMP[0];
			cube[5][2][1] = TEMP[1];
			cube[5][2][2] = TEMP[2];
		}
		else if(c == 'F')
		{
			// 2. ¾Õ ¸é
			self_rotate(2);
			// 2. 4 0 5 1 -> 1 4 0 5(O)
			TEMP[0] = cube[0][2][0];
			TEMP[1] = cube[0][2][1];
			TEMP[2] = cube[0][2][2];
			cube[0][2][0] = cube[4][2][2];
			cube[0][2][1] = cube[4][1][2];
			cube[0][2][2] = cube[4][0][2];
			cube[4][2][2] = cube[1][2][0];
			cube[4][1][2] = cube[1][2][1];
			cube[4][0][2] = cube[1][2][2];
			cube[1][2][0] = cube[5][0][0];
			cube[1][2][1] = cube[5][1][0];
			cube[1][2][2] = cube[5][2][0];
			cube[5][0][0] = TEMP[0];
			cube[5][1][0] = TEMP[1];
			cube[5][2][0] = TEMP[2];
		}	
		else if(c == 'B')
		{
			// 3. µÚ
			self_rotate(3);
			// 2. 4 1 5 0  -> 0 4 1 5(O)
			TEMP[0] = cube[0][0][2];
			TEMP[1] = cube[0][0][1];
			TEMP[2] = cube[0][0][0];
			cube[0][0][2] = cube[5][2][2];
			cube[0][0][1] = cube[5][1][2];
			cube[0][0][0] = cube[5][0][2];
			cube[5][2][2] = cube[1][0][2];
			cube[5][1][2] = cube[1][0][1];
			cube[5][0][2] = cube[1][0][0];
			cube[1][0][2] = cube[4][0][0];
			cube[1][0][1] = cube[4][1][0];
			cube[1][0][0] = cube[4][2][0];
			cube[4][0][0] = TEMP[0];
			cube[4][1][0] = TEMP[1];
			cube[4][2][0] = TEMP[2];
		}	
		else if(c == 'L')
		{
			// 4. ¿ÞÂÊ
			self_rotate(4);
			TEMP[0] = cube[2][0][0];
			TEMP[1] = cube[2][1][0];
			TEMP[2] = cube[2][2][0];
			cube[2][0][0] = cube[0][0][0];
			cube[2][1][0] = cube[0][1][0];
			cube[2][2][0] = cube[0][2][0];
			cube[0][0][0] = cube[3][2][2];
			cube[0][1][0] = cube[3][1][2];
			cube[0][2][0] = cube[3][0][2];
			cube[3][2][2] = cube[1][2][2];
			cube[3][1][2] = cube[1][1][2];
			cube[3][0][2] = cube[1][0][2];
			cube[1][2][2] = TEMP[0];
			cube[1][1][2] = TEMP[1];
			cube[1][0][2] = TEMP[2];
		}
		else if(c == 'R')
		{
			// 5. ¿À¸¥ÂÊ
			self_rotate(5);
			// 2. 1 2 0 3 -> 3 1 2 0(O)
			TEMP[0] = cube[0][0][2];
			TEMP[1] = cube[0][1][2];
			TEMP[2] = cube[0][2][2];
			cube[0][0][2] = cube[2][0][2];
			cube[0][1][2] = cube[2][1][2];
			cube[0][2][2] = cube[2][2][2];
			cube[2][0][2] = cube[1][2][0];
			cube[2][1][2] = cube[1][1][0];
			cube[2][2][2] = cube[1][0][0];
			cube[1][2][0] = cube[3][2][0];
			cube[1][1][0] = cube[3][1][0];
			cube[1][0][0] = cube[3][0][0];
			cube[3][2][0] = TEMP[0];
			cube[3][1][0] = TEMP[1];
			cube[3][0][0] = TEMP[2];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0)
		{
			cube = new char[6][3][3];
			for(int i = 0; i < 6; i++)
			{
				init(i, C[i]);
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
			{
				sb.append(st.nextToken());
				char c = sb.charAt(0);
				char dir = sb.charAt(1);
				if(dir == '+')
				{
					right(c);
				}
				else 
				{
					left(c);
				}
				sb.setLength(0);
			}
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					bw.write(cube[0][i][j]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
