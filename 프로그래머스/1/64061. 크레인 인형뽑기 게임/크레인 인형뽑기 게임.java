import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for (int move : moves) {
            int col = move - 1;  // 인덱스 1차이 맞추기 
            
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];  // 뽑은 인형 종류가 무엇인지 
                    board[row][col] = 0;  // 뽑은 곳 초기화 
                    
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    }
                    else {
                        basket.push(doll);
                    }
                    break; // 인형 하나만 하고 다음 move로 넘어가야 함
                }
            }
        }
        return answer;
    }
}