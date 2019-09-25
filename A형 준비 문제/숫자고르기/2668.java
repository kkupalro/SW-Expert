package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int arr[] = new int[101];
	static boolean visit[] = new boolean[101];
	static ArrayList<Integer> list = new ArrayList<>();
	private static void solve(int idx, int start) {
		if(!visit[arr[idx]])
		{
			visit[arr[idx]] = true;
			solve(arr[idx], start);
			visit[arr[idx]] = false;
		}
		if(arr[idx] == start)
		{
			list.add(start);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= N; i++)
		{
			visit[i] = true;
			solve(i, i);
			visit[i] = false;
			
		}
		Collections.sort(list);
		bw.write(list.size() + "\n");
		for(int i = 0; i < list.size(); i++)
		{
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}

