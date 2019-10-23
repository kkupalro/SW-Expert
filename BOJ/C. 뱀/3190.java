import java.io.*;
import java.util.*;

class node {
	int y; int x;
	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class Main {
	static final int dy[] = {0,-1, 1, 0}; // > ^ v <
	static final int dx[] = {1, 0, 0,-1};
	static int N, K, L, result;
	static int matrix[][];
	static int l[] = new int[10001];
	static int ny, nx, dir;
	static ArrayDeque<node> T = new ArrayDeque<node>();
	static Queue<node> H = new LinkedList<node>();
	static void print(int a[][]) {
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[i].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		matrix = new int[N+2][N+2];
		result = -1;
		Arrays.fill(matrix[0], 9);
		Arrays.fill(matrix[N+1], 9);
		for(int i = 0; i <= N+1; i++)
		{
			matrix[i][0] = 9;
			matrix[i][N+1] = 9;
		}
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			matrix[y][x] = 4;
		}
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D"))
			{
				l[idx] = 1;
			}
			else
			{
				l[idx] = -1;
			}
		}
		H.offer(new node(1, 1)); // 처음 머리 위치
		T.offer(new node(1, 1)); // 처음 꼬리 위치
		boolean isApple = false;
		while(true)
		{
			result++;
			node h = H.poll(); // 현재 머리 위치
			node t = T.poll(); // 현재 꼬리 위치
			if(isApple)
			{
				matrix[h.y][h.x] = 1;
				T.offerFirst(new node(t.y, t.x));
			}
			else
			{
				matrix[t.y][t.x] = 0;
				matrix[h.y][h.x] = 1;
			}
			// (0. >) (1. ^) (2. v) (3. <)
			if(l[result] == -1)
			{
				if(dir == 0)
				{
					// > ^
					dir = 1;
				}
				else if(dir == 1)
				{
					// ^ <
					dir = 3;
				}
				else if(dir == 2)
				{
					// v >
					dir = 0;
				}
				else 
				{
					// < v
					dir = 2;
				}
			}
			else if(l[result] == 1)
			{
				if(dir == 0)
				{
					// > v
					dir = 2;
				}
				else if(dir == 1)
				{
					// ^ >
					dir = 0;
				}
				else if(dir == 2)
				{
					// v <
					dir = 3;
				}
				else 
				{
					// < ^
					dir = 1;
				}
			}
			ny = h.y + dy[dir]; // 다음 머리  y 위치
			nx = h.x + dx[dir]; // 다음 머리  x 위치
			if(matrix[ny][nx] == 1 || matrix[ny][nx] == 9)
			{
				// 기저 사례
				result++;
				break;
			}
			H.offer(new node(ny, nx));
			T.add(new node(h.y, h.x));
			
			if(matrix[ny][nx] == 4)
			{	
				isApple = true;
			}
			else
			{
				isApple = false;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}