package com.striver.dsa.heap;

import java.util.List;
import java.util.PriorityQueue;

class PairII<k,v>{
    k key;
    v value;

    public PairII(k key, v value) {
        this.key = key;
        this.value = value;
    }
}

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

public class MergeKSortedLL {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        if(lists.length == 0 || (lists.length == 1 && lists[0] == null)) return dummy.next;
        PriorityQueue<PairII<Integer, ListNode>> minHeap = new PriorityQueue<>((a, b)-> a.key - b.key);
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(new PairII<>(node.val,node));
            }
        }
        int k = lists.length;
        while(!minHeap.isEmpty()){
            PairII<Integer,ListNode> pair = minHeap.poll();
            temp.next = pair.value;
            if(pair.value.next != null){
                minHeap.add(new PairII<>(pair.value.next.val,pair.value.next));
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
