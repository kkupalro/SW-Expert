class Solution {
    static long t[] = {1L, 1024L, 1048576L, 1073741824L, 1099511627776L};
    
    public long solution(String[] units, long[] numbers) {
        long answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            int idx = 0;
            if (units[i].equals("B")) {
                answer += numbers[i] * t[0];
            } else if (units[i].equals("KB")) {
                answer += numbers[i] * t[1];
            } else if (units[i].equals("MB")) {
                answer += numbers[i] * t[2];
            } else if (units[i].equals("GB")) {
                answer += numbers[i] * t[3];
            }else if (units[i].equals("TB")) {
                answer += numbers[i] * t[4];
            }
        }
        
        return answer;
    }
}