package TEST;

import java.io.*;
import java.util.*;

class node implements Comparable<node> {
	int w; int c;
	node(int w, int c) {
		this.w = w;
		this.c = c;
	}
	@Override
	public int compareTo(node target) {
		return this.w - target.w;
	}
}

public class Main {
	static final int MAX = 300000;
	static int N, K;
	static long result;
	static node J[] = new node[MAX];
	static int B[] = new int[MAX];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // º¸¼®ÀÇ °¹¼ö
		K = Integer.parseInt(st.nextToken()); // °¡¹æÀÇ °¹¼ö
		result = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			J[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
		}
		for(int i = 0; i < K; i++)
		{
			B[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(J, 0, N);
		Arrays.sort(B, 0, K);
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int i = 0; i < K; i++)
		{
			while(idx < N && J[idx].w <= B[i])
			{
				pq.offer(J[idx++].c);
			}
			if(!pq.isEmpty())
			{
				result += pq.poll();
			}
		}
		bw.write(result +"\n");
		bw.flush();
		bw.close();
	}
}
