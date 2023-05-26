import java.util.Arrays;

public class Main {

        /**
          Написать метод «Шифр Цезаря», с булевым параметром зашифрования
          и расшифрования и числовым ключом;
         */
    public static String caesarCrypto(String st, boolean decode, int shift) {
        if (decode) shift = -shift;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            ch = (char) (ch + shift);
            res.append(ch);
        }
        return res.toString();
    }

        /**
         * Написать метод, принимающий на вход массив чисел и параметр п.
         * Метод должен осуществить циклический (последний элемент при сдвиге
         * становится первым) сдвиг всех элементов массива на п позиций;
         */
    public static int[] shifter(int[] arr, int n) {
        int len = arr.length;
        if (n > len) n = n - len;
        int[] helpArray = new int[len];
        int j;
        for (int i = 0; i < len; i++) {
            j = (i + n) > len - 1 ? i + n - len : i + n;
            helpArray[j] = arr[i];
        }
        System.arraycopy(helpArray, 0, arr, 0, len);
        return arr;
    }

    /**
     * Написать метод, которому можно передать в качестве аргумента массив,
     * состоящий строго из единиц и нулей (целые числа типа int).
     * Метод должен заменить еди массиве на нули, а нули на единицы.
     * Написать как можно больше вариантов
     */
    public static int[] changer(int[] arr){


        return arr;
    }

    public static void main(String[] args) {
        String s = "Privet";
        String coded = caesarCrypto(s, false, 3);
        String decoded = caesarCrypto(coded, true, 3);
        System.out.println(coded);
        System.out.println(decoded);

        final int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(shifter(arr, 2)));

    }
}