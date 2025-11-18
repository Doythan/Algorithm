import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N];
		visited = new boolean[N];
		arrive = false;
		
		for (int i=0; i<N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			A[S].add(V);
			A[V].add(S);
		}
		
		for (int i=0; i<N; i++) {
			DFS(i, 1);
			if (arrive) break;
		}
		
		if (arrive) System.out.println("1");
		else System.out.println("0");
	}
	
	static void DFS(int now, int depth) {
		if (depth == 5) {
			arrive = true;
			return;
		}
		visited[now] = true;
		for (int i : A[now]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[now] = false;
	}
}





