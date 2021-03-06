import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6 {
	static final int MAX = 100;
	static int matrix[][];
	static int result;
	static int count;
	static int dx[] = { 0, 1,-1};
	static int dy[] = {-1, 0, 0};
	static void solve(int y, int x, int dir, int cnt)
	{
		if(y == 0)
		{
			if(cnt <= count)
			{
				result = x;
				count = cnt;
				return;
			}
		}
		if(dir == 0)
		{
			for(int i = 1; i < 3; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>MAX-1 || ny<0 || ny>MAX-1 || matrix[ny][nx] == 0) continue;
				solve(ny, nx, i, cnt + 1);
				return;
			}
		}
		else if(dir == 1 || dir == 2) {
			for(int i = 0; i< 1; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>MAX-1 || ny<0 || ny>MAX-1 || matrix[ny][nx] == 0) continue;				
				solve(ny, nx, i, cnt + 1);
				return;
			}			
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx<0 || nx> MAX-1 || ny<0 || ny> MAX-1 || matrix[ny][nx] == 0) return; 
		solve(ny, nx, dir, cnt + 1); 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10; // 테스트 케이스 갯수
		while(T-- > 0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t_num = Integer.parseInt(st.nextToken()); // 출영용 테스트 케이스
			matrix = new int[MAX][MAX];
			result = Integer.MAX_VALUE;
			count = Integer.MAX_VALUE;
			for(int i = 0; i < MAX; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < MAX; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < MAX; i++)
			{
				if(matrix[99][i] == 1)
				{
					solve(99, i, 0, 0);
				}
			}
			System.out.printf("#%d %d\n", t_num, result);
		}
		br.close();
	}
}
