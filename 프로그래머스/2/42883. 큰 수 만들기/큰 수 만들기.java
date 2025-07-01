import java.util.*;

class Solution {
    public String solution(String number, int k) { 
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            
            // 뒤에서 더 큰 수가 오면 앞의 작은 수들을 제거함
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        // 아직 k가 남아있으면 뒤에서 잘라냄
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // stack을 String으로 변환
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}