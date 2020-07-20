package TEST;

public class Main {
	static boolean visit[];
	static int input[] = {1,2,3,4,5,6};
	static int result;
	static void solve(int input_idx, int a_idx, int a[]) {
		a[a_idx] = input[input_idx];
		// 기저 사례
		if(a_idx == input.length-1)
		{
			// 계산
			int ans = 0;
			for(int i = 0; i < a.length-1; i++)
			{
				ans += Math.abs(a[i] - a[i+1]);
			}
			result = Math.max(ans, result);
			return;
		}
		for(int i = 0; i < a.length; i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			solve(i, a_idx + 1, a);
			visit[i] = false;
		}
	}
	public static void main(String[] args) {
		visit = new boolean[input.length];
		for(int i = 0; i < input.length; i++)
		{
			visit[i] = true;
			solve(i, 0, new int[input.length]);
			visit[i] = false;
		}
		System.out.println(result);
	}
}
