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
			int a = num / 100; // 100�� �ڸ�
			num %= 100; // 2�ڸ����� ����
			int b = num / 10; // 10�� �ڸ�
			int c = num % 10; // 1�� �ڸ�
			if(a-b == b-c)
			{
				han[i] = true;
			}
		}
		// ��� �ι�
		for(int i = 0; i <= N; i++)
		{
			if(han[i]) result++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
