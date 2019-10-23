package TEST;

import java.io.*;
import java.util.*;

class node {
	int r; int c; int s;
	node(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}
public class Main {
	static int Y, X, L;
	static node K[];
	static boolean visit[] = new boolean[6];
	static int matrix[][] = new int[51][51];
	static int temp[][] = new int[51][51];
	static int result = Integer.MAX_VALUE;
	static void copy(int a[][], int b[][]) {
		for(int i = 1; i <= Y; i++)
		{
			for(int j = 1; j <= X; j++)
			{
				a[i][j] = b[i][j];
			}
		}
	}
	static void cal() {
		for(int i = 1; i <= Y; i++)
		{
			int sum = matrix[i][1];
			for(int j = 2; j <= X; j++)
			{
				sum += matrix[i][j];
			}
			// �ึ�� �� �� �ջ� 
			result = Math.min(result, sum);
		}
	}
	static void comb(int y, int x, int size, int cnt) {
		int tmp1 = 0, tmp2 = 0;
		if(cnt == L)
		{
			for(int S = 1; S <= size; S++)
			{
				// �ð� ���� ȸ��
				// 1. -> ��
				tmp1 = matrix[y-S][x-S];
				tmp2 = matrix[y-S][x-S+1];
				matrix[y-S][x-S+1] = tmp1;
				for(int j = 2; j <= 2 * S; j++)
				{
					tmp1 = matrix[y-S][x-S+j]; 
					matrix[y-S][x-S+j] = tmp2;
					tmp2 = tmp1;
				}
				// 2. v ��
				for(int j = 1; j <= 2 *S; j++)
				{
					tmp1 = matrix[y-S+j][x+S];
					matrix[y-S+j][x+S] = tmp2;
					tmp2 = tmp1;
				}
				// 3. <- ��
				for(int j = 1; j <= 2 * S; j++)
				{
					tmp1 = matrix[y+S][x+S-j];
					matrix[y+S][x+S-j] = tmp2;
					tmp2 = tmp1;
				}
				// 4. ^ ��
				for(int j = 1; j <= 2 * S; j++)
				{
					tmp1 = matrix[y+S-j][x-S];
					matrix[y+S-j][x-S] = tmp2;
					tmp2 = tmp1;
				}
			}
			cal();
			return;
		}
		
		
		for(int S = 1; S <= size; S++)
		{
			// �ð� ���� ȸ��
			// 1. -> ��
			tmp1 = matrix[y-S][x-S];
			tmp2 = matrix[y-S][x-S+1];
			matrix[y-S][x-S+1] = tmp1;
			for(int j = 2; j <= 2 * S; j++)
			{
				tmp1 = matrix[y-S][x-S+j]; 
				matrix[y-S][x-S+j] = tmp2;
				tmp2 = tmp1;
			}
			// 2. v ��
			for(int j = 1; j <= 2 *S; j++)
			{
				tmp1 = matrix[y-S+j][x+S];
				matrix[y-S+j][x+S] = tmp2;
				tmp2 = tmp1;
			}
			// 3. <- ��
			for(int j = 1; j <= 2 * S; j++)
			{
				tmp1 = matrix[y+S][x+S-j];
				matrix[y+S][x+S-j] = tmp2;
				tmp2 = tmp1;
			}
			// 4. ^ ��
			for(int j = 1; j <= 2 * S; j++)
			{
				tmp1 = matrix[y+S-j][x-S];
				matrix[y+S-j][x-S] = tmp2;
				tmp2 = tmp1;
			}
		}
		
		int temp2[][] = new int[51][51];
		for(int i = 0; i < L; i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			copy(temp2, matrix);
			comb(K[i].r, K[i].c, K[i].s, cnt + 1);
			copy(matrix, temp2);
			visit[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = new node[L];
		// �Է�
		for(int i = 1; i <= Y; i++)
		{
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j = 1; j <= X; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < K.length; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			K[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// ���� �ִ� ����
		for(int i = 0; i < K.length; i++)
		{
			visit[i] = true;
			copy(temp, matrix);
			comb(K[i].r, K[i].c, K[i].s, 1);
			copy(matrix, temp);
			visit[i] = false;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}