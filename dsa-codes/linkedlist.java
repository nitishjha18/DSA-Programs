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
    public int recSearch(int key){
        return helper(head,key);
    }

//  Q --> Reverse the linked list (Iterative Approach)

//     REMEMBER LIKE THIS WE HAVE   -->  3 - VARIABLE
//                                  -->  4 - STEPS
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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

    //  Q --> Check if a ll is palindrome or not
    public Node findMid(Node head){   // helper
        //    SLOW-FAST approach to find the mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;        //   +1
            fast = fast.next.next;   //   +2
        }
        return slow;
    }
    public boolean checkPalindrome(){
//      base case
        if (head == null || head.next == null){
            return true;
        }
//      step 1 - find mid
        Node midNode = findMid(head);
//      step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
//      step 3 - check left and right half wheather they are equal or not
        while (right != null){
            if (left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;  // +1
            fast = fast.next.next;
            if (slow == fast){
                return true;   // cycle exist
            }
        }
        return false;          // cycle doesn't exist
    }

    public static void main (String args[]){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
//      1->2->3->1
        System.out.println(isCycle());

    }

}
