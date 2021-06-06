class Solution {
      static StringBuilder sb = new StringBuilder();
  final static String pattern = "[~!@#$%\\\\^&*\\\\(\\\\)=+\\\\[\\\\{\\\\]\\\\}:?,<>/]";
    public String solution(String new_id) {
        String answer = "";
        sb = new StringBuilder(
        sb.append(new_id.toLowerCase())
        .toString().replaceAll(pattern, ""));
    
    // 3단계
    while(sb.toString().contains("..")) {
      sb = new StringBuilder(
          sb.toString().replace("..", "."));
    }
    
    // 4단계
    sb = (!sb.toString().isEmpty() && sb.toString().charAt(0)=='.')?sb.deleteCharAt(0):sb;
    sb = (!sb.toString().isEmpty() && sb.toString().charAt(sb.length()-1)=='.')?sb.deleteCharAt(sb.length()-1):sb;
    if(!sb.toString().isEmpty()) {
      sb = sb.toString().charAt(sb.length()-1) == '.'?sb.deleteCharAt(sb.length()-1):sb;
    }
    // 5단계
    sb = sb.toString().isEmpty()?sb.append("a"):sb;
    
    // 6단계
    sb = sb.length()>=16?new StringBuilder(sb.substring(0, 15).toString()):sb;
    sb = sb.toString().charAt(sb.length()-1)=='.'?sb.deleteCharAt(sb.length()-1):sb;

    // 7단계
    while(sb.length() < 3) {
      sb.append(sb.charAt(sb.length()-1));
    }
        return sb.toString();
    }
}