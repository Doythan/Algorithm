import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String num : phone_book) set.add(num);
        
        for(String num : phone_book) {
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<num.length() - 1; i++) {
                sb.append(num.charAt(i));
                if(set.contains(sb.toString())) return false;
            }
        }
        return true;
    }
}