import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();
        int elapsedTime = 0;
        int totalWeight = 0;
        int truckIndex = 0;

        // 초기 다리 상태 (길이만큼 0으로 채우기)
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }

        while (truckIndex < truck_weights.length) {
            elapsedTime++;

            // 다리에서 트럭 하나 빼내기
            totalWeight -= bridgeQueue.poll();

            // 새 트럭 올릴 수 있으면 올림
            if (totalWeight + truck_weights[truckIndex] <= weight) {
                bridgeQueue.offer(truck_weights[truckIndex]);
                totalWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridgeQueue.offer(0);
            }
        }

        // 마지막 트럭이 다리 빠져나가는 시간 더해주기
        elapsedTime += bridge_length;

        return elapsedTime;
    }
}
