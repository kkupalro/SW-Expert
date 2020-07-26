import java.util.*;

class Solution {
    static Stack<Integer> st = new Stack<Integer>();
    static int tmp;
    static int x;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int k = 0; k < moves.length; k++) {
			x = moves[k]-1;
			tmp = 0;
			for (int i = 0; i < board.length; i++) {
				if(board[i][x] != 0) {
					tmp ^= board[i][x];
					board[i][x] ^= tmp;
                    tmp ^= board[i][x];
                    
                    if(!st.isEmpty() && st.peek() == tmp) {
						st.pop();
						answer+=2;
					}
                    else {
                        st.push(tmp);
                    }
					break;
				}
			}
		}
        return answer;
    }
}