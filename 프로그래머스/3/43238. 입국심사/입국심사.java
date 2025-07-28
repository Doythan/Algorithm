import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1; // 최소시간
        long right = (long) Arrays.stream(times).max().getAsInt() * n; // 최악의 시간
        
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for (int time : times) {
                people += mid / time;
            }
            
            if (people >= n) {
                // 심사가 가능하므로 시간을 줄여본다
                answer = mid;
                right = mid - 1;
            } else {
                // 시간이 부족하므로 시간을 늘려야 함
                left = mid + 1;
            }
        }
        
        return answer;
    }
}