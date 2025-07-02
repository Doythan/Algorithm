import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0;
        
        while (idx < section.length) {
            int start = section[idx];
            int end = start + m - 1;
            
            answer++;
            
            // 롤러의 길이에 포함된 값들 스킵 
            while (idx < section.length && section[idx] <= end) {
                idx++;
            }
        }
        
        return answer;
    }
}