package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x; int h;
	node(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}
}

public class Main {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int matrix[][][];
	static int Y, X, H, result;
	static Queue<node> q = new LinkedList<node>();
	static void solve() {
		int ny = 0; int nx = 0; int size = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			for(int i = 0; i < size; i++)
			{
				node n = q.poll();
				int y = n.y;
				int x = n.x;
				int h = n.h;
				for(int l = 0; l < 4; l++)
				{
					ny = y + dy[l];
					nx = x + dx[l];
					if(ny < 0 || ny > Y-1 || nx < 0 || nx > X-1) continue;
					if(matrix[h][ny][nx] == -1 || matrix[h][ny][nx] == 1) continue;
					matrix[h][ny][nx] = 1;
					q.offer(new node(ny, nx, h));
				}
				if(H == 1) break;
				if(h == 0)
				{
					if(matrix[h+1][y][x] == -1 || matrix[h+1][y][x] == 1) continue;
					matrix[h+1][y][x] = 1;
					q.offer(new node(y, x, h+1));
				}
				else if(h == H-1)
				{
					if(matrix[h-1][y][x] == -1 || matrix[h-1][y][x] == 1) continue; 
					matrix[h-1][y][x] = 1;
					q.offer(new node(y, x, h-1));
				}
				else 
				{
					if(matrix[h-1][y][x] != -1 && matrix[h-1][y][x] != 1) 
					{
						matrix[h-1][y][x] = 1;
						q.offer(new node(y, x, h-1));
					}
					if(matrix[h+1][y][x] != -1 && matrix[h+1][y][x] != 1)
					{
						matrix[h+1][y][x] = 1;
						q.offer(new node(y, x, h+1));
					}
				}
			}
			result++;
		}
		result--;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		matrix = new int[H][Y][X];
		for(int h = 0; h < H; h++)
		{
			for(int i = 0; i < Y; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < X; j++)
				{
					matrix[h][i][j] = Integer.parseInt(st.nextToken());
					if(matrix[h][i][j] == 1)
					{
						q.offer(new node(i, j, h));
					}
				}
			}
		}
		if(q.isEmpty())
		{
			result = 0;
		}
		else
		{
			solve();
			for(int h = 0; h < H; h++)
			{
				for(int i = 0; i < Y; i++)
				{
					for(int j = 0; j < X; j++)
					{
						if(matrix[h][i][j] == 0)
						{
							result = -1;
							break;
						}
					}
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
