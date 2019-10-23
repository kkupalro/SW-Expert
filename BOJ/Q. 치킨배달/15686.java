package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x; boolean visit;
	node(int y, int x, boolean visit){
		this.y = y;
		this.x = x;
		this.visit = visit;
	}
}

public class Main {
	static final int INF = 101;
	static int matrix[][];
	static int N, M;
	static int result;
	static LinkedList<node> H = new LinkedList<node>(); // 집
	static LinkedList<node> C = new LinkedList<node>(); // 치킨집
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
	static void solve(int idx, int cnt) {
		if(cnt == M )
		{
			int ans = 0;
			for(int i = 0; i < H.size(); i++)
			{
				int hx = H.get(i).x;
				int hy = H.get(i).y;
				int dist = INF;
				for(int j = 0; j < C.size(); j++)
				{
					if(C.get(j).visit)
					{
						int cx = C.get(j).x;
						int cy = C.get(j).y;
						dist = Math.min(dist, Math.abs(hx - cx) + Math.abs(hy - cy));
					}
				}
				ans += dist;
			}
			result = Math.min(result, ans);
			return;
		}
		// <순열> 0 부터 탐색해서 시간초과남 => <조합>으로 변경 현재 idx부터 탐색
		for(int i = idx; i < C.size(); i++)
		{
			if(!C.get(i).visit)
			{
				C.get(i).visit = true;
				solve(i + 1, cnt + 1);
				C.get(i).visit = false;
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
		matrix = new int[N][N];
		H = new LinkedList<node>();
		C = new LinkedList<node>();
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 1)
				{
					H.add(new node(i, j, false));
				}
				else if(matrix[i][j] == 2)
				{
					C.add(new node(i, j, false));
				}
			}
		}
		result = Integer.MAX_VALUE;
		for(int i = 0; i < C.size(); i++)
		{
			C.get(i).visit = true;
			solve(i, 1);
			C.get(i).visit = false;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}