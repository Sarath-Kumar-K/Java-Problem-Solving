
// leetcode 142

public class Cyclestart {
    static int cycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        do{
            if(fast==null || fast.next==null){
                return 0;
            }
            slow=slow.next;
            fast=fast.next.next;
        }while(slow!=fast);
        int length = 0;
        do{
            fast=fast.next;
            length++;
        }while(fast!=slow);
        return length;
    }
    static ListNode detectCycle(ListNode head) {
        int length = cycleLength(head);
        if(length==0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(length >0){
            slow = slow.next;
            length--;
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        System.out.println(detectCycle(node));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
