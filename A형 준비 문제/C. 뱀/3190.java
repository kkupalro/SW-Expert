package TEST;

import java.io.*;
import java.util.*;


class node {
	int y; int x;
	node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static final int dy[] = {0, 0, 0, -1, 1}; // 1. ��, 2. ��, 3. ��, 4. ��
	static final int dx[] = {0, 1, -1, 0, 0};
	static int N, K, L;
	static int h_y, h_x;
	static int matrix[][];
	static int C[] = new int[10001];
	static Queue<node> head = new LinkedList<node>();
	static ArrayDeque<node> tail = new ArrayDeque<node>();
	static void print(int a[][]) {
		for(int i = 0; i <= N+1; i++)
		{
			for(int j = 0; j <= N+1; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		matrix = new int[N+2][N+2];
		K = Integer.parseInt(br.readLine());
		Arrays.fill(matrix[0], 4);
		Arrays.fill(matrix[N+1], 4);
		for(int i = 0; i <= N+1; i++)
		{
			matrix[i][0] = 4;
			matrix[i][N+1] = 4;
		}
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			matrix[y][x] = 1;
		}
		L = Integer.parseInt(br.readLine());
		for(int i = 0; i < L; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			if(c.equals("L"))
			{
				C[t] = 1;
			}
			else if(c.equals("D"))
			{
				C[t] = 2;
			}
		}
		head.add(new node(1, 1)); // ó�� �Ӹ� ��ġ
		tail.add(new node(1, 1)); // ó�� ���� ��ġ
		int time = -1;
		int dir = 1;
		boolean flag = false;
		while(true)
		{
			++time; // �ð� �� ����
			node H = head.poll(); // ���� �Ӹ� ��ġ
			node T = tail.poll(); // ���� ���� ��ġ
			if(flag)
			{
				matrix[H.y][H.x] = 2;
				tail.offerFirst(new node(T.y, T.x));
			}
			else if(!flag)
			{
				matrix[T.y][T.x] = 0;
				matrix[H.y][H.x] = 2;
			}
			// ���� ���� ����
			if(C[time] == 1)
			{
				if(dir == 1)
				{
					// �� -> ��
					dir = 3;
				}
				else if(dir == 2)
				{
					// �� -> ��
					dir = 4;
				}
				else if(dir == 3)
				{
					// �� -> ��
					dir = 2;
				}
				else if(dir == 4)
				{
					// ��-> ��
					dir = 1;
				}
			}
			else if(C[time] == 2)
			{
				if(dir == 1)
				{
					// �� -> ��
					dir = 4;
				}
				else if(dir == 2)
				{
					// �� -> ��
					dir = 3;
				}
				else if(dir == 3)
				{
					// �� -> ��
					dir = 1;
				}
				else if(dir == 4)
				{
					// �� -> ��
					dir = 2;
				}
			}
			h_y = H.y + dy[dir];
			h_x = H.x + dx[dir];
			// ���� ���
			if(matrix[h_y][h_x] == 2 || matrix[h_y][h_x] == 4)
			{
				time++;
				break;
			}
			
			if(matrix[h_y][h_x] == 1)
			{
				head.offer(new node(h_y, h_x));
				tail.add(new node(H.y, H.x)); // ���ڸ�
				flag = true;
				continue;
			}
			// ����� ���������� ���
			else if(matrix[h_y][h_x] != 1) {
				head.offer(new node(h_y, h_x));
				tail.add(new node(H.y, H.x)); // �� �̵�
				flag = false;
				continue;
			}
		}
		bw.write(time + "\n");
		bw.flush();
		bw.close();
	}
}