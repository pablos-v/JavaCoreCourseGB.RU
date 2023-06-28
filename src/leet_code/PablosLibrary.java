package leet_code;

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


}
