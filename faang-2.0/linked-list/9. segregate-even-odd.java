import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode otail = dummyOdd;
        ListNode etail = dummyEven;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val % 2 == 0){ // even no.
                etail.next = curr;
                etail = etail.next;
            }
            else{
                otail.next = curr;
                otail = otail.next;
            }
            
            curr = curr.next;
        }
        otail.next = null;
        etail.next = dummyOdd.next;
        
        return dummyEven.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}