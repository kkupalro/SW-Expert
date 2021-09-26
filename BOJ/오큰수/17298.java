import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author yoo
 * @commit 0926|BOJ|오큰수|17298
 *
 */

public class Main {
  static int N;
  static int[] arr;
  static Stack<Integer> st = new Stack<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int copy[] = Arrays.copyOf(arr, arr.length);

    for (int i = 0; i < N; i++) {
      while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
        arr[st.pop()] = arr[i];
      }
      st.push(i);
    }

    for (int i = 0; i < N; i++) {
      bw.write(((arr[i] == copy[i]) ? -1 : arr[i]) + " ");
    }
    bw.flush();
    bw.close();
  }
}