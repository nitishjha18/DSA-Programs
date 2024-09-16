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

    public static void removeCycle(){

//        detetect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;      // +1
            fast = fast.next.next; // +2
            if (fast == slow){
                cycle = true;
                break;
            }
        }
        if (cycle == false){
            return;
        }

//          Find meeting point
        slow = head;
        Node prev = null;     // last node
        while (slow != fast){
            prev = fast;
            slow = slow.next;    // +1
            fast = fast.next;    // +1
        }
//          remove cycle --> last.next = null
        prev.next = null;
    }
//    Merge Sort on a linked list

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;               // mid Node
    }
    private Node merge(Node head1, Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
//        find mid
        Node mid = getMid(head);
//        left & right M.S
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
//        merge
        return merge(newLeft, newRight);
    }
    public void zigzag(){
//        Find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
//        Reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL , nextR;

//      Alternate merge - zig-zag merge
        while (left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void main (String args[]){
        linkedlist ll = new linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
//      1->2->3->4->5
        ll.print();
        ll.zigzag();
//      1->5->2->4->3
        ll.print();
    }

}
