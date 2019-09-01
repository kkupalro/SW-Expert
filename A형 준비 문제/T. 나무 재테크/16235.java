package TEST;

import java.io.*;
import java.util.*;

class node implements Comparable<node> {
	int x; int y; int z; boolean live;
	node(int x, int y, int z, boolean live)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.live = live;
	}
	
	@Override
	public int compareTo(node target) {
		return this.z - target.z;
	}
}

public class Main {
	static final int dy[] = {-1,-1,-1, 0, 0, 1, 1, 1};
	static final int dx[] = {-1, 0, 1,-1, 1,-1, 0, 1};
	static int matrix[][];
	static int temp[][];
	static int N, M, K, result;
	static LinkedList<node> list = new LinkedList<node>();
	static PriorityQueue<node> pq = new PriorityQueue<node>();
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static void solve() {
		for(int year = 1; year <= K; year++)
		{
			// 봄
			LinkedList<node> tmp = new LinkedList<node>();
			for(node n : list)
			{
				if(matrix[n.x][n.y] >= n.z)
				{
					matrix[n.x][n.y] -= n.z;
					n.z++;
				}
				else
				{
					n.live = false;
				}
			}
			// 여름
			// 시간초과 : 기존 for문시 리스트에서 나무 죽었을시 현재 인덱스 유지하고 다음 리스트값 탐색
			// 이터레이터를 통한 빠른 탐색
			Iterator<node> it = list.iterator();
			while(it.hasNext())
			{
				node n = it.next();
				if(!n.live) 
				{
					matrix[n.x][n.y] += (n.z / 2);
					it.remove();
				}
			}
			// 가을
			for(node n : list)
			{
				if((n.z % 5)==0)
				{
					for(int l = 0; l < 8; l++)
					{
						int ny = n.y + dy[l];
						int nx = n.x + dx[l];
						if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
						tmp.offer(new node(nx, ny, 1, true));
					}
				}
			}
			// 인덱스 0부터 더함 -> 분열된 나무 나이가 1이므로 우선순위 가장 높음
			list.addAll(0, tmp);
			// 겨울
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrix[i][j] += temp[i][j];
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		temp = new int[N][N];
		for (int arr[] : matrix) {
			Arrays.fill(arr, 5);
		}
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				temp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.offer(new node(x-1, y-1, z, true));
		}
		list.sort(null);
		solve();
		bw.write(list.size() + "\n");
		bw.flush();
		bw.close();
	}
}
