package leet_code;

/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 * <p>
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void addL(int n) {
            if (n < 1) return;
            this.val = n;
            this.next = new ListNode();
            this.next.addL(n - 1);
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return this.val + " ";
            }
            return this.val + " " + this.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode turt, rabb;
        turt = head;
        rabb = head;
        while (true) {
            if (rabb.next == null) return turt;
            else if (rabb.next.next == null)             return turt.next;
            turt = turt.next;
            rabb = rabb.next.next;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.addL(6);
        System.out.println(node);
        System.out.println(Solution.middleNode(node).val);

    }
}