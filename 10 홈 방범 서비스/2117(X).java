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

public class Solution {
	static final int dy[] = {-1, 0, 1, 0}; // ^ > v <
	static final int dx[] = { 0, 1, 0,-1};
	static int T, N, M, K, t_num, result;
	static int max;
	static int matrix[][];
	static void solve(int y, int x) {
		Queue<node> q;
		int k = 1;
		while(k > 0) 
		{
			q = new LinkedList<node>();
			q.offer(new node(y, x, 1));
			boolean visit[][] = new boolean[N][N];
			int cost = (int)Math.pow(k, 2) + (int)Math.pow(k-1, 2);
			int cnt = 0;
			int c = 0;
			while(!q.isEmpty()) 
			{
				node n = q.poll();
				visit[n.y][n.x] = true;
				if(matrix[n.y][n.x] == 1)
				{
					c += M;
					cnt++;
				}
				for(int l = 0; l < 4; l++)
				{
					int ny = n.y + dy[l];
					int nx = n.x + dx[l];
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(visit[ny][nx] || n.h >= k) continue;
					q.offer(new node(ny, nx, n.h + 1));
					visit[ny][nx] = true;
				}
			}
			c -= cost;
			if(c >= 0)
			{
				result = Math.max(result, cnt);
			}
			if(cost > max)
			{
				break;
			}
			k++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			result = 0;
			int count = 0;
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] == 1) count++; max += M;
				}
			}
			// 다 덮는 최대의 수
			if(N % 2 == 0)
			{
				K = N + 1;
			}
			else
			{
				K = N;
			}
			boolean flag = false;
			if(count * M >= (int)Math.pow(K, 2) + (int)Math.pow(K-1, 2))
			{
				result = count;
				flag = true;
			}
			if(!flag)
			{
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						solve(i, j);
					}
				}
			}
			bw.write("#" + ++t_num + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
