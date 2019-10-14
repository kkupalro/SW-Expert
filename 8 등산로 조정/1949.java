package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x; int num;
	node(int y, int x, int num){
		this.y = y;
		this.x = x;
		this.num = num;
	}
}
public class Main {
	static final int dy[] = {0, 0, 1,-1}; // > < v ^
	static final int dx[] = {1,-1, 0, 0};
	static LinkedList<node> list = new LinkedList<node>();
	static int matrix[][];
	static boolean visit[][];
	static int T, t_num, result;
	static int N, K;
	static void dfs(int y, int x, int cnt) {
		result = Math.max(cnt, result);
		for(int l = 0; l < 4; l++)
		{
			int ny = y + dy[l];
			int nx = x + dx[l];
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if(visit[ny][nx]) continue;
			if(matrix[ny][nx] >= matrix[y][x]) continue;
			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1);
			visit[ny][nx] = false;
		}
	}
	static void solve() {
		for(int i = 0; i < list.size(); i++) 
		{
			if(list.get(i).num != matrix[list.get(i).y][list.get(i).x])
			{
				// 깎은 좌표가 정상 좌표 일 경우 정상이 아니므로, 시작 불가
				continue;
			}
			for(int l = 0; l < 4; l++)
			{
				int ny = list.get(i).y + dy[l];
				int nx = list.get(i).x + dx[l];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if(matrix[ny][nx] >= list.get(i).num) continue;
				visit[ny][nx] = true;
				dfs(ny, nx, 2); // 정상좌표 + 가능좌표 = 2 부터 시작
				visit[ny][nx] = false;
			}
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
			K = Integer.parseInt(st.nextToken());
			matrix = new int[N][N];
			visit = new boolean[N][N];
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] = Integer.parseInt(st.nextToken());
					// 최대 좌표 저장
					if(list.size() == 0)
					{
						list.offer(new node(i, j, matrix[i][j]));
					}
					else
					{
						if(list.get(0).num < matrix[i][j])
						{
							list.clear();
							list.offer(new node(i, j, matrix[i][j]));
						}
						else if(list.get(0).num == matrix[i][j])
						{
							list.offer(new node(i, j, matrix[i][j]));
						}
					}
				}
			}
			// 지형 공사 * 최대 K 만큼
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					for(int k = 1; k <= K; k++)
					{
						matrix[i][j] -= k;
						solve();
						matrix[i][j] += k;
					}
				}
			}
			bw.write("#" + ++t_num + " " + result + "\n");
			list.clear();
			result = 0;
		}
		bw.flush();
		bw.close();
	}
}
