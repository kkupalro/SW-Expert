package B17413;

import java.io.*;

public class Main {
	static boolean flag;
	static StringBuffer input = new StringBuffer();
	static StringBuffer temp = new StringBuffer();
	static StringBuffer ans = new StringBuffer();
	static StringBuffer word = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input.append(br.readLine());
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '<')
			{
				flag ^= true;
				ans.append(word);
				word.setLength(0);
				word.append("<");
			}
			else if(input.charAt(i) == '>')
			{
				flag ^= true;
				ans.append(word + ">");
				word.setLength(0);
			}
			else if(input.charAt(i) == ' ')
			{
				ans.append(word.toString() + ' ');
				word.setLength(0);
			}
			else {
				if(flag) 
				{
					word.append(input.charAt(i));
				}
				else
				{
					temp.append(word);
					word.setLength(0);
					word.append(input.charAt(i));
					word.append(temp);
					temp.setLength(0);
				}
			}
		}
		if(word.length() > 0)
		{
			ans.append(word);
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}
}
