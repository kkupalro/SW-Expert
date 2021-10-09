import java.util.*;

class Solution {
    final static String WORD[] = {"A", "E", "I", "O", "U"};
    final static int N = 5;
    static ArrayList<String> list = new ArrayList<String>();
    static void permutation(int idx, String s){
        list.add(s);
        // 기저 조건
        if(idx >= N){
            return;
        }
        for(int i = 0; i < WORD.length; i++){
            permutation(idx + 1, s + WORD[i]);
        }        
    }
    
    public int solution(String word) {
        /** TODO : 순열 */
        for(int i = 0; i < WORD.length; i++){
            permutation(1, WORD[i]);
        }
        return list.indexOf(word) + 1;
    }
}