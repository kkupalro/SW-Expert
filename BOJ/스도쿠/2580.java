package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x;
	node(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static LinkedList<node> l = new LinkedList<node>();
	static int matrix[][] = new int[9][9];
	static int count;
	static void print(int a[][]) {
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve(int cnt) {		
		if(cnt == count)
		{
			print(matrix);
			System.exit(0);
			return;
		}
		int y = l.get(cnt).y;
		int x = l.get(cnt).x;		
		// 1. 가로 검사
		boolean visit[] = new boolean[10];
		for(int i = 0; i < 9; i++)
		{
			if(i == x) continue;
			visit[matrix[y][i]] = true;
		}
		// 2. 세로 검사
		for(int i = 0; i < 9; i++)
		{
			if(i == y) continue;
			visit[matrix[i][x]] = true;
		}
		// 3. 칸 검사
		int ny = (y / 3) * 3;
		int nx = (x / 3) * 3;
		for(int i = ny; i < ny + 3; i++)
		{
			for(int j = nx; j < nx + 3; j++)
			{
				if(i == y && j == x) continue;
				visit[matrix[i][j]] = true;
			}
		}
		for(int i = 1; i <= 9; i++)
		{
			if(!visit[i])
			{
				matrix[y][x] = i;
				solve(cnt+1);
				matrix[y][x] = 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i = 0; i < 9; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 0)
				{
					l.offer(new node(i, j));
					count++;
				}
			}
		}
		solve(0);
	}
}