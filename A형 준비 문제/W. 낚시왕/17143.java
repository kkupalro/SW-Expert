package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x; int s; int d; int z;
	node(int y, int x, int s, int d, int z)
	{
		this.y = y;
		this.x = x;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

public class Main {
	static node[] fish = new node[10001];
	static int Y, X, M, result;
	static int matrix[][];
	static final int dy[] = {-1, 1, 0, 0}; // (1. ^), (2. v), (3. >), (4. < ) 
	static final int dx[] = { 0, 0, 1,-1};
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
	static void copy(int a[][], int b[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void solve() {
		for(int i = 0; i < X; i++)
		{
			for(int j = 0; j < Y; j++)
			{
				if(matrix[j][i] != 0)
				{
					fish[matrix[j][i]] = null;
					result += matrix[j][i];
					matrix[j][i] = 0; // 해당 좌표 0
					break;
				}
			}	
			// 상어 이동
			for(int j = 1; j <= 10000; j++)
			{
				if(fish[j] == null) continue;
				node n = fish[j];
				int ny = n.y;
				int nx = n.x;
				int s = n.s;
				int d = n.d;
				matrix[ny][nx] = 0;
				if(d == 0 || d == 1)
				{
					s %= (Y-1)*2;
					while(s > 0)
					{
						if(ny == 0)
						{
							d = 1;
						}
						if(ny == Y-1)
						{
							d = 0;
						}
						ny += dy[d];
						s--;
					}
					fish[n.z] = new node(ny, nx, n.s, d, n.z);
				}
				else 
				{
					s %= (X-1)*2;
					while(s > 0)
					{
						if(nx == 0)
						{
							d = 2;
						}
						else if(nx == X-1)
						{
							d = 3;
						}
						nx += dx[d];
						s--;
					}
					fish[n.z] = new node(ny, nx, n.s, d, n.z);
				}
			}
			for(int j = 1; j <= 10000; j++)
			{
				if(fish[j] == null) continue;
				node n = fish[j];
				if(matrix[n.y][n.x] < n.z)
				{
					fish[matrix[n.y][n.x]] = null;
					matrix[n.y][n.x] = n.z;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken()); // Y 좌표
		X = Integer.parseInt(st.nextToken()); // X 좌표
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		matrix = new int[Y][X];
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			fish[z] = new node(y, x, s, d-1, z);
			matrix[y][x] = z;
		}
		solve();
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
