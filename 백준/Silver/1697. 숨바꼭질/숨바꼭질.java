import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    static void bfs(int N, int K) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        q.add(N);
        visited[N] = true;
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i=0; i<size; i++) {
                int cur = q.poll();

                if (cur == K) {
                    System.out.println(time);
                    return;
                }

                for (int next : new int[]{cur-1, cur+1, cur*2}) {
                    if (next >= 0 && next < 100001 && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            time++;
        }
    }
}