import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐 생성 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 원소들 큐에 삽입
        for (int s: scoville) {
            pq.offer(s);
        }

        int count = 0;

        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();  // 제일 작은 값 꺼내기
            int second = pq.poll();  // 두번째로 작은 값 꺼내기

            int newScoville = first + (second * 2);
            pq.offer(newScoville);
            count ++;
        }

        // 예외로 마지막 남는 원소도 K 미만이면 -1 return
        if (pq.peek() < K) {
            return -1;
        }

        return count;
    }
}