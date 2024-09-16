public class DoublLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }}
        public  Node head;
        public  Node tail;
        public  int size;

        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
//            Print
            public void print(){
                Node temp = head;
                while (temp != null) {
                    System.out.print(temp.data + "<->");
                    temp = temp.next;
                }
                System.out.println("null");
            }
            // remove - removeLast
            public int removeFirst(){
                if (head == null) {
                    System.out.println("DL is empty");
                    return Integer.MIN_VALUE;
                }
                if (size == 1){
                    int val = head.data;
                    head = tail = null;
                    size--;
                    return val;
            }
                int val = head.data;
                head = head.next;
                head.prev = null;
                size--;
                return val;
        }
        public void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        public static void main(String args[]){
            DoublLL dLL = new DoublLL();
            dLL.addFirst(3);
            dLL.addFirst(2);
            dLL.addFirst(1);
            dLL.print();
            dLL.reverse();
            dLL.print();
}
    }
