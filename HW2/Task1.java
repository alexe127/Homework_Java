//    Сделать программу, в рамках которой необходимо определить какой символ сколько раз встречается в строке.
//        Например: входящая строка вида - "aaaaabbbbcddd" мы должны получить - "a5b4c1d3".

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        String incoming_string = "aaaaabbbbcddd";

        String result = symbolCount(incoming_string);
        System.out.println("В строке \"" + incoming_string + "\" содержится - " + result);
    }

    private static String symbolCount(String stringOriginal) {
        String resultString = "";
        HashMap<Character, Integer> resultMap = new HashMap<>();

        for (char symbol : stringOriginal.toCharArray()) {
            if (resultMap.containsKey(symbol)) {
                resultMap.put(symbol, resultMap.get(symbol) + 1);
            } else {
                resultMap.put(symbol, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = resultMap.entrySet();
        for (var pair : entries) {
            resultString += "" + pair.getKey() + pair.getValue();
        }
        return resultString;
    }

}
