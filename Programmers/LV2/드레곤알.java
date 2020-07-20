package TEST;

import java.io.*;
import java.util.*;

class dragon {
	int age;
	int life;
	dragon(int age, int life){
		this.age = age;
		this.life = life;
	}
}

public class Main {
	static Queue<dragon> q = new LinkedList<dragon>();
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		q.offer(new dragon(0, 4));
		for(int i = 1; i <= N; i++)
		{
			int len = q.size();
			for(int j = 0; j < len; j++)
			{
				dragon d = q.poll();
				if(d.life == 0)
				{
					// 부화 불가
					q.offer(new dragon(d.age, d.life));
				}
				else
				{
					if((d.age + 1) % 4 == 0)
					{
						// 부화
						q.offer(new dragon(0, 4));
						q.offer(new dragon(d.age + 1, d.life-1));
					}
					else
					{
						q.offer(new dragon(d.age + 1, d.life));
					}
				}
			}
			q.offer(new dragon(0, 4));
		}
		bw.write(q.size() + "\n");
		bw.flush();
		bw.close();
	}
}
