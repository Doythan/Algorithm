import java.util.ArrayList;
import java.util.List;

class Solution {

    static class Dir {
        int a, b;
        Dir(int a, int b) { this.a = a; this.b = b; }
    }

    public int[][] solution(int n) {
        int num = 1;
        int x = 0, y = 0;
        int[][] arr = new int[n][n];

        List<Dir> dirs = new ArrayList<>();
        dirs.add(new Dir(0, 1));   // 오
        dirs.add(new Dir(1, 0));   // 하 
        dirs.add(new Dir(0, -1));  // 왼
        dirs.add(new Dir(-1, 0));  // 상


        List<Integer> newSteps = new ArrayList<>();
        int newStep = n - 1;
        if (n > 1) {
            newSteps.add(newStep);
            while (newStep > 0) {
                newSteps.add(newStep);
                newSteps.add(newStep);
                newStep -= 1;
            }
        }

        // 시작값
        arr[x][y] = 1;

        // 공통 모듈
        int index = 0;
        for (int k = 0; k < newSteps.size(); k++) {
            Dir dir = dirs.get(index % 4);
            index++;
            for (int i = 0; i < newSteps.get(k); i++) {
                x = x + dir.a;
                y = y + dir.b;
                arr[x][y] = ++num;
            }
        }

        return arr;
    }
}
