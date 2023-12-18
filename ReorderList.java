
  //Definition for singly-linked list.
  public class ListNode {
      int val;
    ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no reordering is needed.
            return;
        }

        // Step 1: Find the middle of the linked list.
        ListNode middle = findMiddle(head);

        // Step 2: Reverse the second half of the linked list.
        ListNode reversedSecondHalf = reverseLinkedList(middle.next);
        middle.next = null; // Break the original list into two halves.

        // Step 3: Merge the two halves.
        mergeLists(head, reversedSecondHalf);
    }

    // Helper function to find the middle of the linked list using the slow and fast pointer approach.
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to reverse a linked list.
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev; // 'prev' is the new head of the reversed list.
    }

    // Helper function to merge two linked lists by interleaving their nodes.
    private void mergeLists(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            ListNode nextList1 = list1.next;
            ListNode nextList2 = list2.next;

            list1.next = list2;
            list2.next = nextList1;

            list1 = nextList1;
            list2 = nextList2;
        }
    }
    
}
