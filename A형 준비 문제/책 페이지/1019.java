package TEST;

import java.io.*;

public class Main {
	static int N, num;
	static int data = 1;
	static int dp[] = new int[10];
	static void solve(int n) {
		while(n > 0)
		{
			dp[n % 10] += data;
			n /= 10;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int s = 1;
		int e = N;
		while(s <= e)
		{
			while(s%10 != 0 && s <= e) 
			{
				solve(s);
				s++;
			}
			if(s > e)
			{
				break;
			}
			while(e%10 != 9 && s <= e)
			{
				solve(e);
				e--;
			}
			
			s /= 10;
			e /= 10;
			for(int i = 0; i < 10; i++)
			{
				dp[i] += (e-s+1) * data;
			}
			data *= 10;
		}
		for(int i = 0; i < 10; i++)
		{
			bw.write(dp[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
