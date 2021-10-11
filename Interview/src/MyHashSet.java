/**
 * @Author: guozexin.gzx
 * @Date: 2021/9/21
 */
class MyHashSet {
    final static double LOAD_FACTOR = 0.75;
    Node[] table;
    int size;
    int threshold;

    private class Node {
        final int hash;
        final int key;
        Node next;

        public Node() {
            hash = -1;
            key = -1;
            next = null;
        }

        public Node(int hash, int key, Node next) {
            this.hash = hash;
            this.key = key;
            this.next = null;
        }
    }


    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        size = 0;
    }

    public void add(int key) {
        if (table == null || size >= threshold) {
            resize();
        }
        int hash = hash(key);
        int index = indexOfHash(hash);
        table[index] = addToList(index, hash, key);
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
                    oldTable[i] = null;
                    newTable[i] = lowHead.next;
                    newTable[i + oldCap] = highHead.next;
                }
            }
            table = newTable;
        }
        threshold = (int) (table.length * LOAD_FACTOR);
    }


    private Node addToList(int index, int hash, int key) {
        Node head = new Node(), prev = head;
        head.next = table[index];
        while (prev.next != null) {
            if (prev.next.key == key) {
                return head.next;
            }
            prev = prev.next;
        }
        prev.next = new Node(hash, key, null);
        size++;
        return head.next;
    }

    public void remove(int key) {
        if (table != null) {
            int hash = hash(key);
            int index = indexOfHash(hash);
            table[index] = removeFromList(index, key);
        }
    }

    private Node removeFromList(int index, int key) {
        Node head = new Node(), prev = head;
        head.next = table[index];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                size--;
                return head.next;
            }
            prev = prev.next;
        }
        return head.next;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (table != null) {
            int hash = hash(key);
            int index = indexOfHash(hash);
            return listContains(index, key);
        }
        return false;
    }

    private boolean listContains(int index, int key) {
        Node cur = table[index];
        while (cur != null) {
            if (cur.key == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private int hash(int key) {
        // hashCode + 扰动函数
        return key ^ (key >> 16);
    }

    private int indexOfHash(int hash) {
        return hash & (table.length - 1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */