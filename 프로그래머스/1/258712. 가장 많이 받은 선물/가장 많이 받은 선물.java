import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIdx.put(friends[i], i);
        }
        
        int[][] giftTable = new int[n][n];
        int[] giftScore = new int[n];
        
        // 선물 기록 저장 하기
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            
            int gIdx = nameToIdx.get(giver);
            int rIdx = nameToIdx.get(receiver);
            
            giftTable[gIdx][rIdx]++;
            giftScore[gIdx]++;
            giftScore[rIdx]--;
        }
        
        int[] nextMonthGifts = new int[n];
        
        // 친구 쌍 모두 비교하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                int giveToJ = giftTable[i][j];
                int giveToI = giftTable[j][i];
                
                if (giveToJ > giveToI) {
                    nextMonthGifts[i]++;
                } else if (giveToJ == giveToI) {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int cnt : nextMonthGifts) {
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}