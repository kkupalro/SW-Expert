package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int A[];
	static int B[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			B[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i = 0; i < N; i++)
		{
			result += A[i] * B[N-i-1];
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
