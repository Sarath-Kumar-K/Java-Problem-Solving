
// leetcode 148

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Mergesort {
    ListNode getMid(ListNode head){
        ListNode midPrev = null;
        
        while(head!=null && head.next!=null){
            midPrev=(midPrev==null)?head:midPrev.next;
            head=head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next=null;
        return mid;
    }
    ListNode merge(ListNode list1,ListNode list2){
        if(list1==null && list2==null){
            return list1;
        }
        if(list1==null || list2==null){
            return (list1==null)? list2:list1;
        }
        
        ListNode head,curr,opp,temp;
        if(list1.val > list2.val){
            head=list2;
            curr=list2;
            opp=list1;
        }else{
            head=list1;
            curr=list1;
            opp=list2;
        }
        
        while(curr.next!=null){
            if(curr.next.val > opp.val){
                temp = curr.next;
                curr.next = opp;
                curr = opp;
                opp = temp;
            }else{
                curr=curr.next;
            }
        }
        curr.next=opp;
        return head;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left,right);
    }
}


