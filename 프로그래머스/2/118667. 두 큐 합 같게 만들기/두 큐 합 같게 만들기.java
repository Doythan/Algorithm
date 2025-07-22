import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer((long) queue1[i]);
            q2.offer((long) queue2[i]);
        }

        int maxOperations = queue1.length * 3;  // 제한
        int operations = 0;

        while (sum1 != sum2) {
            if (operations > maxOperations) return -1;

            if (sum1 > sum2) {
                long num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else {
                long num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }

            operations++;
        }

        return operations;
    }
}
