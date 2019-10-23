import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int result = Integer.MAX_VALUE;
	static int dp[] = new int[1000001];
	static String ans = "use the stairs";
	static void solve() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		dp[S] = 1;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(cur == G)
			{
				// dp[S] = 1 부터 시작햇으므로 최종값에서 1을 뺌
				result = dp[cur]-1;
				return; 
			}
			if(cur + U <= F)
			{
				if(dp[cur + U] == 0)
				{
					dp[cur + U] = dp[cur] + 1;
					q.add(cur + U);
				}
			}
			if(cur - D > 0)
			{
				if(dp[cur - D] == 0)
				{
					dp[cur - D] = dp[cur] + 1;
					q.add(cur - D);
				}
			}			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		solve();
		if(result == Integer.MAX_VALUE) bw.write(ans + "\n");
		else bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}