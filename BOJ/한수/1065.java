package TEST;

import java.io.*;

public class Main {
	static int N;
	static boolean han[] = new boolean[1001];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i < 100; i++)
		{
			han[i] = true;
		}
		for(int i = 111; i <= 1000; i++)
		{
			if(i % 100 == 0) continue;
			int num = i;
			int a = num / 100; // 100의 자리
			num %= 100; // 2자리수만 남음
			int b = num / 10; // 10의 자리
			int c = num % 10; // 1의 자리
			if(a-b == b-c)
			{
				han[i] = true;
			}
		}
		// 계산 부문
		for(int i = 0; i <= N; i++)
		{
			if(han[i]) result++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
