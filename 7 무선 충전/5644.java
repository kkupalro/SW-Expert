package TEST;

import java.io.*;
import java.util.*;

class node {
	int y; int x; int c; int p;
	node(int y, int x, int c, int p) {
		this.y = y;
		this.x = x;
		this.c = c;
		this.p = p;
	}
}

public class Main {
	static final int dy[] = {0,-1, 0, 1, 0}; // (0. X), (1. ^), (2. >), (3. v), (4. <)
	static final int dx[] = {0, 0, 1, 0,-1};
	static int M, N, ax ,ay, bx, by; 
	static int T, t_num;
	static int ans, result;
	static int A[];
	static int B[];
	static LinkedList<node> list;
	// 순서 있는 조합
	static void comb(int idx) {
		// 인덱스 겹치지 않게 
		// ex) (0, 1), (0, 2), (1, 0), (1, 2), (2, 0), (2, 1) ...
		for(int i = 0; i < list.size(); i++)
		{
			if(i == idx) continue;
			ans = Math.max(ans, dist(idx, i));
		}
	}
	// 범위
	static int dist(int a_idx, int b_idx) {
		// a 인덱스, b 인덱스
		int ad = (int)Math.abs(ax - list.get(a_idx).x) + Math.abs(ay - list.get(a_idx).y);
		int bd = (int)Math.abs(bx - list.get(b_idx).x) + Math.abs(by - list.get(b_idx).y);
		return ((ad<=list.get(a_idx).c)?list.get(a_idx).p:0) + ((bd<=list.get(b_idx).c)?list.get(b_idx).p:0);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			A = new int[M+1];
			B = new int[M+1];
			result = 0;
			ax = 0; ay = 0;
			bx = 9; by = 9;
			list = new LinkedList<node>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= M; i++)
			{
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= M; i++)
			{
				B[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken())-1; // X 좌표
				int Y = Integer.parseInt(st.nextToken())-1; // Y 좌표
				int C = Integer.parseInt(st.nextToken()); // 범위
				int P = Integer.parseInt(st.nextToken()); // 파워
				list.offer(new node(Y, X, C, P));
			}
			for(int i = 0; i <= M; i++)
			{
				ay += dy[A[i]]; ax += dx[A[i]];
				by += dy[B[i]]; bx += dx[B[i]];
				ans = 0;
				if(list.size() == 1)
				{
					// 사이즈가 1일때 하나만 선택하게끔 처리해야함, 이부분 안했을시 테스트케이스 (49/50) -> Fail
					int ad = (int)Math.abs(ax - list.get(0).x) + Math.abs(ay - list.get(0).y);
					int bd = (int)Math.abs(bx - list.get(0).x) + Math.abs(by - list.get(0).y);
					ad = (ad<=list.get(0).c)?list.get(0).p:0;
					bd = (bd<=list.get(0).c)?list.get(0).p:0;
					ans = Math.max(ans, Math.max(ad, bd));
				}
				else
				{
					for(int k = 0; k < list.size(); k++)
					{
						comb(k);
					}
				}
				result += ans;
			}
			bw.write("#" + ++t_num + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
