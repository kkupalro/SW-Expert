package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node {
	int x; int y; int data; int dir;
	node(int x, int y, int data, int dir)
	{
		this.x = x;
		this.y = y;
		this.data = data;
		this.dir = dir;
	}
}

public class D6 {
	static int matrix[][];
	static final int MAX = 100;
	static final int dx[] = {1,-1, 0}; 	// ->, <-, ^
	static final int dy[] = {0, 0,-1}; 	// 0: 우, 1: 좌, 2: 상
	static int result;
	
	static void bfs(int x, int y, int data, int dir)
	{
		Queue<node> q = new LinkedList<node>();
		q.add(new node(x, y, data, dir));
		
		loop:
		while(!q.isEmpty())
		{
			node n = q.poll();
			x = n.x;
			y = n.y;
			data = n.data; 
			dir = n.dir;
			int nx = 0;
			int ny = 0;
			
			// 종료
			if(y==0)
			{
				result = x;
				return;
			}
			// 우, 좌
			else if(dir == 0 || dir == 1)
			{
				nx = x + dx[2];
				ny = y + dy[2];
				if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1) continue;
				else if(matrix[ny][nx] == data)
				{
					q.add(new node(nx, ny, data, 2));
					continue loop;
				}
			}
			// 상
			else if(dir == 2)
			{
				for(int l = 0; l < 2; l++)
				{
					nx = x + dx[l];
					ny = y + dy[l];
					if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1 ) continue;
					if(matrix[ny][nx] == data)
					{
						q.add(new node(nx, ny, data, l));
						continue loop;
					}
				}
			}	
			nx = x + dx[dir];
			ny = y + dy[dir];
			if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1 )
			{
				continue;
			}
			else if(matrix[ny][nx] == data)
			{
				q.add(new node(nx, ny, data, dir));
			}
		}
	}
	
	static void dfs(int x, int y, int data, int dir)
	{
			int nx = 0;
			int ny = 0;
			if(y==0)
			{
				result = x;
				return;
			}
			// 우, 좌
			else if(dir == 0 || dir == 1)
			{
				nx = x + dx[2];
				ny = y + dy[2];
				if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1) { }
				else if(matrix[ny][nx] == data)
				{
					dfs(nx, ny, data, 2);
					return;
				}
			}
			// 상
			else if(dir == 2)
			{
				for(int l = 0; l < 2; l++)
				{
					nx = x + dx[l];
					ny = y + dy[l];
					if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1 ) continue;
					if(matrix[ny][nx] == data)
					{
						dfs(nx, ny, data, l);
						return;
					}
				}
			}	
			nx = x + dx[dir];
			ny = y + dy[dir];
			if(nx < 0 || nx > MAX-1 || ny < 0 || ny > MAX-1 ) { }
			else if(matrix[ny][nx] == data)
			{
				dfs(nx, ny, data, dir);
			}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		while(T-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t_num = Integer.parseInt(st.nextToken()); // 출력용 테스트 번호
			matrix = new int[MAX][MAX];
			for(int i = 0; i < MAX; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < MAX; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] == 2)
					{
						// dfs(j, i, 1, 2);
						bfs(j, i, 1, 2);
					}
				}
			}
			
			System.out.printf("#%d %d\n" , t_num, result);
			result = 0;
		}
		br.close();
		
		
	}
	

}
