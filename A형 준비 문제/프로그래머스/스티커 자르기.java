package TEST;

import java.io.*;

public class Main {
	static int sticker[] = {1};
	static int arr[];
	static int result = 0;
	static void solve(int idx, int ans) {
		for(int i = idx+2; i < sticker.length; i++)
		{
			solve(i, ans+sticker[i]);
		}
		result = Math.max(result, ans);
		return;
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[sticker.length];
		for(int i = 0; i < sticker.length; i++)
		{
			arr[i] = sticker[i];
		}
		if(arr.length == 1)
		{
			solve(0, sticker[0]);
		}
		else
		{
			solve(0, sticker[0]);
			solve(1, sticker[1]);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
