package D11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class memory {
	int command; int data; int r; int c;
	memory(int command, int data, int r, int c)
	{
		this.command = command;
		this.data = data;
		this.r = r;
		this.c = c;
	}
}

public class D11 {
	static char matrix[][];
	static boolean map[][][][];
	static int R;
	static int C;
	static final int dr[] = { 0,  0, 1,-1};
	static final int dc[] = { 1, -1, 0, 0};
	static boolean bfs() {	
			Queue<memory> q = new LinkedList<memory>();
			q.add(new memory(0, 0, 0, 0));
			map[0][0][0][0] = true;
			// command, data, r, c
			while(!q.isEmpty())
			{
				memory m = q.poll();
				int command = m.command;
				int data = m.data;
				int r = m.r;
				int c = m.c;
				if(matrix[r][c] >= '0' && matrix[r][c] <= '9') data = matrix[r][c] - '0';
				else if(matrix[r][c] == '<') command = 1;
				else if(matrix[r][c] == '>') command = 0;
				else if(matrix[r][c] == '^') command = 3;
				else if(matrix[r][c] == 'v') command = 2;
				else if(matrix[r][c] == '_') command = (data == 0 ? 0 : 1);
				else if(matrix[r][c] == '|') command = (data == 0 ? 2 : 3);
				else if(matrix[r][c] == '+') data = (data == 15 ? 0 : data + 1);
				else if(matrix[r][c] == '-') data = (data == 0 ? 15 : data - 1);
				else if(matrix[r][c] == '@') return true;
				else if(matrix[r][c] == '?') 
				{
					for(int i = 0; i < 4; i++)
					{
						int nr = (dr[i] + r + R ) % R;
						int nc = (dc[i] + c + C ) % C;
						if(!map[i][data][nr][nc])
						{
							q.add(new memory(i, data, nr, nc));
							map[i][data][nr][nc] = true;	
						}
					}
					continue;
				}
				int nr = (dr[command] + r + R ) % R;
				int nc = (dc[command] + c + C ) % C;
				if(!map[command][data][nr][nc])
				{
					q.add(new memory(command, data, nr, nc));
					map[command][data][nr][nc] = true;
				}
			}
			return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken()); // 배열 행
			C = Integer.parseInt(st.nextToken()); // 배열 열
			matrix = new char[R][C];
			map = new boolean[4][16][R][C]; // command, data, row, col
			for(int i = 0; i < R; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				StringBuilder sb = new StringBuilder(st.nextToken());
				for(int j = 0; j < C; j++)
				{
					matrix[i][j] = sb.charAt(j);
				}
				sb.setLength(0);
			}
			System.out.printf("#%d %s\n", ++t_num, bfs() ? "YES" : "NO");
		}
		br.close();
	}
}

