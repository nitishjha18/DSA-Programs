public class linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
//        Step 1 --> create new nodes
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
//      Step 2 --> newNode.next = head
        newNode.next = head;                 // link
//      Step 3 --> head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
//        i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }

//        prev : i = size-2
        Node prev = head;
        for (int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public  int itrSearch(int key){
        Node temp = head;
        int i=0;
        while (temp != null){
            if (temp.data == key){    // key found
                return i;
            }
            temp = temp.next;
            i++;
        }
//        key not found
        return -1;
    }
    //   Q --> Iteratively searching a key using recursion
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    //  Q --> Find and remove Nth node from end
    public void deleteNthNodefromend(int n) {
//        calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;   // remove first
            return;
        }
//        sz-1
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static void main (String args[]){
        public static void main (String args[]){
            linkedlist ll = new linkedlist();
            ll.addFirst(2);
            ll.addFirst(1);
            ll.addLast(4);
            ll.addLast(5);
            ll.add(2,3);
            ll.print();
            ll.deleteNthNodefromend(3);
            ll.print();



        }
    }
