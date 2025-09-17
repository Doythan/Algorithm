import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int l = nums.length / 2;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            cnt++;
        }
        
        if (cnt > l) cnt = l;
        return cnt;
        
    }
}