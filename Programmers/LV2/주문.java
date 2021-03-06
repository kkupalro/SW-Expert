package TEST;

import java.io.*;

public class Main {
	static int result = Integer.MAX_VALUE;
	static int input[] = {1,2,3,1,2,2,3};
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i < input.length; i++)
		{
			if(result == 1) break;
			for(int j = i-1; j >= 0; j--)
			{
				if(i-j > result) break;
				if(input[j] == input[i])
				{
					result = Math.min(result, i-j);
					break;
				}
			}
		}
		result = (result==Integer.MAX_VALUE)?-1:result;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
