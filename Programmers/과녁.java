package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int target[] = {2,2,2,2,2};
	static int positions[][] = {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}};
	static int dp[];
	static int result;
	static int ans[];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ans = new int[positions.length];
		
		dp = new int[5];
		dp[0] = target[0];
		for(int i = 1; i < 5; i++)
		{
			dp[i] = target[i] + dp[i-1];
		}
		for(int i = 0; i < 5; i++)
		{
			dp[i] *= dp[i];
		}
		for(int i = 0; i < 5; i++)
		{
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < positions.length; i++)
		{
			int x = positions[i][0];
			int y = positions[i][1];
			int dist = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
			if(dist >= 0 && dist <= dp[0])
			{
				result += 10;
			}
			else if(dist > dp[0] && dist <= dp[1])
			{
				result += 8;
			}
			else if(dist > dp[1] && dist <= dp[2])
			{
				result += 6;
			}
			else if(dist > dp[2] && dist <= dp[3])
			{
				result += 4;
			}
			else if(dist > dp[3] && dist <= dp[4])
			{
				result += 2;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
