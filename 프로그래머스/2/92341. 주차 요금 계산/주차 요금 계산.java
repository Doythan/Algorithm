import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String car = parts[1];
            String action = parts[2];
            
            int time = toMinutes(timeStr);
            
            if (action.equals("IN")) {
                inTime.put(car, time);
            } else {
                int duration = time - inTime.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + duration);
                inTime.remove(car);
            }
        }
        
        // 출차 기록 없는 차량 처리
        for (String car : inTime.keySet()) {
            int duration = (23 * 60 + 59) - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + duration);
        }
        
        // 차량번호 오름차순 정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            String car = cars.get(i);
            int time = totalTime.get(car);
            answer[i] = calcFee(fees, time);
        }
        
        return answer;
    }
    
    private int toMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
    
    private int calcFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (time <= basicTime) {
            return basicFee;
        } else {
            int extra = time - basicTime;
            int units = (int)Math.ceil(extra / (double)unitTime);
            return basicFee + units * unitFee;
        }
    }
}
