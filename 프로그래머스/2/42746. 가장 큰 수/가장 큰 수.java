import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int 배열을 String 배열로 변환하기
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        // 정렬 기준 설정
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // 내림차순 정렬
                return order2.compareTo(order1);
            }
        });
        
        // 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        
        // 맨 앞이 0이면 그냥 "0" 리턴하기
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}