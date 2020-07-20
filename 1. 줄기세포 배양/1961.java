package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5 {
	static String matrix[][];
	static String temp[][]; // 90, 270도 변환전 배열
	static String r1[][]; // 90도 배열
	static String r2[][]; // 180도 배열
	static String r3[][]; // 270도  배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int N = 0;
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken()); // 배열  크기 : N * N
			
			matrix = new String[N][N];
			temp = new String[N][N];
			r1 = new String[N][N];
			r2 = new String[N][N];
			r3 = new String[N][N];

			// 배열 초기화
			for(String row[]: r1) {
				Arrays.fill(row, "0");
			}
			for(String row[]: r2) {
				Arrays.fill(row, "0");
			}
			for(String row[]: r3) {
				Arrays.fill(row, "0");
			}
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					matrix[i][j] = st.nextToken();
				}
			}
			
			//  90도 270도 회전하기전 좌우 대칭 알고리즘
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp[i][j] = matrix[j][i];
				}
			}
			
			// 90도 알고리즘
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					r1[i][j] = temp[i][N-j-1];
				}
			}
			
			// 180도 알고리즘
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					r2[i][j] = matrix[N-i-1][N-j-1];
				}
			}
			
			// 270도 알고리즘
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					r3[i][j] = temp[N-i-1][j];
				}
			}
			
			// 출력
			System.out.println("#" + ++t_num);
			for(int i=0; i<N; i++) {
				// 90도
				for(int j=0; j<N; j++) {
					System.out.print(r1[i][j]);
				}
				System.out.print(" ");
				// 180도
				for(int j=0; j<N; j++) {
					System.out.print(r2[i][j]);
				}
				System.out.print(" ");
				// 270도
				for(int j=0; j<N; j++) {
					System.out.print(r3[i][j]);
				}
				System.out.println();
			}
		}
		br.close();
	}
}
