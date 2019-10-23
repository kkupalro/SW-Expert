package TEST;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static boolean matrix[][] = new boolean[8][8];
	static boolean mask[][] = new boolean[8][8];
	static int result;
	static StringBuilder sb = new StringBuilder();
	static void print(boolean p[][])
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
		StringTokenizer st = null;
		for(int i = 0; i < 8; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(st.nextToken());
			for(int j = 0; j < 8; j++)
			{
				if(sb.charAt(j) == 'F')
				{
					mask[i][j] = true;
				}
			}
			sb.setLength(0);
		}
		boolean flag = false;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				flag ^= true;
				matrix[i][j] = flag;
			}
			flag ^= true;
		}
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(matrix[i][j] && mask[i][j])
				{
					result++;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
