class Solution {
    static int solution(String plain) {
        int answer = plain.length();
        for (int i = 0; i < answer; i++) {
            String subPlain = plain.substring(i);
            if (isPalindrome(subPlain, subPlain.length())) {
                answer += i;
                return answer;
            }
        }
        return answer;
    }

    // FIXME : 남은문자열 팰린드롬인지 확인
    static boolean isPalindrome(String plain, int len) {
        for (int i = 0; i < len/2; i++) {
            if (plain.charAt(i) != plain.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}