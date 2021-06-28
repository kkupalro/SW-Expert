import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0627|BOJ|A-SA 문제집-2|1018
 *
 */
public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static ArrayList<String> al = new ArrayList<String>();
	static boolean matrix[][];
	static boolean board[][][] = new boolean[2][8][8];

	static void solve(int y, int x) {
		int w = 0;
		int b = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (matrix[y + i][x + j] != board[0][i][j])
					w++;
				if (matrix[y + i][x + j] != board[1][i][j])
					b++;
			}
		}
		result = Math.min(result, Math.min(w, b));
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new boolean[N][M];

		// board 정의
		boolean flag = true;
		for (int i = 0; i < 8; i++) {
			flag ^= true;
			for (int j = 0; j < 8; j++) {
				board[0][i][j] = flag;
				flag ^= true;
				board[1][i][j] = flag;
			}
		}

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j] = (sb.charAt(j) == 'B') ? true : false;
			}
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				solve(i, j);
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}