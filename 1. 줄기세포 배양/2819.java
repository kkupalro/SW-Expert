package D8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{	
	// 전역 변수
	static String matrix[][];
	static Set<String> result;
	final static int dx[] = { 1,-1, 0, 0}; // 동 서 남 북
	final static int dy[] = { 0, 0, 1,-1};
	static void solve(int x, int y, int n, String s) {
		
		s += matrix[x][y];
		
		if(n==1) {
			if(s.length() == 7) {
				result.add(s);
			}
			return;
		}
		for(int l = 0; l<4; l++) {
				int nx = x + dx[l];
				int ny = y + dy[l];
				if(nx<0 || nx>3 || ny<0 || ny>3) {
					continue;
				}
				solve(nx, ny, n-1, s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t_num = 0; // 출력용 번호
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 갯수
		
		while(T-- > 0) {
			matrix = new String[4][4];
			result = new HashSet<String>();
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<4; j++) {
					matrix[i][j] = st.nextToken();
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					solve(i, j, 7, "");
				}
			}
			System.out.println("#" + ++t_num + " " + result.size());
			// 출력
		}	
		br.close();
		
	}
}
