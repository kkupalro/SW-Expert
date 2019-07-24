package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class D6 {
	static String matrix[];
	
	static Vector<String> v;
	static int last_idx;
	static int M;
	final static int MAX_SIZE = 56; 
	final static String S_CODE[] = {"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"}; // 0, 1 , 2, 3, 4, 5, 6, 7, 8, 9 
	
	// 암호화 코드 값 변환 함수
	static int solve(String str) {
		int ans = 0;
		for(int i=0; i<S_CODE.length; i++) {
			if(str.equals(S_CODE[i])) {
				ans = i;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		int N = 0;
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 배열 행 크기 : N
			M = Integer.parseInt(st.nextToken()); // 배열 열 크기 : M
			
			matrix = new String[N];
			
			
			
			v = new Vector<String>();
			last_idx = 0;
			// 입력 받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), "");
				matrix[i]=st.nextToken();
			}
			
			
			loop: // break시 for문 완전 빠져나옴
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					// 1이 있는지 검사
					if(String.valueOf(matrix[i].charAt(j)).equals("1")) {
						
						// 암호코드 형식 올바른지 검사
						if(matrix[i].equals(matrix[i+1])) {
							for(int l=0; l<M; l++) {
								if(matrix[i].charAt(l) == '1') {
									last_idx = l+1;
								}
							}
							// 56번 벡터에 저장함
							for(int m=last_idx-MAX_SIZE; m<last_idx; m=m+7) {
								v.add(matrix[i].substring(m, m+7));
							} 
							
							break loop; // 반복문 빠져나옴
							
						} // end 암호코드 형식 검사
					} // end 1이 있는지 검사
				}
			}
			
			// 암호코드 검증 알고리즘
			
			int result = 0;
			int res = 0;
			int temp = 0;
			
			for(int i=0; i<8; i++) {
				// 짝수
				if(i%2==0) {
					temp = solve(v.get(i));
					res += temp;
					result += temp * 3;
					
				}
				// 홀수
				else if(i%2==1){
					temp = solve(v.get(i));
					res += temp;
					result += solve(v.get(i));
				}
			}
			
			if(result%10 != 0) {
				res = 0;
			}
			
			
			System.out.println("#" + ++t_num + " " + res);
		}
		br.close();
	}

}

