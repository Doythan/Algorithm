import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] grid;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        visited = new boolean[M][N];

        // 사각형 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    grid[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (grid[y][x] == 0 && !visited[y][x]) {
                    int size = dfs(y, x);
                    areas.add(size);
                }
            }
        }

        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append("\n");
        for (int i = 0; i < areas.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(areas.get(i));
        }
        System.out.println(sb.toString());
    }

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
            if (visited[ny][nx] || grid[ny][nx] == 1) continue;

            count += dfs(ny, nx);
        }
        return count;
    }

}