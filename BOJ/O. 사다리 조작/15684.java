package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static boolean matrix[][];
	static int H;
	static int result = Integer.MAX_VALUE;
	static int Y, X;
	static void print(int a[][]) {
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void print2(boolean a[][]) {
		for(int i = 1; i < a.length; i++)
		{
			for(int j = 1; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void solve(int cnt) {
		// 기저 조건
		boolean flag = false;
		if(cnt == 3)
		{
			for(int i = 1; i <= X; i++)
			{
				int ans = i;
				for(int j = 1; j <= Y; j++)
				{
					if(matrix[j][ans-1])
					{
						ans--;
					}
					else if(matrix[j][ans])
					{
						ans++;
					}
				}
				if(ans != i)
				{
					flag = false;
					break;
				}
				else if(ans == i)
				{
					flag = true;
					continue;
				}
			}
			if(flag)
			{
				result = Math.min(result, cnt);
			}
			return;
		}
		
		for(int i = 1; i <= X; i++)
		{
			int ans = i;
			for(int j = 1; j <= Y; j++)
			{
				if(matrix[j][ans])
				{
					ans++;
				}
				else if(matrix[j][ans-1])
				{
					ans--;
				}
			}
			if(ans != i)
			{
				flag = false;
				break;
			}
			else if(ans == i)
			{
				flag = true;
			}
		}
		if(flag)
		{
			result = Math.min(result, cnt);
		}
		else if(!flag) 
		{
			for(int i = 1; i <= Y; i++)
			{
				for(int j = 1; j < X; j++)
				{
					if(!matrix[i][j-1] && !matrix[i][j] && !matrix[i][j+1])
					{
						matrix[i][j] = true;
						solve(cnt + 1);
						matrix[i][j] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken()); // 세로선의 개수
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을수 있는 위치 개수
		Y = Integer.parseInt(st.nextToken()); // 가로선의 개수
		matrix = new boolean[Y+1][X+1];
		result = Integer.MAX_VALUE;
		if(H != 0)
		{
			for(int i = 0; i < H; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				matrix[a][b] = true;
			}
		}
		boolean flag = false;
		for(int i = 1; i <= X; i++)
		{
			int ans = i; // 현재 위치
			for(int j = 1; j <= Y; j++)
			{
				if(matrix[j][ans-1])
				{
					ans--;
				}
				else if(matrix[j][ans])
				{
					ans++;
				}
			}
			if(ans != i)
			{
				flag = false;
				break;
			}
			else
			{
				flag = true;
			}
		}
		if(flag)
		{
			result = 0;
		}
		else
		{
			for(int i = 1; i <= Y; i++)
			{
				for(int j = 1; j < X; j++)
				{
					if(!matrix[i][j-1] && !matrix[i][j] && !matrix[i][j+1])
					{
						matrix[i][j] = true;
						solve(1);
						matrix[i][j] = false;
					}
				}
			}
		}
		result = (result==Integer.MAX_VALUE)?-1:result; // result가 초기값이면 카운트 3초과 or 불가능
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}