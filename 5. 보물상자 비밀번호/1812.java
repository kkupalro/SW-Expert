package D12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node implements Comparable<node> {
	int x; int y; int size;
	node(int size) {
		this.size = size;
	}
	node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(node target) {
		return target.size >= size ? 1:-1;
	}	
}

public class D12 {
	static PriorityQueue<node> pq;
	static ArrayList<node> ar;
	static int M;
	static int result = 1;
	static void solve() {
		loop:
		while(!pq.isEmpty())
		{
			int max_idx = ar.size();
			int size = pq.poll().size;
			int idx = 0;
			node temp;
			for(int i = 0; i < max_idx; i++)
			{
				temp = ar.get(idx);
				if(temp.x >= size && temp.y >= size)
				{
					if(temp.x - size > 0 && size > 0)
					{
						ar.add(new node(temp.x - size, size));
					}
					if(temp.x > 0 && temp.y - size > 0)
					{
						ar.add(new node(temp.x, temp.y - size));
					}
					ar.remove(temp);
					idx--;
					continue loop;
				}
				idx++;
			}
			result++;
			ar.add(new node(M - size, size));
			ar.add(new node(M, M - size));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 필요한 정사각형 갯수
			M = Integer.parseInt(st.nextToken()); // 판매중인 M크기의 정사각형 타월
			pq = new PriorityQueue<node>();
			ar = new ArrayList<node>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
			{
				int w = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
				pq.add(new node(w));
			}
			ar.add(new node(M,M));
			solve();
			System.out.printf("#%d %d\n", ++t_num, result);
			result = 1;
		}
		br.close();
	}
}
