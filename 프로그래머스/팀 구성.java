package TEST;

import java.io.*;

public class Main {
	static int vote[] = {2,3,1,5,6,4};
	static int result = 0;
	static int matrix[][];
	static boolean visit[];
	static void solve(int s, int idx, int cnt) {
		if(cnt == 2)
		{
			if(matrix[idx][s] == 1)
			{
				result++;
				return;
			}
		}
		else
		{
			for(int i = 0; i < matrix[idx].length; i++)
			{
				if(matrix[idx][i] == 1)
				{
					if(visit[i]) continue;
					visit[i] = true;
					solve(s, i, cnt+1);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		matrix = new int[vote.length][vote.length];
		for(int i = 0; i < vote.length; i++)
		{
			matrix[i][vote[i]-1] = 1;
		}
		visit = new boolean[vote.length];
		for(int i = 0; i < matrix.length; i++)
		{
			visit[i] = true;
			solve(i, i, 0);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
