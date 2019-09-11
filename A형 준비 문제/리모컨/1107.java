package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean able[] = new boolean[10];
	static int result = 100;
	static int len = 0;
	static void solve(int idx, String s) {
		if(s.length() == len + 1)
		{
			result = Math.min(result, s.length() + Math.abs(N-Integer.parseInt(s)));
			return;
		}
		else if(s.length() == len)
		{
			result = Math.min(result, s.length() + Math.abs(N-Integer.parseInt(s)));
		}
		else if(s.length() == len - 1)
		{
			result = Math.min(result, s.length() + Math.abs(N-Integer.parseInt(s)));
		}
		for(int i = 0; i < 10; i++)
		{
			if(able[i]) continue;
			solve(i, s + i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		len = String.valueOf(N).length();
		M = Integer.parseInt(br.readLine());
		if(M > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) 
			{
				able[Integer.parseInt(st.nextToken())] = true;
			}
		}
		result = Math.abs(N - result);
		for(int i = 0; i < 10; i++)
		{
			if(able[i]) continue;
			solve(i, i+"");
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
