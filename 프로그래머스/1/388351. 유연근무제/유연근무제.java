import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int hopeTime = schedules[i];
            
            // 출근 인정 시각
            int limitHour = hopeTime / 100;
            int limitMin = hopeTime % 100 + 10;
            
            if (limitMin >= 60) {
                limitHour += 1;
                limitMin -= 60;
            }
            
            int limitTime = limitHour * 100 + limitMin;
            
            boolean success = true;
            
            for (int d = 0; d < 7; d++) {
                int dayOfWeek = startday + d;
                if (dayOfWeek > 7) dayOfWeek -= 7;
                
                // 주말은 무시
                if (dayOfWeek == 6 || dayOfWeek == 7) continue;
                
                int time = timelogs[i][d];
                
                if (time > limitTime) {
                    success = false;
                    break;
                }
            }
            
            if (success) answer++;
        }
        
        return answer;
    }
}