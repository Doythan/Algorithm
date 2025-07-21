import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQueue = new LinkedList<>();
        
        // 각 작업마다 배포까지 걸리는 일수를 계산해서 큐에 저장하기.
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];  // 남은 퍼센트 계산 
            // 올림 처리해서 며칠 걸리는지 계산, double 형태로 강제타입 변환을 해줘야 소수점이 있는 실수로 만들어줘야 Math.ceil을 사용 할 수 있음
            int day = (int) Math.ceil((double) remain / speeds[i]);
            daysQueue.offer(day);  // 큐에 저장 
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!daysQueue.isEmpty()) {
            int current = daysQueue.poll();  // 맨 앞 작업 기준
            int count = 1;  // 최소 1개는 배포
            
            // 큐의 앞쪽 작업들이 current보다 작거나 같으면 함께 배포 가능 
            while (!daysQueue.isEmpty() && daysQueue.peek() <= current) {
                count++;
                daysQueue.poll();
            }
            
            result.add(count);  
        }
        
        // List -> 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}