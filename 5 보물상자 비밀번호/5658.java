package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class D2 {
	static final String code[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	static String matrix[];
	static Vector<Integer> v;
	static int result = 0;
	static int K;
	static int N;
	static void save(int len) {
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < N; j++)
		{
			sb.append(matrix[j]);
			if(sb.length() == len)
			{
				int value = 0;
				int cnt = 0;
				for(int i = len-1; i>=0; i--)
				{
					if(cnt == 0)
					{
						value += HtoB(String.valueOf(sb.charAt(i)));
					}
					else {
						value += HtoB(String.valueOf(sb.charAt(i))) * (int) Math.pow(16, len-i-1);
					}
					cnt++;
				}
				if(!v.contains(value))
				{
					v.add(value);
				}
				sb.toString();
			}
		}
	}
	static int HtoB(String hex) {
		for(int i = 0; i < code.length; i++)
		{
			if(hex.equals(code[i]))
			{
				return i;
			}
		}
		return 0;
	}
	static void solve(){
		int len = N/4;
		for(int i = 0; i < N; i++)
		{
			if(i != 0)
			{
				String temp1 = matrix[0];
				String temp2 = matrix[N-1];
				matrix[0] = temp2;
				for(int j = 1; j < N; j++)
				{
					temp2 = matrix[j];
					matrix[j] = temp1;
					temp1 = temp2;
				}
			}
			save(len);
		}
		v.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
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
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int t_num = 0;
		StringTokenizer st;
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
			K = Integer.parseInt(st.nextToken());  // 크기 순서
			matrix = new String[N];
			v = new Vector<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder(st.nextToken());
			for(int i = 0; i < N; i++)
			{
				
				matrix[i] = Character.toString(sb.charAt(i));
			}
			solve();
			System.out.printf("#%d %d\n", ++t_num, v.get(K-1));
		}
		br.close();
	}
}
