package com.striver.dsa.linkedlist;

import java.util.HashMap;

class CNode{
    int val;
    CNode next;
    CNode random;

    public CNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class CopyLL {

    public CNode copyLL(CNode head){
        if(head == null && head.next == null) return head;
        CNode temp = head;
        HashMap<CNode,CNode> mp = new HashMap<>();

        while(temp != null){
            CNode node = new CNode(temp.val);
            mp.put(temp,node);
            temp = temp.next;
        }

        temp = head;
        CNode copyHead = mp.get(temp);

        while(temp != null){
            CNode copyNode = mp.get(temp);
            copyNode.next = mp.get(temp.next);
            copyNode.random = mp.get(temp.random);
            temp = temp.next;
        }

        return copyHead;

    }

    public CNode optimal(CNode head){
        CNode temp = head;

        //add copied node in between original node
        while(temp != null){
            CNode node = new CNode(temp.val);
            CNode nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
            temp = temp.next.next;
        }

        //connect random pointers of copynode to original nodes
        temp = head;
        while(temp != null){
            CNode copyNode = temp.next;
            copyNode.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        //separate org and copy and return copyHead;
        CNode dummy = new CNode(-1);
        CNode res = dummy;
        temp = head;

        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
