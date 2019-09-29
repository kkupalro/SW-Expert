package TEST;

import java.io.*;

public class Main {
	static int result;
	static int N, num_idx, op_idx;
	static int num[];
	static char op[];
	static StringBuilder sb = new StringBuilder();
	static int calc(int a, int b, char o) {
		if(o == '+')
		{
			return a + b;
		}
		else if(o == '-')
		{
			return a - b;
		}
		else
		{
			return a * b;
		}
	}
	static void dfs(int ans, int idx) {
		// 기저 조건
		if(idx >= op_idx)
		{
			result = Math.max(result, ans);
			return;
		}
		int now = calc(ans, num[idx+1], op[idx]);
		dfs(now, idx+1);
		if(idx + 2 < num_idx)
		{
			int next = calc(num[idx+1], num[idx+2], op[idx+1]);
			now = calc(ans, next, op[idx]);
			dfs(now, idx+2);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		num = new int[(N/2) + 1];
		op = new char[N/2];
		sb.append(br.readLine());
		result = Integer.MIN_VALUE;
		for(int i = 0; i < sb.length(); i++)
		{
			if(i % 2 == 0)
			{
				num[num_idx++] = sb.charAt(i) - '0';
			}
			else op[op_idx++] = sb.charAt(i);
		}
		dfs(num[0], 0);
		bw.write(result + "\n");
		sb.setLength(0);
		bw.flush();
		bw.close();
	}
}
