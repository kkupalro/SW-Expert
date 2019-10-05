package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static String order_times[] = {"12:10", "12:20", "12:40", "12:40", "12:50", "13:00", "13:20"};
	static int k = 20;
	static int dp[];
	static int result;
	static int ans[];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ans = new int[order_times.length];
		StringTokenizer st = null;
		for(int i = 0; i < order_times.length; i++)
		{
			st = new StringTokenizer(order_times[i], ":");
			int h = Integer.parseInt(st.nextToken()) * 60;
			int m = Integer.parseInt(st.nextToken());
			ans[i] = h+m;
		}
		
		for(int i = 0; i < ans.length-1; i++)
		{
			int cnt = 1;
			int data = ans[i] + k;
			for(int j = i+1; j < ans.length; j++)
			{
				if(ans[j] <= data)
				{
					System.out.print(ans[j] + " ");
					cnt++;
				}
			}
			result = Math.max(cnt, result);
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
