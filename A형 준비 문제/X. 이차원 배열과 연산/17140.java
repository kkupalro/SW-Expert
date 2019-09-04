package TEST;

import java.io.*;
import java.util.*;

class node implements Comparable<node> {
	int key; int value;
	node(int key, int value)
	{
		this.key = key;
		this.value = value;
	}
	@Override
	public int compareTo(node target) {
		if(this.value > target.value)
		{
			return 1;
		}
		else if(this.value < target.value)
		{
			return -1;
		}
		return this.key - target.key;
	}
}

public class Main {
	static final int MAX = 101;
	static int matrix[][] = new int[101][101];
	static int cnt[];
	static int R, C, K, result;
	static int Y = 3;
	static int X = 3;
	static void print(int a[][]) {
		for(int i = 1; i <= Y; i++)
		{
			for(int j = 1; j <= X; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	static PriorityQueue<node> sort() {
	    PriorityQueue<node> q = new PriorityQueue<node>();
	    for (int i = 1; i <= 100; i++) {
	      if (cnt[i] > 0) {
	        q.add(new node(i, cnt[i]));
	      }
	    }
	    return q;
	}
	static int row() {
		int r = 1;
		for (int i = 1; i <= Y; i++) {
		      cnt = new int[101];
		      for (int j = 1; j <= X; j++) {
		        cnt[matrix[i][j]]++;
		      }
		      PriorityQueue<node> q = sort();
		      int k = 1;
		      while (!q.isEmpty()) {
		        node n= q.poll();
		        matrix[i][k] = n.key;
		        matrix[i][k+1] = n.value;
		        k += 2;
		        if (k > 100) break;
		      }
		      for (int j = k; j < 101; j++) {
		        matrix[i][j] = 0;
		      }
		      r = Math.max(r, k);
		    }
		return r;
	}
	static int col() {
	    int c = 1;
	    for (int i = 1; i <= X; i++) {
	      cnt = new int[101];
	      for (int j = 1; j <= Y; j++) {
	        cnt[matrix[j][i]]++;
	      }
	      PriorityQueue<node> q = sort();
	      int k = 1;
	      while (!q.isEmpty()) {
	        node n = q.poll();
	        matrix[k][i] = n.key;
	        matrix[k+1][i] = n.value;
	        k += 2;
	        if (k > 100) break;
	      }
	      for (int j = k; j < 101; j++) {
	        matrix[j][i] = 0;
	      }
	      c = Math.max(c, k);
	    }
	    return c;
	  }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // Y 좌표
		C = Integer.parseInt(st.nextToken()); // X 좌표
		K = Integer.parseInt(st.nextToken()); // K 값
		for(int i = 1; i <= Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(matrix[R][C] != K)
		{
			if(Y >= X)
			{
				X = row();
			}
			else
			{
				Y = col();
			}
			result++;
			if(result > 100)
			{
				result = -1;
				break;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
