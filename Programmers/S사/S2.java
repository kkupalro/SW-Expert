package pro;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int answer = -1;
	static boolean visit[];
	static int arr[];
	static int size;

	static int solution(int input[]) {
		size = input.length;
		visit = new boolean[size];
		arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[0] = input[i];
			comb(i, 1, input);
			visit[i] = false;
		}
		return answer;
	}

	static void comb(int idx, int cnt, int[] input) {
		
		// 기저 조건
		if(cnt == size) {
			answer = Math.max(answer, calc());
			return;
		}
		
		for (int i = 0; i < input.length; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[cnt] = input[i];
			comb(i, cnt + 1, input);
			visit[i] = false;
		}
	}

	static int calc() {
		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			result += Math.abs(arr[i-1] - arr[i]);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		int input[] = { 20, 1, 15, 8, 4, 10 };
		System.out.println(solution(input));
	}
}