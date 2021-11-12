class Solution {
	public String solution(String s) {
		String answer = "";
		String arr[] = s.split(" ", -1);
		
		for (int i = 0; i < arr.length; i++) {
			int idx = 0;
			String word = "";
			for (char c : arr[i].toCharArray()) {
				if(idx % 2 == 0) {
					word += String.valueOf(c).toUpperCase();
				} else {
					word += String.valueOf(c).toLowerCase();
				}
				idx++;
			}
			if(i == 0) {
				answer += word;
			} else {
				answer += " " + word;
			}
		}
		return answer;
	}
}