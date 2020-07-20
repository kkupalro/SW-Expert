package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class D4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0; i < N; i++)
		{
			v.add(Integer.parseInt(st.nextToken()));
		}
		v.sort(null);
		int center = N / 2;
		System.out.println(v.get(center));
		v.clear();
	}
}
