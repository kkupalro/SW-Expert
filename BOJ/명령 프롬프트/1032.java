package TEST;

import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String a = br.readLine();
		String b = "";
		String result = "";
		if(N <= 1) {
			result = a;
		}
		else {
			for(int i = 1; i < N; i++)
			{
				b = br.readLine();
				String tmp = "";
				for(int j = 0; j < a.length(); j++)
				{
					if(a.charAt(j) == b.charAt(j)) {
						tmp += a.charAt(j);
					}
					else {
						tmp += "?";
					}
				}
				a = tmp;
				result = tmp;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
