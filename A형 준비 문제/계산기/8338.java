package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int T, N, t_num, result;
	static int matrix[];
	static void solve(int cnt, int data) {
		int idx = cnt;
		if(cnt == 0)
		{
			solve(cnt + 1, data);
			return;
		}
		if(cnt == N-1)
		{
			result = Math.max(result, Math.max(data * matrix[idx], data + matrix[idx]));
			return;
		}
		
		solve(cnt + 1, Math.max(data + matrix[idx], data * matrix[idx]));
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());
			matrix = new int[N];
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
			{
				matrix[i] = Integer.parseInt(st.nextToken());
			}
			if(N == 1)
			{
				bw.write("#" + ++t_num + " " + matrix[0] + "\n");
			}
			else {
				solve(0, matrix[0]);
				bw.write("#" + ++t_num + " " + result + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

