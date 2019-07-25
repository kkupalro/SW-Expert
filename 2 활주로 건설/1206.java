package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4 {
	static int T = 0;
	static int sum;
	static int ar[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max_v = 0;
		while( T++ < 10) 
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			// ÃÊ±âÈ­ ºÎ¹®
			ar = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			sum = 0;
			max_v = 0;
			for(int i = 0; i < N; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i < N-2; i++) {
				max_v = ar[i] - Math.max(Math.max(ar[i-1], ar[i-2]), Math.max(ar[i+1], ar[i+2]));			
				if(max_v > 0) {
					sum+= max_v;
				}
			}
			// Ãâ·Â ºÎ¹®
			System.out.printf("#%d %d\n", T, sum);
		}
	}
}

