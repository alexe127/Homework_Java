//    12.	*+Написать программу, определяющую правильность расстановки скобок в выражении.
//            Пример 1: a+(d*3) - истина
//    Пример 2: [a+(1*3) - ложь
//    Пример 3: [6+(3*3)] - истина
//    Пример 4: {a}[+]{(d*3)} - истина
//    Пример 5: <{a}+{(d*3)}> - истина
//    Пример 6: {a+]}{(d*3)} - ложь


import java.util.*;

public class task12 {
    public static void main(String[] args) {
        char[] initList = new char[]{'(', ')', '[', ']','{','}','<','>'};
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        map.put('<', '>');
        // String checkString = "{a}[+]{(d*3)}"; //  истина
        String checkString = "{a+]}{(d*3)}"; //ложь
        System.out.println("В выражении: \n" + checkString);
        char[] charList = checkString.toCharArray();
        ArrayList<Character> filteredList = new ArrayList<>();
        for(int i = 0; i < charList.length; i++) {
            char check = charList[i];
            boolean checkFlag = false;
            for (int j = 0; j < initList.length; j++) {
                if (check == initList[j]) checkFlag = true;
            }
            if (checkFlag) filteredList.add(check);
        }

        if(checkBrackets(map,filteredList,0) == 0){
            System.out.println("Последовательность скобок правильная");
        }
        else System.out.println("Последовательность скобок не правильная");

    }

    public static int checkBrackets(Map map, ArrayList list, int startIndex){
        int result = 0;
        if(map.containsKey(list.get(startIndex))&& map.get(list.get(startIndex)) == list.get(startIndex +1)){
            return result;
        }
        for(int i = startIndex; i < list.size() - 1; i++){
            if(map.containsKey(list.get(startIndex+1))){
                result = result + checkBrackets(map, list, startIndex+1);
            }
            else{
                result++;
                return result;
            }
        }
        return result;
    }
}
