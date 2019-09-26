package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static final String STR = "666";
	static int N, cnt; 
	static int result, data;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		while(true)
		{
			sb.append(data++);
			if(sb.toString().contains(STR))
			{
				if(++cnt >= N) 
				{
					bw.write(sb.toString() + "\n");
					break;
				}
			}
			sb.setLength(0);
		}
		sb.setLength(0);
		bw.flush();
		bw.close();
	}
}
