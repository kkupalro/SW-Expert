package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static final int MAX = 500001;
	static int a[] = new int[MAX];
	static int b[] = new int[MAX];
	static long result;
	static void merge(int l, int r) {
		if(l == r) return;
		int mid = (l + r) >> 1;
		merge(l, mid);
		merge(mid+1, r);
		int ll = l, rr = mid+1, go = l;
		while(ll <= mid && rr <= r)
		{
			if(a[ll] <= a[rr])
			{
				b[go++] = a[ll++];
			}
			else
			{
				result += Math.abs(rr - go);
				b[go++] = a[rr++];
			}
		}
		while(ll <= mid)
		{
			b[go++] = a[ll++];
		}
		while(rr <= r)
		{
			result += Math.abs(rr - go);
			b[go++] = a[rr++];
		}
		for(int i = l; i <= r; i++)
		{
			a[i] = b[i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			a[i] = Integer.parseInt(st.nextToken());
		}
		merge(1, N);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

