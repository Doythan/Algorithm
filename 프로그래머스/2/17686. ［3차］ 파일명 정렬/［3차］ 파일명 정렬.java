import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // HEAD, NUMBER로 나눔
                String[] file1 = splitFile(s1);
                String[] file2 = splitFile(s2);
                
                // HEAD 우선 비교
                int headCompare = file1[0].toLowerCase().compareTo(file2[0].toLowerCase());
                if (headCompare != 0) {
                    return headCompare;
                }
                
                // NUMBER 비교
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);
                
                return Integer.compare(num1, num2);
            }
        });
        return files;
    }
    
    private String[] splitFile(String file) {
        int idx = 0;
        int len = file.length();

        // HEAD 추출
        while (idx < len && !Character.isDigit(file.charAt(idx))) {
            idx++;
        }
        String head = file.substring(0, idx);

        // NUMBER 추출
        int numStart = idx;
        while (idx < len && Character.isDigit(file.charAt(idx))) {
            idx++;
        }
        String number = file.substring(numStart, idx);

        return new String[]{head, number};
    }
}
