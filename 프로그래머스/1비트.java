import java.io.*;

class Main {
	static int result;
  public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int N = Integer.parseInt(br.readLine());
			while(N > 0)
			{
				if(N % 2 == 1)
				{
					result++;
				}
				N /= 2;
			}
			bw.write(result + "");
			bw.flush();
			bw.close();
  }
}
