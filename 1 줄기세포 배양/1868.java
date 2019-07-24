package D9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 전역 변수
	static String matrix[][];
	static boolean map[][];
	static int count = 0;
	static int N;
	final static int dx[] = { -1, 0, 1, -1, 1,-1, 0, 1};	// 1 2 3
	final static int dy[] = { -1,-1,-1,  0, 0, 1, 1, 1}; 	// 4   5
															// 6 7 8
	
	static void solve(int x, int y, int n) {		
		/* 
		 * n = 1 : 주변 지뢰 계수 저장
		 * n = 2 : 주변 지뢰 0일 경우 처리 -> 8방향 방문 저장
		 */
		
		int s_cnt = 0; // 8방향 지뢰 카운트 변수
		
		// 1. 주변 지뢰 몇개인지 변환
		if(n==1) {
			for(int l = 0; l<8; l++) {
				int nx = x + dx[l];
				int ny = y + dy[l];
				if(nx<0 || nx>N-1 || ny<0 || ny>N-1)
					continue;
				if(matrix[nx][ny].equals("*")) {
						s_cnt +=1;
				}
			}
			matrix[x][y] = Integer.toString(s_cnt);
		}
		
		// 2. 주변 죄뢰 0일 경우 8방향 방문 저장, 만약 8방향에 0이 있을 경우 -> 연쇄 방문 저장
		else if(n==2) {
			map[x][y] = true;
			for(int l = 0; l<8; l++) {
				int nx = x + dx[l];
				int ny = y + dy[l];
				if(nx<0 || nx>N-1 || ny<0 || ny>N-1)
					continue;
				if(matrix[nx][ny].equals("0") && !map[nx][ny]) {
					// 방문하지 않았을경우 재귀 호출 
					solve(nx, ny, 2);
				}
				else if(!matrix[nx][ny].equals("*")) {
					// 방문
					map[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 행렬 크기
			matrix = new String[N][N]; // 입력 배열
			map = new boolean[N][N]; // 방문 여부 배열
			count = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String str = st.nextToken();
				for(int j=0; j<N; j++) {
					matrix[i][j] = String.valueOf(str.charAt(j));
				}
			}
			
			// 주변 지뢰 몇개인지 저장
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!matrix[i][j].equals("*") && matrix[i][j].equals(".")) {
						solve(i,j,1);
					}
				}
			}
			
			// 0 일 경우 처리
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(matrix[i][j].equals("0") && !map[i][j]) {
						solve(i,j,2);
						// 조건에 맞을 경우 연쇄 방문후 카운트 증가
						count+=1;
					}
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!matrix[i][j].equals("*") && !map[i][j]) {
						// 지뢰가 아니며 0이아니고 연쇄 방문되지 않은 나머지들 카운트
						count+=1;
					}
				}
			}
			
			// 출력
			System.out.println("#" + ++t_num + " " + count);
		}	
		br.close();
	}
}
