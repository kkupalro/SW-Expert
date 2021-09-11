package pro;

import java.util.HashSet;
import java.util.Set;

public class Main {
	static int answer;
	static void comb(int idx, int cnt, int k, int[] student) {
		// 기저 조건
		if(cnt == k) {
			answer++;
		}
		if(idx >= student.length-1) {
			return;
		}

		idx++;
		comb(idx, student[idx]==1?cnt+1:cnt, k, student);
		
	}

	
	static int solution(int[] student, int k) {
		for (int i = 0; i < student.length; i++) {
			// 조합
			comb(i, student[i]==1?1:0, k, student);
		}
		
		
		return answer;
		
	}
	
	public static void main(String[] args) throws Exception {
		int[] student = {0,1,0,0};
		int k = 1;
		System.out.println(solution(student, k));
		

	}


}