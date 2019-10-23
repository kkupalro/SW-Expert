package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int matrix[][] = new int[4][8];
	static int K;
	static int result;
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void solve(int n, int c) {
		// N, S극 검사
		boolean check[] = new boolean[4];
		int rotate[] = new int[4];
		check[n] = true;
		rotate[n] = c;
		if(n == 0) 
		{
			check[1] = (matrix[0][2]!=matrix[1][6])?true:false;
			check[2] = check[1]?(matrix[1][2]!=matrix[2][6])?true:false:false;
			check[3] = check[2]?(matrix[2][2]!=matrix[3][6])?true:false:false;
			
			rotate[1] = rotate[0] * -1;
			rotate[2] = rotate[1] * -1;
			rotate[3] = rotate[2] * -1;
		}
		else if(n == 1) 
		{
			check[0] = (matrix[0][2]!=matrix[1][6])?true:false;
			check[2] = (matrix[1][2]!=matrix[2][6])?true:false;
			check[3] = check[2]?(matrix[2][2]!=matrix[3][6])?true:false:false;
			
			rotate[0] = rotate[1] * -1;
			rotate[2] = rotate[1] * -1;
			rotate[3] = rotate[2] * -1;
		}
		else if(n == 2) 
		{
			check[1] = (matrix[1][2]!=matrix[2][6])?true:false;
			check[0] = check[1]?(matrix[0][2]!=matrix[1][6])?true:false:false;
			check[3] = (matrix[2][2]!=matrix[3][6])?true:false;
			
			rotate[1] = rotate[2] * -1;
			rotate[0] = rotate[1] * -1;
			rotate[3] = rotate[2] * -1;
		}
		else if(n == 3) 
		{
			check[2] = (matrix[2][2]!=matrix[3][6])?true:false;
			check[1] = check[2]?(matrix[1][2]!=matrix[2][6])?true:false:false;
			check[0] = check[1]?(matrix[0][2]!=matrix[1][6])?true:false:false;
			
			rotate[2] = rotate[3] * -1;
			rotate[1] = rotate[2] * -1;
			rotate[0] = rotate[1] * -1;
		}
		
		for(int i = 0; i < 4; i++)
		{
			if(check[i])
			{
				// 시계 방향
				if(rotate[i] == 1)
				{
					int tmp1 = matrix[i][0];
					matrix[i][0] = matrix[i][7];
					int tmp2 = tmp1;
					for(int j = 1; j < 8; j++)
					{
						tmp1 = matrix[i][j];
						matrix[i][j] = tmp2;
						tmp2 = tmp1;
					}
				}
				// 반시계 방향
				else if(rotate[i] == -1)
				{
					int tmp1 = matrix[i][7];
					matrix[i][7] = matrix[i][0];
					int tmp2 = tmp1;
					for(int j = 6; j >= 0; j--)
					{
						tmp1 = matrix[i][j];
						matrix[i][j] = tmp2;
						tmp2 = tmp1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		result = 0;
		for(int i = 0; i < 4; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < 8; j++)
			{
				matrix[i][j] = sb.charAt(j) - '0';
			}
			sb.setLength(0);
		}
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()) - 1; 
			int c = Integer.parseInt(st.nextToken());
			solve(n, c);
		}
		result = matrix[0][0]*1 + matrix[1][0]*2 + matrix[2][0]*4 + matrix[3][0]*8;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}