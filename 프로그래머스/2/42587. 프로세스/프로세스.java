import java.util.*;

class Solution {
    static class Process {
        int index;
        int priority;
        
        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        // 프로세스를 큐에 넣음 (우선순위와 원래 위치 저장)
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }
        
        int order = 0; // 실행 순서 카운터
        
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            
            // 큐에 현재보다 높은 우선순위가 있는지 확인
            boolean hasHigher = false;
            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigher = true;
                    break; 
                }
            }
            
            if (hasHigher) {
                queue.offer(current);
            } else {
                order++;
                if (current.index == location) {
                    return order;
                }
            }
        }
        return -1;
    }
}