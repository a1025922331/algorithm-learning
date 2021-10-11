/**
 * @Author: guozexin.gzx
 * @Date: 2021/9/21
 */
class MyHashMap {
    private class Node {
        final private int hash;
        final private int key;
        private int value;
        Node next;

        public Node() {
            this.hash = -1;
            this.key = -1;
            this.value = -1;
            this.next = null;
        }

        public Node(int hash, int key, int value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    final private double LOAD_FACTOR = 0.75;
    private Node[] table;
    private int size;
    private int threshold;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        size = 0;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (table == null || size >= threshold) {
            resize();
        }
        int hash = hash(key);
        int index = indexOfHash(hash);
        table[index] = putToNodeList(index, hash, key, value);
    }

    private void resize() {
        if (table == null) {
            table = new Node[16];
        } else {
            int oldCap = table.length;
            int newCap = oldCap << 1;
            Node[] oldTable = table;
            Node[] newTable = new Node[newCap];
            for (int i = 0; i < oldCap; i++) {
                if (oldTable[i] == null) {
                    continue;
                } else {
                    Node lowHead = new Node(), low = lowHead;
                    Node highHead = new Node(), high = highHead;
                    Node node = oldTable[i];
                    while (node != null) {
                        if ((node.hash & oldCap) == 0) {
                            low.next = node;
                            low = low.next;
                        } else {
                            high.next = node;
                            high = high.next;
                        }
                        node = node.next;
                    }
                    low.next = null;
                    high.next = null;
                    newTable[i] = lowHead.next;
                    newTable[i + oldCap] = highHead.next;
                    oldTable[i] = null;
                }
            }
            table = newTable;
        }
        threshold = (int) (table.length * LOAD_FACTOR);
    }

    private Node putToNodeList(int index, int hash, int key, int value) {
        Node head = new Node(), prev;
        head.next = table[index];
        prev = head;
        while (prev.next != null) {
            if (prev.next.getKey() == key) {
                prev.next.setValue(value);
                return head;
            }
            prev = prev.next;
        }
        prev.next = new Node(hash, key, value, null);
        size++;
        return head.next;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (table != null) {
            int hash = hash(key);
            int index = indexOfHash(hash);

            Node cur = table[index];
            while (cur != null) {
                if (cur.getKey() == key) {
                    return cur.getValue();
                }
                cur = cur.next;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (table != null) {
            int hash = hash(key);
            int index = indexOfHash(hash);
            table[index] = removeFromNodeList(index, key);
        }
    }

    private Node removeFromNodeList(int index, int key) {
        Node head = new Node(), prev;
        head.next = table[index];
        prev = head;
        while (prev.next != null) {
            if (prev.next.getKey() == key) {
                prev.next = prev.next.next;
                size--;
                return head.next;
            }
            prev = prev.next;
        }
        return head.next;
    }

    /**
     * 含扰动函数，利用上高位和低位的hashCode使得Entry能在固定数目的哈希桶上均匀分布
     */
    private int hash(int key) {
        // 将扰动方程作用在元素的hashCode()上，此处int的hashCode为其本身
        return key ^ (key >> 16);
    }

    private int indexOfHash(int hash) {
        // 由于table的size为2的n次方，故可以利用位运算代替模运算
        return hash & (table.length - 1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
