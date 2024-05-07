public class Solution {
    public int twiceOfVal(ListNode head) {
        if (head == null) return 0;
        
        int doubledValue = head.val * 2 + twiceOfVal(head.next);
        
        head.val = doubledValue % 10;
        
        return doubledValue / 10;
    }
    
    public ListNode doubleIt(ListNode head) {
        int carry = twiceOfVal(head);
        
        if (carry != 0) {
            head = new ListNode(carry, head);
        }
        
        return head;
    }
}