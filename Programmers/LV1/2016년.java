import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Solution {
  static String solution(int a, int b) {
    Calendar cal = Calendar.getInstance();
    cal.set(2016, a - 1, b);
    Date date = cal.getTime();
    return new SimpleDateFormat("E", Locale.ENGLISH).format(date).toUpperCase();
  }
}