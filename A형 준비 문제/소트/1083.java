package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int matrix[] = new int[50];
	static int N, S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
		{
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
		{
			int max = Integer.MIN_VALUE;
			int max_idx = Integer.MIN_VALUE;
			for(int j = i, cnt = 0; j < N && cnt <= S; j++, cnt++)
			{
				if(max < matrix[j])
				{
					max = matrix[j];
					max_idx = j;
				}
			}
			for(int j = max_idx; j > i; j--)
			{
				if(S == 0) break;
				int temp = matrix[j];
				matrix[j] = matrix[j-1];
				matrix[j-1] = temp;
				S--;
			}
		}
		for(int i = 0; i < N; i++)
		{
			bw.write(matrix[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}
