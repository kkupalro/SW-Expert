class Solution {
	final static char word[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static boolean check[];
    
    public String solution(String sentence) {
		String answer = "";
		sentence = sentence.toLowerCase();
		check = new boolean[word.length];
		for (char c : sentence.toCharArray()) {
			// TODO : 알파벳 여부 검사
			for (int i = 0; i < word.length; i++) {
				if(c == word[i]) {
					check[i] = true;
				}
			} 
		}
		
		// TODO : 사용 여부 확인
		for (int i = 0; i < check.length; i++) {
			if(!check[i]) {
				answer += word[i];
			}
		}
		
        return answer.length()==0?"perfect":answer;
    }
}