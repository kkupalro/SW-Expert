class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++)
        {
            int s = commands[i][0] - 1; // start
            int d = commands[i][1]; // end
            int s_idx = commands[i][2] - 1; // 인덱스
            int arr[] = new int[d - s];
            int idx = 0;
            for(int j = s; j < d; j++)
            {
                arr[idx++] = array[j];
            }
            // 버블 정렬
            for(int k = 0; k < arr.length; k++)
            {
                for(int j = k+1; j < arr.length; j++)
                {
                    if(arr[k] > arr[j])
                    {
                        arr[k] ^= arr[j];
                        arr[j] ^= arr[k];
                        arr[k] ^= arr[j];
                    }
                }
            }
            answer[i] = arr[s_idx];
        }
        return answer;
    }
}
