import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] A;  // 인접 리스트 
	static boolean visited[];       // 방문 체크
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());  // 노드 수 
		int m = Integer.parseInt(st.nextToken());  // 간선 수 
		
		// 크기 할당 
		A = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		// 인접 리스트 초기화 
	    for (int i=1; i<n+1; i++) {
	    	A[i] = new ArrayList<Integer>();
	    }
	    for(int i=0; i<m; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int s = Integer.parseInt(st.nextToken());
	    	int e = Integer.parseInt(st.nextToken());
	    	A[s].add(e);
	    	A[e].add(s);
	    }
	    
	    int count = 0;
	    for(int i=1; i<n+1; i++) {
	    	if (!visited[i]) {
	    		count++;
	    		DFS(i);
	    	}
	    }
	    System.out.println(count);
	}
	
	static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for (int i: A[v]) {
			// 연결 노드 중 방문하지 않았던 노드만 탐색하기 
			if(visited[i] == false) DFS(i);
		}
	}
}