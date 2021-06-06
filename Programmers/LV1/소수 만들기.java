class Solution {
    static int answer = 0;
    
    static void isPrime(int sum){
        int i =  (int) Math.sqrt(sum);
            for(;i>1 ; i-- ) {
            if(sum%i==0) break;
            }
            if(i==1) {
                answer++;
                return;
            }
    }
    
    static void dfs(int cnt, int idx, int sum, int[] nums){
        // 기저조건
        if(cnt == 3){
            int i =  (int) Math.sqrt(sum);
            for(;i>1 ; i-- ) {
            if(sum%i==0) break;
            }
            if(i==1) {
                answer++;
                return;
            }
        }
        
        for(int i = idx; i < nums.length; i++){
            dfs(cnt + 1, i + 1, sum + nums[i], nums);
        }
    }
    
    public int solution(int[] nums) {
        int cnt = 0;
        int sum = 0;
        // bruth force
        for(int i = 0; i < nums.length; i++){
            cnt = 1;
            sum = nums[i];
            for(int j = i+1; j < nums.length; j++){
                cnt++;
                sum += nums[j];
                for(int k = j+1; k < nums.length; k++){
                    cnt++;
                    sum += nums[k];
                    if(cnt == 3){
                        isPrime(sum);
                    }
                    sum -= nums[k];
                    cnt--;
                }
                cnt--;
                sum -= nums[j];
            }
           
            // dfs(1, i + 1, nums[i], nums);
        }
        return answer;
    }
}