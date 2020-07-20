package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3 {
	static int matrix[][];
	final static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	final static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	// 8방향: 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t_num = 0; // 출력용 번호
		
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 배열 크기
			int M = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수
			matrix = new int[N][N];
			
			
			// 초기화 작업
			for(int row[]: matrix) {
				Arrays.fill(row, 0);
			}
			
			// 정가운데 흰흑돌 배치
			int center = (N/2)-1;
			matrix[center][center] = 2;
			matrix[center][center+1] = 1;
			matrix[center+1][center] = 1;
			matrix[center+1][center+1] = 2;
			
			int x = 0; // x좌표
			int y = 0; // y좌표
			int type = 0; // 돌 타입
			int nx = 0;
			int ny = 0;
			
			int w = 0; // 흰돌 수
			int b = 0; // 흑돌 수
			
			for(int i=0; i<M; i++) {
				// 돌을 놓을 차례
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken())-1;
				y = Integer.parseInt(st.nextToken())-1;
				type = Integer.parseInt(st.nextToken());
				matrix[y][x] = type;

				for(int k=0; k<8; k++) {
					nx = x + dx[k];
					ny = y + dy[k];
					while(nx>=0 && ny >=0 && nx < N && ny < N && matrix[ny][nx] != type && matrix[ny][nx] != 0) {
						nx += dx[k];
						ny += dy[k];
					}
					if(nx<0 || ny < 0 || nx >= N || ny >= N || matrix[ny][nx] == 0) {
						continue;
					}
					while(nx != x || ny != y) {
						nx -= dx[k];
						ny -= dy[k];
						matrix[ny][nx] = type;
					}
				}
			}
			
			// 해결방법  : 1.가로 , 2.세로 , 3.대각선 비교
		
			
			
			
			
			// 갯수 카운트
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(matrix[i][j]==1) {
						b+=1;
					}
					else if(matrix[i][j]==2){
						w+=1;
					}
					
				}
			}
			
			System.out.println("#" + ++t_num + " " + b + " " + w);
		}
		br.close();
	}
}
