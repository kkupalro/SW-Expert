package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, K, target;
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++)
		{
			list.offer(i);
		}
		// 1 2 3 4 5 6 7
		while(!list.isEmpty())
		{
			// 0 + 3-1 = 2  ->  2 % 7 = 2 
			// 1 2 4 5 6 7
			// 2 + 3-1 = 4  ->  4 % 6 = 4
			// 1 2 4 5 7
			// 4 + 3-1 = 6  ->  6 % 5 = 1
			// 1 4 5 7
			// 1 + 3-1 = 3  ->  3 % 4 = 3
			// 1 4 5
			// 3 + 3-1 = 5  ->  5 % 3 = 2
			// 1 4
			// 2 + 3-1 = 4  ->  4 % 2 = 0
			// 4
			// 0 + 3-1 = 2  ->  2 % 1 = 0
			// 
			target = (target + K-1) % list.size();
			q.offer(list.remove(target));
		}
		bw.write("<");
		while(!q.isEmpty())
		{
			if(q.size() == 1)
			{
				bw.write(q.poll() + ">\n");
			}
			else
			{
				bw.write(q.poll() + ", ");
			}
		}
		bw.flush();
		bw.close();
	}
}