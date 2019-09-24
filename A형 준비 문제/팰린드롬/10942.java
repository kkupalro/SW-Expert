package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, S, E;
	static int dp[][] = new int[2005][2005];
	static int array[] = new int[2005];
	static void f(int left, int right) {
		if(left < 1 || right > N) return;
		if(array[left-1] == array[right+1])
		{
			dp[left-1][right+1] = 1;
			f(left-1, right+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++)
		{
			dp[i][i] = 1;
			f(i, i);
			if(i < N && array[i] == array[i+1])
			{
				dp[i][i+1] = 1;
				f(i, i+1);
			}
		}
		M = Integer.parseInt(br.readLine());
		while(M-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			bw.write(dp[S][E] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
