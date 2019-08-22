package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int A = Integer.MAX_VALUE;
	static int B = Integer.MAX_VALUE;
	static int min = Integer.MAX_VALUE;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 필요한 기타줄
		M = Integer.parseInt(st.nextToken()); // 브랜드 갯수 
		// A : 6개인 최소 가격, B : 낱개인 최소 가격
		result = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		for(int i = 0 ; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			A = Math.min(A, Integer.parseInt(st.nextToken()));
			B = Math.min(B, Integer.parseInt(st.nextToken()));
		}
		// 끊어진줄 6개 이하일 시
		if(N <= 6)
		{
			result = Math.min(A, B*N);
		}
		// 그 외
		else {
			int sum = 0;
			int cnt = 0;
			while(N > sum)
			{
				if(cnt == 0)
				{
					result = Math.min(result, Math.min(A, B*6));
					cnt++;
					sum += 6;
				}
				else if(cnt > 0)
				{
					if(N - sum > 6)
					{
						min = Integer.MAX_VALUE;
						min = Math.min(min, Math.min(A, B*6));
						result += min;
						sum += 6;
					}
					else if(N - sum == 6)
					{
						min = Integer.MAX_VALUE;
						min = Math.min(min, Math.min(A, B*6));
						result += min;
						sum += 6;
					}
					else if(N - sum < 6)
					{
						if(A <= B*(N-sum))
						{
							result += A;
							sum += 6;
						}
						else if(A > B*(N-sum))
						{
							result += B*(N-sum);
							sum += (N - sum);
						}
					}
				}
			}
		}
		bw.write(result +"\n");
		bw.flush();
		bw.close();
	}
}
