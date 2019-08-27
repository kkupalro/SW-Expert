package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, B, C;
	static int A[];
	static long result;
	static void print(int a[][]) {
		for(int i = 0; i <= N+1; i++)
		{
			for(int j = 0; j <= N+1; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // �����夷��
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result = N; // �� �ѹ��� �ְ����� ������ ������
		for(int i = 0; i < N; i++)
		{
			A[i] -= B;
			if(A[i] <= 0) continue;
			// 999995 / 7 = 142856.0 (X)
			// 999995 / 7 = 142857.0 (O)
			result += Math.ceil(A[i]/(C*1.0));
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}