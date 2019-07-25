package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int t_num = 0;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (o1 > o2)
					{
						return -1;
					}
					else if(o1 < o2)
					{
						return 1;
					}
					return 0;
				}
			});
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
			{
				pq.add(Integer.parseInt(st.nextToken()));
			}
			int result = 0;
			for(int i = 0; i < K; i++)
			{
				result += pq.poll();
			}
			System.out.printf("#%d %d\n", ++t_num, result);
		}
	}
}
