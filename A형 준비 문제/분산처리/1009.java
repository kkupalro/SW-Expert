package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static long result, A, B;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			result = 1;
			for(int i = 1; i <= B; i++)
			{
				result = (result * A) % 10; 
			}
			if(result == 0)
			{
				result = 10;
			}
			bw.write(result + "\n");
			result = 0;
		}
		bw.flush();
		bw.close();
	}
}
