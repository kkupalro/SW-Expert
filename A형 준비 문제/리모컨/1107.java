package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M; // N : 채널, M : 고장난 버튼의 개수
	static boolean able[] = new boolean[10]; // [0 ~ 9] 고장난 리모컨 값 배열
	static int result = 100; // 눌러진 횟수 
	static int len; // N의 길이
	static void solve(int idx, String ans) {
		if(ans.length() == len + 1)
		{
			result = Math.min(result, ans.length() + Math.abs(N-Integer.parseInt(ans)));
			return;
		}
		else if(ans.length() == len)
		{
			result = Math.min(result, ans.length() + Math.abs(N-Integer.parseInt(ans)));
		}
		else if(ans.length() == len - 1)
		{
			result = Math.min(result, ans.length() + Math.abs(N-Integer.parseInt(ans)));
		}
		for(int i = 0; i < 10; i++)
		{
			if(able[i]) continue;
			solve(i, ans + i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if(M > 0)
		{
			st = new StringTokenizer(br.readLine(), " "); // M 이 0 이상일 경우에만 입력 받음 -> 런타임 에러 방지 === 85%쯤 런타임 에러 뜸
			for(int i = 0; i < M; i++) 
			{
				able[Integer.parseInt(st.nextToken())] = true;
			}
		}
		result = Math.abs(N - result);
		len = String.valueOf(N).length();
		for(int i = 0; i < 10; i++)
		{
			if(able[i]) continue;
			solve(i, "" + i);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
