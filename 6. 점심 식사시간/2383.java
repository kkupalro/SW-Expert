package TEST;

import java.io.*;
import java.util.*;

class Stair {
	int y; int x; int c;
	Stair(int y, int x, int c) {
		this.y = y;
		this.x = x;
		this.c = c;
	}
}

class People {
	int y; int x; int stair; int wait; int dist; int time;
	People(int y, int x, int stair, int wait, int dist, int time) {
		this.y = y;
		this.x = x;
		this.stair = stair;
		this.wait = wait;
		this.dist = dist;
		this.time = time;
	}
}

public class Main {
	static final int SIZE = 11;
	static int T, N, t_num, result;
	static boolean visit[];
	static LinkedList<Stair> S;
	static LinkedList<People> P;
	static void solve() {
		PriorityQueue<People> pq = new PriorityQueue<People>(new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				if(o1.time == o2.time)
				{
					return o1.dist - o2.dist;
				}
				return o1.time - o2.time;
			}
		});
		
		for(int i = 0; i < P.size(); i++)
		{
			People p = P.get(i);
			int dist = 0;
			if(visit[i])
			{
				dist = Math.abs(p.x - S.get(0).x) + Math.abs(p.y - S.get(0).y);
				pq.offer(new People(p.y, p.x, 0, 0, dist, 0));
			}
			else
			{
				dist = Math.abs(p.x - S.get(1).x) + Math.abs(p.y - S.get(1).y);
				pq.offer(new People(p.y, p.x, 1, 0, dist, 0));
			}
		}
		int time = 0;
		int space[] = new int[2]; // 계단1, 계단2 공간
		while(!pq.isEmpty())
		{
			People p = pq.poll();
			time = p.time;
			if(p.dist >= time)
			{
				pq.offer(new People(p.y, p.x, p.stair, p.wait, p.dist, p.time + 1));
				continue;
			}
			// 계단 내려감
			if(p.wait != 0)
			{
				if(p.wait == S.get(p.stair).c)
				{
					space[p.stair]--;
					continue;
				}
				pq.offer(new People(p.y, p.x, p.stair, p.wait + 1, p.dist, p.time + 1));
				continue;
			}
			if(space[p.stair] == 3)
			{
				pq.offer(new People(p.y, p.x, p.stair, p.wait, p.dist, p.time + 1));
			}
			else
			{
				space[p.stair]++;
				pq.offer(new People(p.y, p.x, p.stair, p.wait + 1, p.dist, p.time + 1));
			}
		}
		result = Math.min(result, time);
	}
	static void dfs(int idx) {
		// 기저 사례
		if(idx == P.size())
		{
			solve();
			return;
		}
		visit[idx] = true;
		dfs(idx + 1);
		visit[idx] = false;
		dfs(idx + 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			S = new LinkedList<Stair>();
			P = new LinkedList<People>();
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
				{
					int num = Integer.parseInt(st.nextToken());
					if(num > 1)
					{
						S.offer(new Stair(i, j, num));
					}
					else if(num == 1)
					{
						P.offer(new People(i, j, 0, 0, 0, 0));
					}
				}
			}
			visit = new boolean[P.size()];
			dfs(0);
			bw.write("#" + ++t_num + " " + result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
