package com.striver.dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

class DllNode {
    int key;
    int value;
    DllNode next;
    DllNode prev;

    public DllNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    private Map<Integer, DllNode> mp;
    private DllNode head;
    private DllNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.mp = new HashMap<>();
        this.head = new DllNode(-1, -1);
        this.tail = new DllNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }

    //insert After head
    private void insertAfterHead(DllNode node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    //delete node
    private void deleteNode(DllNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    //get function
    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        DllNode node = mp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    //put function
    public void put(int key, int value) {
        //Already exist
        if (mp.containsKey(key)) {
            DllNode node = mp.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
            mp.put(key, node);
        } else {
            //check capacity
            if (capacity == mp.size()) {
                //delete last node
                DllNode node = mp.get(tail.prev.key);
                deleteNode(node);
                mp.remove(node.key);
            }
            DllNode newNode = new DllNode(key, value);
            insertAfterHead(newNode);
            mp.put(key, newNode);
        }
    }

    public void printCache() {
        DllNode temp = head;
        while (temp != null) {
            System.out.println("Key " + temp.key + " value: " + temp.value);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.printCache();
        System.out.println(cache.get(1));
        cache.printCache();
        cache.put(4,4);
        cache.printCache();
        System.out.println(cache.get(2));
    }
}
