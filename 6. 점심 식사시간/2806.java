package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D5 {
	static boolean x[];
	static boolean inc[]; // / 대각선
	static boolean dec[]; // \ 대각선
	static int N;
	static int result = 0;
	static void solve(int y) {
		if(y == N)
		{
			result++;
			return;
		}
		for(int i = 0; i < N; i++)
		{
			if(!x[i] && !inc[y + i] && !dec[Math.abs(N+(y - i))])
			{
				x[i] = inc[y + i] = dec[Math.abs(N+(y - i))] = true;
				solve(y+1);
				x[i] = inc[y + i] = dec[Math.abs(N+(y - i))] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int t_num = 0;
		StringTokenizer st;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			x = new boolean[N];
			inc = new boolean[N*2];
			dec = new boolean[N*2];
			solve(0);
			System.out.printf("#%d %d\n", ++t_num, result);
			result = 0;
		}
		br.close();
	}
}
