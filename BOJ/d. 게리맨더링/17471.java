package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 11;
	static int result = Integer.MAX_VALUE;
	static int N;
	static int P[] = new int[MAX];
	static boolean map[] = new boolean[MAX];
	static boolean matrix[][] = new boolean[MAX][MAX];
	static void cal() {
		int ans = 0;
		for(int i = 1; i <= N; i++)
		{
			if(map[i])
			{
				ans += P[i];
			}
			else
			{
				ans -= P[i];
			}
		}
		result = Math.min(result, Math.abs(ans));
	}
	static boolean connected(LinkedList<Integer> list, boolean v[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(list.get(0));
		v[list.get(0)] = true;
		int cnt = 1;
		while(!q.isEmpty())
		{
			int n = q.poll();
			for(int i = 1; i <= N; i++)
			{
				if(matrix[n][i] && list.contains(i) && !v[i])
				{
					v[i] = true;
					cnt++;
					q.offer(i);
				}
			}
		}
		return (list.size()==cnt)?true:false;
	}
	static boolean check() {
		LinkedList<Integer> A = new LinkedList<>();
		LinkedList<Integer> B = new LinkedList<>();
		for(int i = 1; i <= N; i++)
		{
			if(map[i])
			{
				A.add(i);
			}
			else B.add(i);
		}
		if(A.size() == 0 || B.size() == 0) return false;
		boolean visit[] = new boolean[MAX];
		return (connected(A, visit)&&connected(B, visit))?true:false;
	}
	static void comb(int idx) {
		if(idx >= N)
		{
			if(check())	cal();
			return;
		}
		comb(idx + 1);
		map[idx+1] = true;
		comb(idx + 1);
		map[idx+1] = false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
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
				matrix[i][Integer.parseInt(st.nextToken())] = true;
			}
		}
		// 순서 없는 조합
		comb(1);
		map[1] = true;
		comb(1);
		result = (result==Integer.MAX_VALUE)?-1:result;
		bw.write(result + "\n");
		bw.flush();
	}
}
