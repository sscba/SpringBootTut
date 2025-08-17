package com.striver.dsa.linkedlist;

public class Sort012LL {

    public ListNode sort012(ListNode head){
        ListNode temp = head;
        int cnt0=0;
        int cnt1=0;
        int cnt2=0;
        while(temp != null){
            if(temp.val == 0) cnt0++;
            else if(temp.val == 1) cnt1++;
            else if(temp.val == 2) cnt2++;
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(cnt0 > 0){
                temp.val = 0;
                cnt0--;
            }

            else if(cnt1 > 0){
                temp.val = 1;
                cnt1--;
            }
            else if(cnt2 > 0){
                temp.val = 2;
                cnt2--;
            }

            temp = temp.next;
        }

        return head;
    }

    public ListNode rearrangePointer(ListNode head){
        ListNode temp = head;
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        while(temp != null){
            if(temp.val == 0 ){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.val == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = oneHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,1,2,0,0,2,2,1,0,0,0};

        ListNode head = LinkedList.convertArrToListNode(arr1);

        ListNode sorted = new Sort012LL().rearrangePointer(head);
        LinkedList.traverseLL(sorted);

    }
}
