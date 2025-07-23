import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder stringbuilder = new StringBuilder();
        
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            
            if (Character.isUpperCase(ch)) {
                stringbuilder.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                stringbuilder.append(Character.toUpperCase(ch));
            }
        }
        
        System.out.println(stringbuilder);
    }
}