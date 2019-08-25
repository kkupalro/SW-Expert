package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int result;
	static int ans[];
	static int N, K, cnt, size;
	static void print(int a[])
	{
		System.out.print("<");
		for(int i = 0; i < a.length; i++)
		{
			if(i == a.length -1)
			{
				System.out.print(a[i] + ">\n");
			}
			else System.out.print(a[i] + ", ");
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		ans = new int[N];
		for(int i = 1; i <= N; i++)
		{
			list.offer(i);
		}
		int idx = 0;
		int s_idx = 0;
		while(list.size() > 0)
		{
			cnt = 0;
			size = list.size(); // 7
			while(true)
			{	
				if(cnt++ == K)
				{
					ans[idx++] = list.remove((s_idx + K -1) % size);
					s_idx = (s_idx + K - 1) % size;
					break;
				}
			}
		}
		print(ans);
		bw.flush();
		bw.close();
	}
}

