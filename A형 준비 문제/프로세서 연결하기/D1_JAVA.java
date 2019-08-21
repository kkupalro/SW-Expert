package D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

class node {
	int x; int y;
	node(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class D1 {
	static int matrix[][];
	static int N;
	static Vector<node> v;
	static int result;
	static int con_result;
	static final int dx[] = {1,-1, 0, 0}; // ->, <-, ^, v
	static final int dy[] = {0, 0,-1, 1};
	static void copy(int[][] a, int[][] b)
	{
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void solve(int cnt, int con)
	{		
		int temp[][] = new int[N][N];
		copy(temp, matrix);
		if(cnt == v.size())
		{
			int ans = 0;
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(matrix[i][j] == 2)
					{
						ans++;
					}
				}
			}
			if(result == Integer.MAX_VALUE)
			{
				result = ans;
				con_result = con;
			}
			else if(con > con_result)
			{
				con_result = con;
				result = ans;
			}
			else if(con == con_result && result > ans)
			{
				result = ans;
			}
			return;
		}
		node n = v.get(cnt);
		int x = n.x;
		int y = n.y;
		if(x==0 || x==N-1 || y==0 || y==N-1)
		{
			solve(cnt+1, con+1);
		}
		else 
		{
			boolean flag = false;
			for(int l = 0; l < 4; l++)
			{
				for(int d = 1; d < N; d++)
				{
					int nx = x + dx[l]*d;
					int ny = y + dy[l]*d;
					if(nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
					if(matrix[ny][nx] != 0) {
						flag = false; 
						break;
					}
					flag = true;
				}
				if(flag)
				{
					for(int d = 1; d < N; d++)
					{
						int nx = x + dx[l]*d;
						int ny = y + dy[l]*d;
						if(nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
						matrix[ny][nx] = 2;
					}
					solve(cnt+1, con+1);
					copy(matrix, temp);
				}
			}
			//연결 실패했을시 다음 core 호출
			if(!flag)
			{
				solve(cnt+1, con);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			v = new Vector<node>();
			result = Integer.MAX_VALUE;
			con_result = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] == 1)
					{
						v.add(new node(j,i));
					}
				}
			}
			solve(0, 0);
			System.out.printf("#%d %d\n", ++t_num, result);
		}
		br.close();
	}
}
