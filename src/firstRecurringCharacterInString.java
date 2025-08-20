import java.util.HashMap;
import java.util.Scanner;

public class firstRecurringCharacterInString {
    public static String find(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x) > 1){
                return x + "";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String ans = find(s);
        System.out.println(ans);
    }
}
