import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
      static int winning(int num) {
    switch (num) {
    case 6:
      return 1;
    case 5:
      return 2;
    case 4:
      return 3;
    case 3:
      return 4;
    case 2:
      return 5;
    default:
      return 6;
    }
  }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<Integer> lotto = new ArrayList<Integer>(Arrays.stream(lottos)
                .boxed()
                .collect(Collectors.toList()));
        
        ArrayList<Integer> win_num = new ArrayList<Integer>(Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList()));
            
        lotto.sort(null);
        win_num.sort(null);

        int min = 0;
        int max = 0;
        
        // 초기
        for(int i = 0; i < lotto.size(); i++) {
          if(lotto.get(i) != 0 && win_num.contains(lotto.get(i))) {
            max++;
            min++;
            win_num.remove(lotto.get(i));
          } else if(lotto.get(i) == 0) {
            max++;
          }
        }
        answer.add(winning(max));
        answer.add(winning(min));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}