package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PablosLibrary {

    public static HashSet<Character> stringToSet(String str){
        char[] ch = str.toCharArray();
        Character[] arr = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = ch[i];
        }
        return new HashSet<>(List.of(arr));
    }
    public static HashMap<Character,Integer> stringToMap(String str){
        HashMap<Character,Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            res.put(ch, res.getOrDefault(ch, 0) + 1);
        }
        return res;
    }


}
