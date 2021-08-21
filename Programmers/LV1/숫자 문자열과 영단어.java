class Solution {
    static String engWord[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    
    public int solution(String s) {
        for (int i = 0; i < engWord.length; i++) {
			s = s.replace(engWord[i], String.valueOf(i));
		}
    
        return Integer.parseInt(s);
    }
}