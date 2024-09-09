// leetcode 148 but time complexity only accepts merge sort algorithm of nlogn and 0(1)
class ListNode {
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
}

public class Bubblesort {
    
    int getLength(ListNode head){
        int sum=0;
        while(head!=null){
            sum++;
            head=head.next;
        }
        return sum;
    }
    ListNode getPrev(ListNode head,ListNode curr){
        ListNode node = head;
        while(node.next != curr){
            node=node.next;
        }
        return node;
    }
    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        ListNode first, prev;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            first = head;
            for (int j = 0; j < length - (i + 1); j++) {
                if (first.val > first.next.val) {
                    if (first == head) {
                        head = first.next;
                        first.next = head.next;
                        head.next = first;
                    } else if (first.next == null) {
                        prev = getPrev(head, first);
                        prev.next = first.next;
                        first.next.next = first;
                        first.next = null;
                    } else {
                        prev = getPrev(head, first);
                        prev.next = first.next;
                        first.next = prev.next.next;
                        prev.next.next = first;
                    }
                    swapped = true;
                } else {
                    first = first.next;
                }
            }
            if (!swapped)
                break;
        }
        return head;
        
    }
}
