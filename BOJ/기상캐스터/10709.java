import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author yoo
 * @commit 0904|BOJ|기상캐스터|10709
 *
 */

public class Main {
	static final int dy = 0;
	static final int dx = 1;
	static int H, W;
	static StringTokenizer st;
	static int matrix[][];
	static boolean visit[][];

	static void move(int y, int x, int t) {

		matrix[y][x] = t;

		int ny = y + dy;
		int nx = x + dx;
		if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
			return;
		}
		if (visit[ny][nx] || matrix[ny][nx] > -1) {
			return;
		}
		move(ny, nx, t + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		matrix = new int[H][W];
		visit = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				char c = str.charAt(j);
				matrix[i][j] = c == 'c' ? 0 : -1;
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (visit[i][j])
					continue;
				if (matrix[i][j] == 0) {
					visit[i][j] = true;
					move(i, j, 0);
				}
			}
		}

		// TODO 출력
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				bw.write(matrix[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}