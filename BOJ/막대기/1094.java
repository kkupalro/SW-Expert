package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int result, X;
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
		X = Integer.parseInt(br.readLine());
		int size = 64;
		int sum = 0;
		while(true)
		{
			if(X == 64)
			{
				result++;
				break;
			}
			if(sum == X)
			{
				break;
			}
			size /= 2;
			if(sum + size <= X)
			{
				result++;
				sum += size;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
