import java.io.*;
import java.util.*;

class Main {
	static Stack<Character> st = new Stack<Character>();
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		st.push(sb.charAt(0));
		for(int i = 1; i < sb.length(); i++)
		{
			char c = sb.charAt(i);
			if(c == '(' || c == '{' || c == '[')
			{
				st.push(c);
			}
			else
			{
				if(c == ')')
				{
					if(st.peek() == '(')
					{
						st.pop();
					}
				}
				else if(c == ']')
				{
					if(st.peek() == '[')
					{
						st.pop();
					}
				}
				else if(c == '}')
				{
					if(st.peek() == '{')
					{
						st.pop();
					}
				}
			}
		}
		String result = st.isEmpty()?"True":"False";
		bw.write(result + "\n");
		bw.flush();
		bw.close();
  }
}
