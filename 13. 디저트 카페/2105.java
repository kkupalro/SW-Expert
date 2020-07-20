import java.io.*;
import java.util.*;

class Solution {
	static final int dy[] = {1, 1,-1,-1};
	static final int dx[] = {1,-1,-1, 1};
	static int T, N, t_num, result;
	static int sy, sx;
	static int matrix[][];
	static boolean visit[][];
	static boolean n_visit[];
	static void solve(int y, int x, int dir, int cnt) {
		if(dir == 4) return;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if(ny < 0 || ny >= N || nx < 0 || nx >= N) return;
		if(visit[ny][nx] || n_visit[matrix[ny][nx]])
		{
			if(ny == sy && nx == sx)
			{
				result = Math.max(result, cnt);
			}
			return;
		}
		n_visit[matrix[ny][nx]] = true;
		visit[ny][nx] = true;
		solve(ny, nx, dir, cnt + 1);
		solve(ny, nx, dir + 1, cnt + 1);
		visit[ny][nx] = false;
		n_visit[matrix[ny][nx]] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			visit = new boolean[N][N];
			n_visit = new boolean[101];
			result = -1;
			sy = 0; sx = 0;
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					sy = i; sx = j;
					visit[i][j] = true;
					n_visit[matrix[i][j]] = true;
					solve(i, j, 0, 1);
					n_visit[matrix[i][j]] = false;
					visit[i][j] = false;
				}
			}
			bw.write("#" + ++t_num + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
