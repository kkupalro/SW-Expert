class Solution {
    static final int A[] = {1,2,3,4,5};
    static final int B[] = {2,1,2,3,2,4,2,5};
    static final int C[] = {3,3,1,1,2,2,4,4,5,5};
    static int answer[];
    public int[] solution(int[] answers) {
        int ans[] = new int[3];
        for(int i = 0; i < answers.length; i++)
        {
            if((A[i%A.length]) == answers[i]) ans[0]++;
            if((B[i%B.length]) == answers[i]) ans[1]++;
            if((C[i%C.length]) == answers[i]) ans[2]++;
        }
        int res = Math.max(ans[0], Math.max(ans[1], ans[2]));
        int size = 0;
        for(int i = 0; i < 3; i++)
        {
            if(res == ans[i])
            {
                size++;
            }
        }
        if(size == 0)
        {
            answer = new int[3];
            answer[0] = 1; answer[1] = 2; answer[2] = 3;
        }
        else
        {
            answer = new int[size];
            size = 0;
            for(int i = 0; i < 3; i++)
            {
                if(res == ans[i])
                {
                    answer[size++] = i+1; 
                }
            }
        }
        return answer;
    }
}
