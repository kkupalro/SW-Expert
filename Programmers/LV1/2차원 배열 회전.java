package L1;

public class Main {
  static int matrix[][];
  static int temp[][];
  static int copy[][];
  
  static int[][] rotate(int[][] arr, int degree) {
      int[][] rotate;
      int n = arr.length;
      int m = arr[0].length;

      switch (degree) {
          case 90:
          case 270:
              rotate = new int[m][n];
              break;
          case 180:
              rotate = new int[n][m];
              break;
          default:
              throw new IllegalArgumentException();
      }

      for (int i = 0; i < rotate.length; i++) {
          for (int j = 0; j < rotate[i].length; j++) {
              switch (degree) {
                  case 90:
                      rotate[i][j] = arr[n-1-j][i];
                      break;
                  case 180:
                      rotate[i][j] = arr[n-1-i][m-1-j];
                      break;
                  case 270:
                      rotate[i][j] = arr[j][m-1-i];
                      break;
              }
          }
      }
      
      for (int i = 0; i < rotate.length; i++) {
          for (int j = 0; j < rotate[i].length; j++) {
              copy[i][j] += rotate[i][j];
          }
      }
      return rotate;
  }

  static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("=======================================");
  }

  static String[] solution(String[] drawing) {
    int n = drawing.length;
    String[] answer = new String[n];
    matrix = new int[n][n];
    temp = new int[n][n];
    copy = new int[n][n];
    
    for (int i = 0; i < drawing.length; i++) {
      String s = drawing[i];
      for (int j = 0; j < s.length(); j++) {
        matrix[i][j] = Integer.valueOf(String.valueOf(s.charAt(j)));
        copy[i][j] = Integer.valueOf(String.valueOf(s.charAt(j)));
      }
    }

    temp = rotate(matrix, 90);
    
        temp = rotate(matrix, 180);
      
        temp = rotate(matrix, 270);
        
        for(int i = 0; i < copy.length; i++) {
          String s = "";
          for(int j = 0; j < copy[i].length; j++) {
            s += copy[i][j];
          }
          answer[i] = s;
        }

    return answer;
  };

  public static void main(String[] args) {
    String[] drawing = { "11100", "00100", "00110", "00010", "00010" };
    System.out.println(solution(drawing));
  }
}
