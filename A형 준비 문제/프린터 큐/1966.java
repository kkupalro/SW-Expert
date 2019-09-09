package TEST;

import java.io.*;
import java.util.*;

class node {
	int impact; int check;
	node(int impact, int check){
		this.impact = impact;
		this.check = check;
	}
}
public class Main {
	static int T, N, M;
	static ArrayDeque<node> dq;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dq = new ArrayDeque<node>();
			st = new StringTokenizer(br.readLine(), " ");
			result = 0;
			for(int i = 0; i < N; i++)
			{
				if(i == M)
				{
					dq.offer(new node(Integer.parseInt(st.nextToken()), 1));
				}
				else
				{
					dq.offer(new node(Integer.parseInt(st.nextToken()), 0));
				}
			}
			while(!dq.isEmpty())
			{
				boolean flag = false;
				node cur = dq.poll();
				node res = cur;
				Iterator<node> it = dq.iterator();
				while(it.hasNext())
				{
					node prev = it.next();
					if(prev.impact > res.impact)
					{
						flag = true;
						res = prev;
					}
				}
				if(!flag)
				{
					result += 1;
					if(cur.check == 1)
					{
						break;
					}
					else continue;
				}
				else
				{
					if(res.check == 1)
					{
						result += 1;
						break;
					}
					dq.offerLast(cur);
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
