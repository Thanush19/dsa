class Solution {
    public ListNode partition(ListNode head, int x) {
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                list1.add(curr);
            }else{
                list2.add(curr);
            }
            curr = curr.next;
        }
        list1.addAll(list2);

        return convFromList(list1);
    }

    public ListNode convFromList(ArrayList<ListNode> list){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int i = 0; i < list.size(); i++){
            curr.next = new ListNode(list.get(i).val); // Create a new node with the value
            curr = curr.next;
        }
        return dummy.next;
    }
}