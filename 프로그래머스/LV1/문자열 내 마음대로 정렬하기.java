class Solution {
  public String[] solution(String[] strings, int n) {
      // 버블 정렬
      for(int i = 0; i < strings.length; i++)
      {
          for(int j = i+1; j < strings.length; j++)
          {
              // 더 클 경우
              if(strings[i].charAt(n) > strings[j].charAt(n))
              {
                  // swap
                  String temp = strings[i];
                  strings[i] = strings[j];
                  strings[j] = temp;
              }
              // 같을 경우
              else if(strings[i].charAt(n) == strings[j].charAt(n))
              {
                  if(strings[i].compareTo(strings[j]) > 0)
                  {
                      // swap
                      String temp = strings[i];
                      strings[i] = strings[j];
                      strings[j] = temp;   
                  }
              }
          }
      }
      return strings;
  }
}
