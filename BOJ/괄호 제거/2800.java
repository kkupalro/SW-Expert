import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb;
	static Set<String> set;
	static Stack<Integer> st;
	static int[] pair;
	static boolean[] check;
	static String temp;

	static void dfs(int idx, int len) throws IOException {
		// 기저 조건
		if(idx == len) {
			set.add(sb.toString());
			return;
		}
		
		char c = temp.charAt(idx);
		if(c == '(') {
			check[idx] = true;
			dfs(idx + 1, len);
			check[idx] = false;
		}
		
		if(c == ')' && check[pair[idx]]) {
			check[idx] = true;
			dfs(idx + 1, len);
			check[idx] = false;
		} else {
			sb.append(c);
			dfs(idx + 1, len);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new Stack<Integer>();
		set = new HashSet<String>();
		
		temp = br.readLine();
		pair = new int[temp.length()];
		check = new boolean[temp.length()];
		
		
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '(') {
				st.push(i);
			} else if (temp.charAt(i) == ')') {
				pair[i] = st.peek();
				pair[st.peek()] = i;
				st.pop();
			}
		}
		
		dfs(0, temp.length());
		set.remove(temp);
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		for (String result : list) {
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}
}
