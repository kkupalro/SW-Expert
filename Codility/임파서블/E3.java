import java.io.*;

class Solution {
    static int u, l;
	static int c[];
	static int P[];
	static int M[][];
	static int result;
	static boolean visit1[];
	static boolean visit2[];
	static String S = "";
	static StringBuilder sb = new StringBuilder();
	static void comb1(int idx, int cnt) {
		if(cnt == u)
		{
			for(int i = 0; i < c.length; i++)
			{
				if(c[i] > 0)
				{
					if(visit2[i]) continue;
					M[1][i]++;
					c[i]--;
					visit2[i] = true;
					comb2(i, 1);
					visit2[i] = false;
					c[i]++;
					M[1][i]--;
				}
			}
			return;
		}
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] > 0)
			{
				if(visit1[i]) continue;
				M[0][i]++;
				c[i]--;
				visit1[i] = true;
				comb1(i, cnt + 1);
				visit1[i] = false;
				c[i]++;
				M[0][i]--;
			}
		}
	}
	static void comb2(int idx, int cnt) {
		if(cnt == l)
		{
			if(solve())
			{
				end();
			}
			return;
		}
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] > 0)
			{
				if(visit2[i]) continue;
				M[1][i]++;
				c[i]--;
				visit2[i] = true;
				comb2(i, cnt + 1);
				visit2[i] = false;
				c[i]++;
				M[1][i]--;
			}
		}
	}
	static void end() {
		S = "";
		for(int i = 0; i < 2; i++)
		{
			sb.setLength(0);
			for(int j = 0; j < c.length; j++)
			{
				sb.append(M[i][j]);
			}
			
			if(i == 0)
			{
				S += sb.toString() + ",";
			}
			else S += sb.toString();
		}
	}
	static boolean solve() {
		for(int i = 0; i < P.length; i++)
		{
			if(P[i] != M[0][i] + M[1][i])
			{
				return false;
			}
		}
		return true;
	}
    public String solution(int U, int L, int[] C) {
        visit1 = new boolean[C.length];
		visit2 = new boolean[C.length];
		M = new int[2][C.length];
		S = "IMPOSSIBLE";
		P = new int[C.length];
		c = new int[C.length];
		u = U;
		l = L;
		for(int i = 0; i < C.length; i++)
		{
		    c[i] = C[i];
		    P[i] = C[i];
		}
		for(int i = 0; i < C.length; i++)
		{
			if(S.equals("IMPOSSIBLE"))
			{
				if(c[i] > 0)
				{
					if(visit1[i]) continue;
					M[0][i]++;
					c[i]--;
					visit1[i] = true;
					comb1(i, 1);
					visit1[i] = false;
					c[i]++;
					M[0][i]--;
				}
			}
			
		}
        return S;
    }
}
