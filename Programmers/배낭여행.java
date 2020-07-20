import java.io.*;
import java.util.*;

class Main {
	static int W[] = new int[20]; // 무게
	static int C[] = new int[20]; // 가격
	static int result, N, weight;
	static void solve(int idx, int ans, int w) {
		result = Math.max(result, ans);
		for(int i = idx+1; i < N; i++)
		{
			if(W[i] <= w)
			{
				solve(i, ans + C[i], w - W[i]);
			}
		}
	}
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
		weight = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			if(W[i] <= weight)
			{
				solve(i, C[i], weight-W[i]);
			}
		}
		bw.write(result + "");
		bw.flush();
		bw.close();
  }
}
