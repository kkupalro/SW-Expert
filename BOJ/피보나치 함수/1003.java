import java.io.*;

public class Main {
	static int T, N;
	static int z[] = new int[41];
	static int o[] = new int[41];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		z[0] = 1; z[1] = 0;
		o[0] = 0; o[1] = 1;
		for(int i = 2; i < 41; i++)
		{
			z[i] = z[i-2] + z[i-1];
			o[i] = o[i-2] + o[i-1];
		}
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());
			bw.write(z[N] + " " + o[N] +"\n");
		}
		bw.flush();
		bw.close();
	}
}
