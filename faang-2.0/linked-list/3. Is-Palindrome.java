import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = midNode(head);
        ListNode nhead = reverseLL(mid.next);
        ListNode c1 = head;
        ListNode c2 = nhead;
        
        while(c2 != null){
            if(c1.val != c2.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
        
    } 
    public static ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
      ListNode curr = head;
      ListNode prev = null;
      ListNode ocn = null;
      while(curr != null){
          ocn = curr.next;
          curr.next = prev;
          prev = curr;
          curr = ocn;
          
      }
      return prev;
        
    }
    public static ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
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

        System.out.println(isPalindrome(dummy.next));
    }
}