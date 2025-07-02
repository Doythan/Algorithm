import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 점수 기록용 map
        Map<Character, Integer> map = new HashMap<>();
        
        // 성격 유형 초기화
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            char left = s.charAt(0);
            char right = s.charAt(1);
            
            int choice = choices[i];
            
            if (choice < 4) {
                // 왼쪽 유형에 점수 추가
                map.put(left, map.get(left) + (4 - choice));
            } else if (choice > 4) {
                // 오른쪽 유형에 점수 추가
                map.put(right, map.get(right) + (choice - 4));
            }
            // choice == 4면 아무 점수도 주지 않음
        }
        
        // 최종 성격 유형 구하기
        StringBuilder sb = new StringBuilder();
        
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        return sb.toString();
    }
}
