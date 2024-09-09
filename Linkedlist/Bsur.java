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
// Bubble sort using recursion -> Bsur
public class Bsur {
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
    ListNode getNode(ListNode head,int index){
        int i = 0;
        ListNode curr = null;
        while(i<=index){
            curr=(i==0)?head:curr.next;
            i++;
        }
        return curr;
    }
    ListNode bubblesort(ListNode head,int left,int right){
        if(right<=0){
            return head;
        }
        
        if(left < right){
            ListNode first = getNode(head,left);
            if(first.val > first.next.val){
                if(first==head){
                    head=first.next;
                    first.next=head.next;
                    head.next=first;
                }else if(first.next.next==null){
                    ListNode prev = getPrev(head,first);
                    prev.next=first.next;
                    first.next.next=first;
                    first.next=null;
                }else{
                    ListNode prev = getPrev(head,first);
                    prev.next=first.next;
                    first.next=prev.next.next;
                    prev.next.next=first;
                }
            }
            return bubblesort(head,left+1,right);
        }else{
            return bubblesort(head,0,right-1);
        }
    }
    public ListNode sortList(ListNode head){
        int length=getLength(head);
        return bubblesort(head,0,length-1);
    }
}
