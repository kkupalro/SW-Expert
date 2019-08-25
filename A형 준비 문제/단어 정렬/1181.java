package TEST;

import java.io.*;
import java.util.*;

class word implements Comparable<word> {
	String data; int len;
	word(String data, int len)
	{
		this.data = data;
		this.len = len;
	}
	@Override
	public int compareTo(word target) {
		return this.len - target.len;
	}
}

public class Main {
	static int result;
	static String matrix[][] = new String[50][20001];
	static int N;
	static HashSet<String> set = new HashSet<String>();
	static void print(int p[][])
	{
		for(int i = 1; i < p.length; i++)
		{
			for(int j = 1 ; j < p[i].length; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 이부분에 로직 구현
				if(o1.length() > o2.length())
				{
					return 1;
				}
				else if(o2.length() > o1.length())
				{
					return -1;
				}
				else if(o1.length() == o2.length())
				{
					int len = o1.length();
					int a = 0;
					int b = 0;
					for(int i = 0; i < len; i++)
					{
						a = (int)o1.charAt(i);
						b = (int)o2.charAt(i);
						if(a > b)
						{
							return 1;
						}
						else if(b > a)
						{
							return -1;
						}
						else continue;
					}
					
				}
				return 0;
			}
		});
		while(N-- > 0)
		{
			String check = br.readLine();
			if(pq.contains(check)) continue;
			pq.offer(check);
		}
		while(!pq.isEmpty())
		{
			bw.write(pq.poll() + "\n");
		}
		bw.flush();
		bw.close();
	}
}

