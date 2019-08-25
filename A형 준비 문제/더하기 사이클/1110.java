package TEST;

import java.io.*;

public class Main {
	static int result, N, M;
	static void print(int p[][])
	{
		for(int i = 0; i < p.length; i++)
		{
			for(int j = 0; j < p[i].length; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine()); // 26
		int a = -1, b = -1, sum = N;
		while(true)
		{
			a = sum / 10; // 2, 6 
			b = sum % 10; // 6, 8
			sum = a + b; // 8, 14
			if(sum >= 10)
			{
				sum %=10; // 4
			}
			b = b * 10; // 60, 80
			sum = b + sum; // 68, 84 
			result++; // 1
			if(sum == N)
			{
				break;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
