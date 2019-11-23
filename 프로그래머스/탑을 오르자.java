package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int input[] = {0, 1, 2, 3, 4, 8, 9, 11};
	static boolean result = false;
	static void solve(int k, int idx) {
		if(idx >= input.length-1)
		{
			result = true;
			return;
		}
		for(int i = k; i <= k+1; i++)
		{			
			for(int index = idx; index < input.length; index++)
			{
				if(input[index] == input[idx] + i)
				{
					solve(i, index);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		solve(1, 1);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
