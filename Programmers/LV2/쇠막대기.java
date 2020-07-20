import java.util.*;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> st = new Stack<Character>();
        st.push(arrangement.charAt(0));
        for(int i = 1; i < arrangement.length(); i++)
        {
            if(arrangement.charAt(i) == ')')
            {
                if(arrangement.charAt(i-1) == '(')
                {
                    // 레이져(pop) -> (현대 쇠막대기 수 절단 = 쇠막대기 수 만큼 증가)
                    st.pop();
                    answer += st.size();
                }
                else if(arrangement.charAt(i-1) == ')')
                {
                    // 쇠막대기 끝 -> 현재 쇠막대기 수 감소 (pop)
                    st.pop();
                    answer += 1;
                }
            }
            else st.push(arrangement.charAt(i));
        }
        return answer;
    }
}
