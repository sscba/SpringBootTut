package com.striver.dsa.linkedlist;

public class FlattenLL {

    private class NestedLL{
        int val;
        NestedLL next;
        NestedLL child;

        public NestedLL(int val) {
            this.val = val;
        }

        public NestedLL(NestedLL next, int val) {
            this.next = next;
            this.val = val;
        }

        public NestedLL(NestedLL next, int val, NestedLL child) {
            this.next = next;
            this.val = val;
            this.child = child;
        }
    }

    public NestedLL flattenLL(NestedLL head){
        NestedLL temp  = head;
        singleLL(temp);
        temp = mergeSort(temp);
        return temp;
    }

    private NestedLL mergeSort(NestedLL head) {
        if(head == null || head.next == null) return head;

        NestedLL mid = findMid(head);
        NestedLL topHead = head;
        NestedLL bottomHead = mid.child;
        mid.child = null;

        topHead = mergeSort(topHead);
        bottomHead = mergeSort(bottomHead);

        return merge(topHead,bottomHead);

    }

    private NestedLL merge(NestedLL topHead,NestedLL bottomHead) {
        NestedLL dummy = new NestedLL(-1);
        NestedLL temp = dummy;
        NestedLL l1 = topHead;
        NestedLL l2 = bottomHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.child = l1;
                temp = l1;
                l1 = l1.child;
            }else{
                temp.child = l2;
                temp = l2;
                l2 = l2.child;
            }
        }

        temp.child = l1 == null ? l2 : l1;

        return dummy.child;
    }

    private NestedLL findMid(NestedLL head) {
        NestedLL fast = head;
        NestedLL slow = head;
        while(fast != null && fast.child != null){
            fast = fast.child.child;
            slow = slow.child;
        }
        return slow;
    }

    private NestedLL singleLL(NestedLL head) {
        NestedLL temp = head;
        while(temp != null){
            NestedLL downNode = temp;
            while(downNode.child != null){
                downNode = downNode.child;
            }
            downNode.child = temp.next;
            temp.next = null;
            temp = downNode.child;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
