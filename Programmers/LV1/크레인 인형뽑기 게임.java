import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<Integer>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
			int x = moves[i] - 1;
			for (int y = 0; y < board.length; y++) {
				if(board[y][x] > 0) {
					if(!stack.isEmpty()) {
						if(stack.peek() == board[y][x]) {
							stack.pop();
							answer += 2;
						} else {
							stack.push(board[y][x]);
						}
					} else {
						stack.push(board[y][x]);
					}
					board[y][x] = 0;
					break;
				}
			}
		}
        return answer;
    }
}