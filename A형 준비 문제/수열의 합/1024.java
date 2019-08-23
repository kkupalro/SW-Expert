package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		boolean able = false;
		for(int i = L; i <= 100; i++)
		{
			if((N - (L*(L-1)/2)) / L >= 0 && ((N - (L*(L-1)/2)) % L == 0))
			{
				int x = ((N - (L*(L-1)) /2)) / L;
				for(int j = x; j < L + x; j++)
				{
					System.out.printf("%d ", j);
				}
				System.out.printf("\n");
				able = true;
				break;
			}
			L++;
		}
		if(!able) {
			System.out.printf("%d\n", -1);
		}
	}
}
