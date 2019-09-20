package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int P[] = new int[11];
	static boolean map[] = new boolean[11];
	static int result = Integer.MAX_VALUE;
	static LinkedList<Integer> adj[] = new LinkedList[11];
	static boolean find(int from, int to, LinkedList<Integer> list , boolean v[][]) {
		// from : 현재 구역 , to : 목표 구역
		// from 구역에 to로 가는 선이 있으면 가능 
		if(adj[from].contains(to))
		{
			return true;
		}
		// from 구역에 to로 가는 선이 없을 경우
		for(int i = 0; i < adj[from].size(); i++)
		{
			// from 구역에서 다른 구역으로 가는 모든 선들을 탐색
			int data = adj[from].get(i);
			if(list.contains(data))
			{
				// 해당 선거구에 해당되고 방문되지 않은 구역만 탐색
				if(v[data][to] || v[to][data]) continue;
				v[data][to] = true; // 방문 처리
				v[to][data] = true;
				return find(data, to, list, v);
			}
		}
		return false;
	}
	static void check(int idx) {
		// (map = true) - > A 구역, (map = false) -> B 구역
		if(idx == N)
		{
			LinkedList<Integer> A = new LinkedList<Integer>();
			LinkedList<Integer> B = new LinkedList<Integer>();
			for(int i = 1; i <= N; i++)
			{
				if(map[i])
				{
					A.offer(i);
				}
				else if(!map[i])
				{
					B.offer(i);
				}
			}
			// 무조건 A OR B 한표 씩
			if(A.size() == 0 || B.size() == 0) return;
			// A 투표자
			for(int i = 0; i < A.size(); i++)
			{
				for(int j = 0; j < A.size(); j++)
				{
					if(i==j) continue;
					boolean visit[][] = new boolean[N+1][N+1];
					if(!find(A.get(i), A.get(j), A, visit))
					{
						return;
					}
				}
			}
			// B 투표자
			for(int i = 0; i < B.size(); i++)
			{
				for(int j = 0; j < B.size(); j++)
				{
					if(i==j) continue;
					boolean visit[][] = new boolean[N+1][N+1];
					if(!find(B.get(i), B.get(j), B, visit))
					{
						return;
					}
				}
			}
			// 각 투표수 차 
			int ans = 0; 
			for(int i = 0; i < A.size(); i++)
			{
				ans += P[A.get(i)];
			}
			for(int i = 0; i < B.size(); i++)
			{
				ans -= P[B.get(i)];
			}
			result = Math.min(result, Math.abs(ans));
			return;
		}
		// 순서 없는 조합
		check(idx+1);
		map[idx+1] = true;
		check(idx+1);
		map[idx+1] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i <= 10; i++)
		{
			adj[i] = new LinkedList<>();
		}
		for(int i = 1; i <= N; i++)
		{
			P[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++)
			{
				adj[i].offer(Integer.parseInt(st.nextToken()));
			}
		}
		// 순서 없는 조합
		check(1);
		map[1] = true;
		check(1);
		map[1] = false;
		result = (result==Integer.MAX_VALUE)?-1:result;
		bw.write(result + "\n");
		bw.flush();
	}
}
