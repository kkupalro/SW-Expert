import java.io.*;
import java.util.*;

class Solution {
    static Stack<Character> st = new Stack<>();
	static char cur = ' ';
	static int idx = 0;
    public int solution(String S) {
        int result = 0;
        for(int i = 0; i < S.length(); i++)
		{
			st.push(S.charAt(i));
			if(cur == st.peek())
			{
				idx++;
			}
			else
			{
				cur = st.peek();
				idx = 1;
			}
			
			if(idx == 3)
			{
				result = Math.max(result, st.size()-1);
				// 처음부터 i-1 ~ i 까지 재삽입
				st.clear();
				for(int j = i-1; j <= i ; j++)
				{
					st.push(S.charAt(j));
				}
				idx--;
			}
			result = Math.max(result, st.size());
		}
		return result;
    }
}
