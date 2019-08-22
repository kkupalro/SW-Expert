package TEST;

import java.io.*;

public class Main {
	static final String plo[] = {"AAAA", "BB"};
	static final String X[] = {"XXXX", "XX"};
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = new String(br.readLine());
		for(int i = 0; i < 2; i++)
		{
			while(s.contains(X[i]))
			{
				s = s.replace(X[i], plo[i]);
			}
		}
		if(s.contains("X"))
		{
			bw.write(-1 + "\n");
		}
		else {
			bw.write(s + "\n");
		}
		bw.flush();
		bw.close();
	}
}
