package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Long M;
	static int array[] = new int[10];
	static long result;
	static LinkedList<Integer> list = new LinkedList<>();
	static void solve(int size, int s, int l) {
		if(size == l)
		{
			if(l % 2 == 1)
			{
				long temp = 1;
				for(int i = 0; i < l; i++)
				{
					temp *= array[list.get(i) - 1];
				}
				result += (M / temp);
			}
			else
			{
				long temp = 1;
				for(int i = 0; i < l; i++)
				{
					temp *= array[list.get(i) - 1];
				}
				result -= (M / temp);
			}
			return;
		}
		for(int i = s + 1; i <= N; i++)
		{
			list.offer(i);
			solve(size + 1, i, l);
			list.pollLast();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			array[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				
				list.offer(j);
				solve(1, j, i);
				list.pollLast();
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

