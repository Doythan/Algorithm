import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> number = new HashSet<>();
        for(String phonenumbers : phone_book) number.add(phonenumbers);
        for(String phonenumbers : phone_book) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<phonenumbers.length()-1; i++) {
                sb.append(phonenumbers.charAt(i));
                if(number.contains(sb.toString())) return false;
            }
        }
        return true;
    }
}