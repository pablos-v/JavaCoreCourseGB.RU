package leet_code;

/**
 * Для заданного отсортированного в возрастающем порядке массива A целых чисел длины n
 * и целого числа X определить, существует ли в нем два различных элемента A[i] и A[j],
 * такие что A[i] + A[j] = X.
 */
class Solution {

    public static boolean isNumInArray(int[] arr, int X) {
        int i = 0;
        int j = arr.length - 1;
        while (i != j) {
            if (arr[i] + arr[j] == X) {
                System.out.printf("i = %d, j = %d ", arr[i], arr[j]);
                return true;
            }
            if (arr[i] + arr[j] > X) j--;
            else i++;
        }
        return false;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, 3, 6, 7, 11, 15};
        System.out.println(Solution.isNumInArray(arr, 13));
    }
}