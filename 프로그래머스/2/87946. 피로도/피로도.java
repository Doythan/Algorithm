class Solution {
    // 최대 탐험 횟수
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    public void dfs(int k, int [][] dungeons, boolean[] visited, int count) {
        // 정답 갱신
        if (count > answer) {
            answer = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            // 방문 체크
            if (visited[i]) continue;

            int need = dungeons[i][0];  // 최소 필요 피로도
            int use = dungeons[i][1];  // 소모 피로도

            if (k >= need) {
                visited[i] = true;
                dfs(k - use, dungeons, visited, count + 1);
                visited[i] = false;  // 백트래킹: 원상복구
            }
        }
    }

}