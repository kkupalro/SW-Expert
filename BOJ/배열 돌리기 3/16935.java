package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, R;
	static int matrix[][] = new int[101][101];
	static int temp[][] = new int[101][101];
	static Stack<Integer> s = new Stack<Integer>();
	static void copy() {
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = temp[i][j];
			}
		}
	}
	static void solve() {
		int mid = 0; int type = 0; int ny = 0; int nx = 0;
		Iterator<Integer> it = s.iterator();
		loop1:
		while(it.hasNext())
		{
			type = it.next();
			if(type == 1)
			{
				mid = Y/2;
				for(int j = 0; j < X; j++)
				{
					for(int i = 0; i < mid; i++)
					{
						matrix[i][j] ^= matrix[Y-i-1][j];
						matrix[Y-i-1][j] ^= matrix[i][j];
						matrix[i][j] ^= matrix[Y-i-1][j];
					}
				}
				continue loop1;
			}
			else if(type == 2)
			{
				mid = X/2;
				for(int i = 0; i < Y; i++)
				{
					for(int j = 0; j < mid; j++)
					{
						matrix[i][j] ^= matrix[i][X-j-1];
						matrix[i][X-j-1] ^= matrix[i][j];
						matrix[i][j] ^= matrix[i][X-j-1];
					}
				}
				continue loop1;
			}
			else if(type == 3)
			{
				mid = Y/2;
				for(int i = 0; i < X; i++)
				{
					for(int j = 0; j < Y; j++)
					{
						temp[i][j] = matrix[Y-j-1][i];
					}
				}
				Y ^= X;
				X ^= Y;
				Y ^= X;
				copy();
				continue loop1;
			}
			else if(type == 4)
			{
				mid = Y/2;
				for(int i = 0; i < X; i++)
				{
					for(int j = 0; j < Y; j++)
					{
						temp[i][j] = matrix[j][X-i-1];
					}
				}
				Y ^= X;
				X ^= Y;
				Y ^= X;
				copy();
				continue loop1;
			}
			else
			{
				nx = X/2;
				ny = Y/2;
				if(type == 5)
				{
					for(int i = 0; i < ny; i++)
					{
						for(int j = 0; j < nx; j++)
						{
							temp[i][j] = matrix[ny+i][j];
						}
						for(int j = nx; j < X; j++)
						{
							temp[i][j] = matrix[i][j-nx];
						}
					}
					for(int i = ny; i < Y; i++)
					{
						for(int j = nx; j < X; j++)
						{
							temp[i][j] = matrix[i-ny][j];
						}
						for(int j = 0; j < nx; j++)
						{
							temp[i][j] = matrix[i][j+nx];
						}
					}
				}
				else if(type == 6)
				{
					for(int i = 0; i < ny; i++)
					{
						for(int j = 0; j < nx; j++)
						{
							temp[i][j] = matrix[i][j+nx];
						}
						for(int j = nx; j < X; j++)
						{
							temp[i][j] = matrix[i+ny][j];
						}
					}
					for(int i = ny; i < Y; i++)
					{
						for(int j = nx; j < X; j++)
						{
							temp[i][j] = matrix[i][j-nx];
						}
						for(int j = 0; j < nx; j++)
						{
							temp[i][j] = matrix[i-ny][j];
						}
					}
				}
				copy();
				continue loop1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for(int i = 0; i < Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		loop:
		for(int i = 0; i < R; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			if(!s.isEmpty())
			{
				if(num == 1)
				{
					if(s.peek() == num)
					{
						s.pop();
						continue loop;
					}
				}
				else if(num == 2)
				{
					if(s.peek() == num)
					{
						s.pop();
						continue loop;
					}
				}
				else if(num == 3)
				{
					if(s.size() >= 3)
					{
						if(s.peek() == num)
						{
							int cnt = 0;
							for(int j = 0; j < 3; j++)
							{
								if(num == s.get(s.size()-j-1))
								{
									cnt++;
								}
							}
							if(cnt == 3)
							{
								s.pop();
								s.pop();
								s.pop();
								continue loop;
							}
						}
						else if(s.peek() == 4)
						{
							s.pop();
							continue loop;
						}
					}
				}
				else if(num == 4)
				{
					if(s.size() >= 3)
					{
						if(s.peek() == num)
						{
							int cnt = 0;
							for(int j = 0; j < 3; j++)
							{
								if(num == s.get(s.size()-j-1))
								{
									cnt++;
								}
							}
							if(cnt == 3)
							{
								s.pop();
								s.pop();
								s.pop();
								continue loop;
							}
							
						}
						else if(s.peek() == 3)
						{
							s.pop();
							continue loop;
						}
					}
				}
			}
			s.push(num);
		}
		R = s.size();
		solve();
		for(int i = 0; i < Y; i++)
		{
			for(int j = 0; j < X; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
