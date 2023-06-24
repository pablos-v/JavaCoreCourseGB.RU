package leet_code;

/**
 * Реализуйте функцию, которая выводит в терминал числа в диапазоне от begin до end. При этом:
 * <p>
 * Если число делится без остатка на 3, то вместо него выводится слово Fizz
 * Если число делится без остатка на 5, то вместо него выводится слово Buzz
 * Если число делится без остатка и на 3, и на 5, то вместо числа выводится слово FizzBuzz
 * В остальных случаях выводится само число
 * Функция принимает два параметра (begin и end), определяющих начало и конец диапазона (включительно).
 * Для простоты считаем, что эти параметры являются целыми числами больше нуля.
 * Если диапазон пуст (в случае, когда begin > end), то функция просто ничего не печатает.
 */
class Solution {
    String CASE3 = "FizzBuzz";
    String CASE1 = "Fizz";
    String CASE2 = "Buzz";

//    public void printer(int begin, int end) {
//        for (int i = begin; i <= end; i++) {
//            if (i % 3 == 0) {
//                if (i % 5 == 0) {
//                    System.out.println(CASE3);
//                    continue;
//                }
//                System.out.println(CASE1);
//            } else if (i % 5 == 0) {
//                System.out.println(CASE2);
//            } else System.out.println(i);
//        }
//    }

//    public void printer2(int begin, int end) {
//        String fizz = "";
//        String buzz = "";
//        for (int i = begin; i <= end; i++) {
//            fizz = i % 3 == 0 ? "Fizz" : "";
//            buzz = i % 5 == 0 ? "Buzz" : "";
//            if (i % 3 == 0 || i % 5 == 0) {
//                System.out.println(fizz + buzz);
//            } else System.out.println(i);
//        }
//    }

    public void printer3(int begin, int end){
        for (int i = begin; i <= end; i++)  {
            String str = "";
            if (i%3==0) str += "Fizz";
            if (i%5==0) str += "Buzz";
            if (str.length() > 0) System.out.println(str);
            else System.out.println(i);

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printer3(1, 22);
    }
}