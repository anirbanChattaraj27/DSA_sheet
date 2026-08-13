// https://takeuforward.org/data-structure/implement-lru-cache
// LC 146: https://leetcode.com/problems/lru-cache/

import java.util.HashMap;

class LRUCache {

    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;

    // Dummy head and tail
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from DLL
    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Insert node right after head (Most Recently Used)
    private void insert(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Get value by key
    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        // Move to front
        remove(node);
        insert(node);

        return node.value;
    }

    // Insert or update
    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            insert(node);

            return;
        }

        // Cache full -> remove LRU
        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insert(newNode);
        map.put(key, newNode);
    }

    // Print cache (MRU -> LRU)
    public void display() {

        Node curr = head.next;

        System.out.print("Cache : ");

        while (curr != tail) {
            System.out.print("[" + curr.key + "=" + curr.value + "] ");
            curr = curr.next;
        }

        System.out.println();
    }
}

public class O1_LRU_cache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.display();

        cache.put(2, 20);
        cache.display();

        System.out.println("get(1) = " + cache.get(1));
        cache.display();

        cache.put(3, 30);
        cache.display();

        System.out.println("get(2) = " + cache.get(2));

        cache.put(4, 40);
        cache.display();

        System.out.println("get(1) = " + cache.get(1));
        System.out.println("get(3) = " + cache.get(3));
        System.out.println("get(4) = " + cache.get(4));
    }
}