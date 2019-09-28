package TEST;

import java.io.*;
import java.util.*;

public class Main {
	static int goods[] = {5,3,7};
	static int boxes[] = {3,7,6};
	static int g_idx = 0;
	static int b_idx = -1;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Arrays.sort(goods);
		Arrays.sort(boxes);
		while(b_idx++ < boxes.length)
		{
			if(g_idx >= goods.length || b_idx >= boxes.length)
			{
				break;
			}
			else if(goods[g_idx] <= boxes[b_idx])
			{
				result++;
				g_idx += 1;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
