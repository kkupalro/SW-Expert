package D7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {
	int x; int y; int cumsum;
	node(int x, int y, int cumsum)
	{
		this.x = x;
		this.y = y;
		this.cumsum = cumsum;
	}
	@Override
	public int compareTo(node target) {
		if(this.cumsum > target.cumsum)
		{
			return 1;
		}
		else if(this.cumsum < target.cumsum)
		{
			return -1;
		}
		return 0;
	}
}

public class D7 {
	static int matrix[][]; // x, y
	static boolean visit[][][]; // 누적합, x, y
	static int N; // 행렬 크기
	static int result; // 결과 값
	static final int dx[] = {1, -1, 0, 0}; // ->, <-, ^, v
	static final int dy[] = {0,  0,-1, 1};
	static PriorityQueue<node> pq;
	static void solve(int x, int y, int cumsum)
	{
		pq = new PriorityQueue<node>();
		pq.add(new node(x, y, cumsum));
		visit[0][0][0] = true; // cumsum, x, y;
		while(!pq.isEmpty())
		{
			node n = pq.poll();
			x = n.x;
			y = n.y;
			cumsum = n.cumsum;
			if(x == N-1 && y == N-1)
			{
				result = Math.min(result, cumsum);
				return;
			}
			for(int l=0; l<4; l++)
			{
				int nx = x + dx[l];
				int ny = y + dy[l];
				if(nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
				if(!visit[cumsum + matrix[ny][nx]][nx][ny])
				{
					pq.add(new node(nx, ny, cumsum + matrix[ny][nx]));
					visit[cumsum + matrix[ny][nx]][nx][ny] = true; // 방문 처리
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int t_num = 0; // 테스트케이스 출령용
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			visit = new boolean[424][N][N]; // 누적합, x, y
			result = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				StringBuilder sb = new StringBuilder(st.nextToken());
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(String.valueOf((sb.charAt(j))));
				}
				sb.setLength(0);
			}
			solve(0, 0, 0);
			System.out.printf("#%d %d\n", ++t_num, result);
		}
		br.close();
	}
}
