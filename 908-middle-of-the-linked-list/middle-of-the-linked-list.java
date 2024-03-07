class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        
        int n = len(head);
        int mid = n / 2;
        ListNode current = head;
        
        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        
        return current;
    }
    
    int len(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}
