import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int robotCount = routes.length;
        int maxTime = 0;
        
        // 포인트 번호 → 좌표
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }
        
        // 각 로봇별 time → 좌표 기록
        Map<Integer, Map<Long, int[]>> robotPaths = new HashMap<>();
        
        for (int i = 0; i < robotCount; i++) {
            int[] route = routes[i];
            Map<Long, int[]> path = new HashMap<>();
            
            int time = 0;
            int[] currPos = pointMap.get(route[0]).clone();
            
            path.put((long)time, currPos.clone());
            
            for (int j = 1; j < route.length; j++) {
                int[] nextPos = pointMap.get(route[j]);
                
                // r 방향 먼저
                while (currPos[0] != nextPos[0]) {
                    time++;
                    if (currPos[0] < nextPos[0]) currPos[0]++;
                    else currPos[0]--;
                    path.put((long)time, currPos.clone());
                }
                
                // c 방향
                while (currPos[1] != nextPos[1]) {
                    time++;
                    if (currPos[1] < nextPos[1]) currPos[1]++;
                    else currPos[1]--;
                    path.put((long)time, currPos.clone());
                }
            }
            
            robotPaths.put(i, path);
            maxTime = Math.max(maxTime, time);
        }
        
        // time → posKey → robotList
        Map<Long, Map<Long, List<Integer>>> timeMap = new HashMap<>();
        
        for (int i = 0; i < robotCount; i++) {
            Map<Long, int[]> path = robotPaths.get(i);
            for (Map.Entry<Long, int[]> e : path.entrySet()) {
                long t = e.getKey();
                int[] pos = e.getValue();
                long key = pos[0] * 1000L + pos[1];
                
                timeMap.putIfAbsent(t, new HashMap<>());
                Map<Long, List<Integer>> posMap = timeMap.get(t);
                posMap.putIfAbsent(key, new ArrayList<>());
                posMap.get(key).add(i);
            }
        }
        
        int dangerCount = 0;
        
        for (long t = 0; t <= maxTime; t++) {
            if (!timeMap.containsKey(t)) continue;
            Map<Long, List<Integer>> posMap = timeMap.get(t);
            for (List<Integer> robots : posMap.values()) {
                if (robots.size() >= 2) {
                    dangerCount++;
                }
            }
        }
        
        return dangerCount;
    }
}
