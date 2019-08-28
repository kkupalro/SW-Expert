package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, count;
	static int A[];
	static int C[] = new int[4]; // 0: +, 1:-, 2:X, 3:/
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;
	static void print(int a[][]) {
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}
	static void copy(int a[], int b[]) {
		for(int i = 0; i < 4; i++)
		{
			a[i] = b[i];
		}
	}
	static void solve(int C_idx, int A_idx, long sum) {
		C[C_idx]--;
		int tmp[] = new int[4];
		copy(tmp, C);		
		if(C_idx == 0)
		{
			// +
			sum += A[A_idx]; 
		}
		else if(C_idx == 1)
		{
			// -
			sum -= A[A_idx];
		}
		else if(C_idx == 2)
		{
			// X
			sum *= A[A_idx];
		}
		else if(C_idx == 3)
		{
			// /
			sum /= A[A_idx];
		}
		
		if(A_idx >= N-1)
		{
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < C[i]; j++)
			{
				solve(i, A_idx+1, sum);
				copy(C, tmp);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++)
		{
			C[i] = Integer.parseInt(st.nextToken());
		}
		int temp[] = new int[4];
		copy(temp, C);
		int value = A[0];
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < C[i]; j++)
			{
				solve(i, 1, value);
				copy(C, temp);
			}
		}
		bw.write(max + "\n" + min + "\n");
		bw.flush();
		bw.close();
	}
}