import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb.append(br.readLine());
		for(int i = 0; i < sb.length(); i++)
		{
			switch (sb.charAt(i)) {
			case '0':
				result += 11;
				break;
			case '1':
				result += 2;
				break;
			case 'A':case 'B':case 'C':
				result += 3;
				break;
			case 'D':case 'E':case 'F':
				result += 4;
				break;
			case 'G':case 'H':case 'I':
				result += 5;
				break;
			case 'J':case 'K':case 'L':
				result += 6;
				break;
			case 'M':case 'N':case 'O':
				result += 7;
				break;
			case 'P':case 'Q':case 'R':case 'S':
				result += 8;
				break;
			case 'T':case 'U':case 'V':
				result += 9;
				break;
			case 'W':case 'X':case 'Y':case 'Z':
				result += 10;
				break;
			default:
				break;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
