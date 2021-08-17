import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;
        
        while(curr != null){
            forw = curr.next; //backup
            curr.next = prev; // link
            
            prev = curr;
            curr = forw;
        }
        return prev;
        
    }
    public static ListNode midNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        
        mid.next = null;
        
        nHead = reverseLL(nHead);
        
        ListNode c1 = head;
        ListNode c2 = nHead;
        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c2 != null){
            //backup
            f1 = c1.next;
            f2 = c2.next;
            
            //link
            c1.next = c2;
            c2.next = f1;
            
            //move
            c1 = f1;
            c2 = f2;
            
        }
        
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}