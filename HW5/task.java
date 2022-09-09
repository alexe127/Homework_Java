import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class task {
    public static void main(String[] args) {
        String targStr = "()[]{}"; //true
        // String targStr = "}]{["; //false
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        System.out.println(isCorrect(targStr, stack, map));
    }

    private static boolean isCorrect(String str, Deque<Character> stack, Map<Character, Character> map) {
        for (Character ch: str.toCharArray()) {
            if(map.containsKey(ch)){
                stack.push(ch);
            }
            if(map.containsValue(ch)){
                if(stack.isEmpty() || map.get(stack.pop()) != ch){
                    return false;
                }
            }
        }
        return true;
    }
}