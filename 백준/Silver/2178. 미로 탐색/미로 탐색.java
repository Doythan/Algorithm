import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0, N, M));
    }

    static int bfs(int x, int y, int N, int M) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int curX = current[0];
            int curY = current[1];

            // 도착 지점 도달 시 리턴
            if (curX == N-1 && curY == M-1) {
                return maze[curX][curY];
            }

            for (int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[curX][curY] + 1;
                    queue.add(new int[]{nx, ny});
                } 
            }

        }
        return maze[N-1][M-1];
    }
}