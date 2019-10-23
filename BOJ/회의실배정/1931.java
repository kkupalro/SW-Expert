import java.io.*;
import java.util.*;

class node {
	int s; int d;
	node(int s, int d){
		this.s = s;
		this.d = d;
	}
}

public class Main {
	static int N;
	static node T[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		T = new node[N];
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(T, new Comparator<node>() {
			@Override
			public int compare(node n1, node n2) {
				if(n1.d == n2.d)
				{
					return n1.s - n2.s;
				}
				return n1.d - n2.d;
			}
		});
		int start = 0;
		for(int i = 0; i < T.length; i++)
		{
			if(start <= T[i].s)
			{
				start = T[i].d;
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}

