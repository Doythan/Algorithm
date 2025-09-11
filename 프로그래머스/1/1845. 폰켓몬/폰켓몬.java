import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> mons = new HashMap<>();
        int answer = 0;
        
        for(Integer num : nums) {
            mons.put(num, mons.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> mon : mons.entrySet()) {
            answer++;
        }
        
        if (answer > (nums.length / 2)) answer = nums.length/2;
        return answer;
       
    }
}