package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int arr[][][] = new int[2][2][100];
	static int N, result;
	static void solve(int arr_idx, int tmp_idx) {
		if(arr_idx >= N)
		{
			return;
		}
		arr[1][0][tmp_idx] = arr_idx+1;
		arr[0][1][tmp_idx] = arr[0][0][arr_idx];
		int temp[] = new int[tmp_idx+1];
		for(int i = 0; i <= tmp_idx; i++)
		{
			temp[i] = arr[0][1][i];
		}
		Arrays.sort(temp);
		boolean flag = true;
		int cnt = 0;
		for(int i = 0; i <= tmp_idx; i++)
		{
			if(temp[i] == arr[1][0][i])
			{
				cnt++;
			}
			else flag = false;
		}
		if(flag)
		{
			if(cnt > result)
			{
				for (int i = 0; i <= tmp_idx; i++) 
				{
					arr[1][1][i] = temp[i];
				}
				result = cnt;
			}
		}
		solve(arr_idx+1, tmp_idx+1);
		solve(arr_idx+2, tmp_idx+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++)
		{
			arr[0][0][i-1] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N; i++)
		{
			solve(i, 0);
		}
		bw.write(result + "\n");
		for(int i = 0; i < result; i++)
		{
			bw.write(arr[1][1][i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
