class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // remove from DLL
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // add to DLL
    public void add(Node node) {
        Node prev = tail.prev; 

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);

        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            remove(map.get(key));
        
        Node node = new Node(key, value);
        add(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */