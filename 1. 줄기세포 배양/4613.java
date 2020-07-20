package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4 {
	static String matrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		while(T-- > 0) {
			int cnt = 0; // 새로 칠한 카운트 수
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); // 배열 행 크기 : 4
			int M = Integer.parseInt(st.nextToken()); // 배열 열 크기 : 5
			
			matrix = new String[N][M];
			
			// 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String str = st.nextToken();
				for(int j=0; j<M; j++) {
					matrix[i][j] = Character.toString(str.charAt(j));
				}
			}
			
			int min_cnt = Integer.MAX_VALUE; // 최소 카운트 변수
			int W =0, B = 0, R = 0; // 화이트, 블루, 레드 카운트 수
			
			// 알고리즘   
			for(int i=0; i < N-2; i++) { // 1, 2
				// 화이트
				for(int w=0; w<M; w++) {
					if(!matrix[i][w].equals("W")) {
						W +=1;
					}
				}
				
				for(int j=i+1; j<N-1; j++) { // 2, 1 
					// 블루
					for(int b=0; b<M; b++) {
						if(!matrix[j][b].equals("B")) {
							B +=1;
						}
					}
					
					for(int l=j+1; l<N; l++) { // 3
						// 레드
						for(int r=0; r<M; r++) {
							if(!matrix[l][r].equals("R")) {
								R +=1;
							}						
						}
					} // end l
					
					// 최소 카운트 비교 부문
					cnt = W + B + R;
					if(min_cnt >= cnt) {
						min_cnt = cnt;
					}
					
					// 각각의 초기화 작업을 안해서 값이 다르게나왔음.
					R = 0;						
				} // end j
				
				// 각각의 초기화 작업을 안해서 값이 다르게나왔음.
				B = 0;
				
			} // end i
			
			// 결과 출력
			System.out.println("#" + ++t_num + " " + min_cnt);
		}
		br.close();
	}
}
