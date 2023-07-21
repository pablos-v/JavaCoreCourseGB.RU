package leet_code;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
class Solution {

    public static int midLinkedList(int[] arr) {
        int i=0;
        int j = i+2;
        while (j<= arr.length){
            i++;
            j+=2;
        }
        return arr[i];
    }


    public static void main(String[] args) {
        System.out.println(Solution.midLinkedList(new int[]{1, 2, 3, 4, 5}) == 3);
        System.out.println(Solution.midLinkedList(new int[]{1, 2, 3, 4, 5, 6}) == 4);
        System.out.println(Solution.midLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7}) == 4);
    }
}