import java.util.HashMap;
import java.util.Map;

class LFUCache {

    class Node {
        int key, value, cnt;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }

    class DLList {
        int size;
        Node head, tail;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private Map<Integer, Node> keyNode;
    private Map<Integer, DLList> freqMap;
    private int capacity;
    private int size;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void update(Node node) {
        int freq = node.cnt;
        DLList list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.cnt++;

        DLList newList = freqMap.getOrDefault(node.cnt, new DLList());
        newList.addFront(node);
        freqMap.put(node.cnt, newList);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            update(node);
            return;
        }

        if (size == capacity) {
            DLList list = freqMap.get(minFreq);
            Node nodeToRemove = list.tail.prev;
            list.remove(nodeToRemove);
            keyNode.remove(nodeToRemove.key);
            size--;
        }

        Node node = new Node(key, value);
        minFreq = 1;

        DLList list = freqMap.getOrDefault(1, new DLList());
        list.addFront(node);
        freqMap.put(1, list);

        keyNode.put(key, node);
        size++;
    }
}