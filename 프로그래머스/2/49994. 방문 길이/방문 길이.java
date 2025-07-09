import java.util.*;

class Solution {
    public int solution(String dirs) {
        // 4방향 좌표
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[] dirchar = {'U', 'D', 'R', 'L'};
        
        // 처음 위치
        int x = 0;
        int y = 0;
        
        // 중복 제외하여 지나간길을 저장하는 집합
        Set<String> pathSet = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            int idx = -1;
            
            for (int i = 0; i < 4; i++) {
                if (c == dirchar[i]) {
                    idx = i;
                    break;
                }
            }
            
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            // 맵 밖으로 나가는거는 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String path1 = "" + x + y + nx + ny;
            String path2 = "" + nx + ny + x + y;
            
            pathSet.add(path1);
            pathSet.add(path2);
            
            x = nx;
            y = ny;
        }
        return pathSet.size() / 2;
    }
}