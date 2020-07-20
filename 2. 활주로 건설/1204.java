package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D3 {
	static int N;
	static HashMap<Integer, Integer> hm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 출력용 번호
			
			hm = new HashMap<Integer, Integer>();
			st = new StringTokenizer(br.readLine());
			int count = 0; // 1000명의 학생 카운트
			int Answer = 0;  // 가장큰 빈도수의 점수 : 키 값
			int max_cnt = 0; // 가장 큰 빈도수 
			while(count < 1000) {
				int score = Integer.parseInt(st.nextToken());
				if(hm.containsKey(score)) {
					hm.put(score, hm.get(score)+1);
					if(max_cnt <= hm.get(score)) {
						max_cnt = hm.get(score);
						Answer = score;
					}
				}
				else {
					hm.put(score, 1);
				}
				count +=1;
			}
			System.out.printf("#%d %d\n", N, Answer);
		}
		br.close();
	}
}
