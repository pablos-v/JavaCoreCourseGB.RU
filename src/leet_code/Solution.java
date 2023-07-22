package leet_code;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1**2 + 9**2 = 82
 * 8**2 + 2**2 = 68
 * 6**2 + 8**2 = 100
 * 1**2 + 0**2 + 0**2 = 1
 */
class Solution {
    public static int count(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }

    public static boolean isLuckyNumber(int n) {
        int turt = n, rabb = n; //алгоритм кролика и черепахи
        do {
            turt = count(turt);
            if (turt == 1) return true;
            rabb = count(count(rabb));
        }
        while (turt != rabb); //если в последовательности есть цикл, то они в нём встретятся в какой-то момент
        return false;

    }


    public static void main(String[] args) {
        System.out.println(Solution.isLuckyNumber(23));
    }
}