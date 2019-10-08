class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase(); // 소문자 변환
        int cnt = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'p')
            {
                cnt++;
            }
            else if(s.charAt(i) == 'y')
            {
                cnt--;
            }
        }
        answer = (cnt == 0)?true:false;
        return answer;
    }
}
