package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	static int pi[];
	static StringBuilder text = new StringBuilder();
	static StringBuilder pattern = new StringBuilder();
	static void getPi() {
		int len = pattern.length();
		pi = new int[len];
		pi[0] = 0;
		int j = 0;
		for(int i = 1; i < len; i++)
		{
			while(pattern.charAt(i) != pattern.charAt(j))
			{
				if(j == 0)
				{
					pi[i] = j;
					break;
				}
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				pi[i] = ++j;
			}
		}
	}
	static void kmp() {
		int j = 0; 
		int t_len = text.length(); 
		int p_len = pattern.length();
		for(int i = 0; i < t_len; i++)
		{
			while(text.charAt(i) != pattern.charAt(j))
			{
				if(j == 0)
				{
					break;
				}
				j = pi[j-1];
			}
			if(text.charAt(i) == pattern.charAt(j)) 
			{
				j++;
				if(j == p_len)
				{
					dq.offer(i-p_len+2);
					j = pi[j-1];
				}
			}
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		text.append(br.readLine());
		pattern.append(br.readLine());
		getPi();
		kmp();
		bw.write(dq.size() + "\n");
		while(!dq.isEmpty())
		{
			bw.write(dq.poll() + " ");
		}
		bw.flush();
		bw.close();
	}
}
