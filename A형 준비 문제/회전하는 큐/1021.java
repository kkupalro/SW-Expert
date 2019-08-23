package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int result;
	static Queue<Integer> q = new LinkedList<Integer>();
	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++)
		{
			dq.offer(i);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++)
		{
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!q.isEmpty())
		{
			int num = q.poll();
			loop:
			while(dq.contains(num)) 
			{
				if(dq.getFirst() == num)
				{
					dq.pollFirst();
				}
				else {
					int cnt = 0;
					Iterator<Integer> it = dq.iterator();
					while(it.hasNext())
					{
						if(num == it.next())
						{
							if(cnt > dq.size() - cnt)
							{
								// 3.
								while(dq.getFirst() != num)
								{
									int last = dq.pollLast();
									dq.offerFirst(last);
									result++;
								}
								continue loop;
							}
							else {
								// 2.
								while(dq.getFirst() != num)
								{
									int first = dq.pollFirst();
									dq.offerLast(first);
									result++;
								}
								continue loop;
							}
						}
						else {
							cnt++;
						}
					}
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
