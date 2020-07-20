import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(arr[0]);
        for(int i = 1; i < arr.length; i++)
        {
            if(st.peek() == arr[i]) continue;
            else st.push(arr[i]);
        }
        int[] answer = new int[st.size()];
        int idx = st.size()-1;
        while(!st.isEmpty())
        {
            answer[idx--] = st.pop();
        }
        return answer;
	}
}
