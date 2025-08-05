import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;  // 행의 수
        int m = maps[0].length();  // 열의 수 
        boolean[][] visited = new boolean[n][m];  // 방문 체크용 배열 
        List<Integer> islandSums = new ArrayList<>();  // 섬마다 식량 총합을 저장하는 리스트
        
        
        for (int i=0; i < n; i++) {
            for (int j=0; j<m; j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int sum = dfs(i, j, maps, visited);
                    islandSums.add(sum);
                }
            }
        }
        
        if (islandSums.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(islandSums);
        return islandSums.stream().mapToInt(i -> i).toArray();
    }
    
    private int dfs(int x, int y, String[] maps, boolean[][] visited) {
        int n = maps.length;
        int m = maps[0].length();
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    sum += dfs(nx, ny, maps, visited);
                }
            }
        }
        return sum;
    }
}