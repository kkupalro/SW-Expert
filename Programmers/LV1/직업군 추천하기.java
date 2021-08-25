import java.util.StringTokenizer;
import java.util.TreeMap;

class Solution {
    static int maxScore = Integer.MIN_VALUE;
    
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		
		for (int i = 0; i < table.length; i++) {
			StringTokenizer st = new StringTokenizer(table[i]);
			String key = st.nextToken();
			int cnt = st.countTokens();
			int score = 0;
			while(st.hasMoreTokens()) {
				String code = st.nextToken();
				for (int j = 0; j < languages.length; j++) {
					if(code.equals(languages[j])){
						score += preference[j] * cnt;
					}
				}
				cnt--;
			}
			maxScore = Math.max(maxScore, score);
			treeMap.put(key, score);
		}
		
		for (String k : treeMap.keySet()) {
			if(treeMap.get(k) == maxScore) {
				answer = k;
				break;
			}
		}
        return answer;
    }
}