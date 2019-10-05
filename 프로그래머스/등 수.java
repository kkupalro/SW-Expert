package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int score[] = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
	static int dp[];
	static int k = 2;
	static HashMap<Integer, Integer> hm;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dp = new int[score.length];
		dp[0] = 0;
		hm = new HashMap<Integer,Integer>();
		for(int i = 1; i < score.length; i++)
		{
			dp[i] = score[i-1] - score[i];
			if(hm.containsKey(dp[i]))
			{
				hm.put(dp[i], hm.get(dp[i]) + 1);
			}
			else hm.put(dp[i], 1);
		}
		for(int i = 0; i < dp.length; i++)
		{
			if(hm.containsKey(dp[i]))
			{
				if(hm.get(dp[i]) >= k)
				{
					score[i-1] = -1;
					score[i] = -1;
				}
			}
		}
		int result = 0;
		for(int i = 0; i < score.length; i++)
		{
			if(score[i] >= 0)
			{
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
