package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static long result = 0;
	static final String color[] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		result = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i >= 0; i--)
		{
			sb.append(br.readLine());
			for(int j = 0; j < 10; j++)
			{
				if(color[j].equals(sb.toString()))
				{
					result += j * (long) Math.pow(10, i);
					sb.setLength(0);
					break;
				}
			}
		}
		sb.append(br.readLine());
		for(int i = 0; i < 10; i++)
		{
			if(color[i].equals(sb.toString()))
			{
				result *= (long) Math.pow(10, i);
				sb.setLength(0);
				break;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
