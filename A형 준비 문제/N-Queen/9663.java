import java.io.*;

public class Main {
	static boolean matrix[][];
	static int N, result;
	static boolean one(int y, int x) {
		// 1. 가로
		for(int i = 0; i < N; i++)
		{
			if(i == x) continue;
			if(matrix[y][i])
			{
				return false;
			}
		}
		return true;
	}
	static boolean two(int y, int x) {
		// 2. 세로
		for(int i = 0; i < N; i++)
		{
			if(i == y) continue;
			if(matrix[i][x])
			{
				return false;
			}
		}
		return true;
	}
	static boolean three(int y, int x) {
		// 3. / 대각선
		int r = y;
		int c = x;
		while(true)
		{
			r--; c++;
			if(r < 0 || c > N-1) break;
			if(matrix[r][c])
			{
				return false;
			}
		}
		while(true)
		{
			r++; c--;
			if(r > N-1 || c < 0) break;
			if(matrix[r][c])
			{
				return false;
			}
		}
		return true;
	}
	static boolean four(int y, int x) {
		// 4. \ 대각선
		int r = y;
		int c = x;
		while(true)
		{
			r--; c--;
			if(r < 0 || c < 0) break;
			if(matrix[r][c])
			{
				return false;
			}
		}
		while(true)
		{
			r++; c++;
			if(r > N-1 || c > N-1) break;
			if(matrix[r][c])
			{
				return false;
			}
		}
		return true;
	}
	static void solve(int y) {
		if(y == N)
		{
			result++;
			return;
		}
		for(int i = 0; i < N; i++)
		{
			if(matrix[y][i]) continue;
			if(one(y,i) && two(y,i) && three(y,i) && four(y,i))
			{
				matrix[y][i] = true;
				solve(y + 1);
				matrix[y][i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		matrix = new boolean[N][N];
		solve(0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
