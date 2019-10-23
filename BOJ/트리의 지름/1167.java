import java.io.*;
import java.util.*;

class node {
    int to; int cost;
    node (int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
	static int V, result;
	static LinkedList<node>[] a;
    static int[] BFS(int v, LinkedList<node>[] a, int start) {
        boolean[] check = new boolean[v+1];
        int[] D = new int[v+1];
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int from = q.remove();
            for (node e : a[from]) {
                int to = e.to;
                int cost = e.cost;
                if (check[to] == false) {
                    D[to] = D[from] + cost;
                    q.add(to);
                    check[to] = true;
                }
            }
        }
        return D;
    }
    @SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
        V = Integer.parseInt(br.readLine());
        a = new LinkedList[V+1];
        for (int i = 1; i <= V; i++) {
            a[i] = new LinkedList<node>();
        }
        for (int i = 1; i <= V; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                a[from].add(new node(to, cost));
            }
        }
        int[] dist = BFS(V, a, 1);
        int s = 1;
        for (int i = 2; i <= V; i++) {
            if (dist[i] > dist[s]) {
                s = i;
            }
        }
        dist = BFS(V, a, s);
        result = dist[1];
        for (int i = 2; i <= V; i++) {
            if (result < dist[i]) {
                result = dist[i];
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}