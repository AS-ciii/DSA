package Linked_List;

class LRUCache {
    private final int cap;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList dll;
    
    private static class Node {
        int key, val;
        Node prev, next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private static class DoublyLinkedList {
        private final Node head, tail;
        
        DoublyLinkedList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        
        void remNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        void moveToHead(Node node) {
            remNode(node);
            addNode(node);
        }
        
        Node removeTail() {
            Node lru = tail.prev;
            remNode(lru);
            return lru;
        }
    }
    
    // Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap) {
        this.cap = cap;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        dll.moveToHead(node);
        return node.val;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            dll.moveToHead(node);
        } else {
            if(cache.size()>=cap) {
                Node lru = dll.removeTail();
                cache.remove(lru.key);
            }
            
            Node newN = new Node(key, value);
            cache.put(key, newN);
            dll.addNode(newN);
        }
    }
}
