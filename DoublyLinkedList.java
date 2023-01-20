public class DoublyLinkedList<T> {
    // Should head and tail be private?
    ListNode<T> head;
    ListNode<T> tail;
    private int nodeCounter = 0;

//    @Override
//    public String toString() {
//        return "DoublyLinkedList{" +
//                "head=" + head +
//                ", tail=" + tail +
//                '}';
//    }

    public DoublyLinkedList(ListNode<T> head, ListNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // Leave this constructor so you can call class without arguments, too
    public DoublyLinkedList() {}

    public void append(T value) {
        ListNode<T> node = new ListNode(value);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            nodeCounter++;
        } else if (this.head == this.tail) {
            this.head.next = node;
            this.tail = node;
            this.tail.previous = this.head;
            nodeCounter++;
//            System.out.println("this.head.next.value: " + this.head.next.value); // exp 2
//            System.out.println("this.head.value: " + this.head.value); // exp 1
//            System.out.println("this.tail.value: " + this.tail.value); // exp 2
//            System.out.println("this.tail.previous.value: " + this.tail.previous.value); // exp 1
        } else {
            this.tail.next = node;
//            System.out.println("line 41: " + this.tail.next.value); //exp: 3
            node.previous = this.tail;
//            System.out.println("line 43 : " + node.previous.value); // exp.: 2
            this.tail = node;
//            System.out.println("line 45 : " + this.tail.value); // exp.: 3
            this.tail.next = null;
            nodeCounter++;
//            System.out.println("this.tail.value: " + this.tail.value); // exp.: 3
//            System.out.println(this.tail.next == null); // should be true
//            System.out.println("this.tail.previous.value: " + this.tail.previous.value); // 2
        }

        System.out.println("Number of nodes: " + nodeCounter);
    }

    public void add(int index, T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        int indexCounter = 0;

        // Case: listLength === 0 || listLength === 1 || index === listLength (insert after last element)
        if (nodeCounter == 0 || nodeCounter == 1 || index == nodeCounter) {
            append(value);
        }

        // Case: no element at given index:
            //  Does add() insert elements at non-existing indices other than tailIndex + 1? If so, do I have to create empty nodes until I reach the given index?
                // No. Just throw an error. Index out of bounds.
        if (index > nodeCounter) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds."); // However, it is possible to pass in index = listLength, which is out of bounds, too. => Need better exception message.
        }

        // Case: listLength >= 2
        if (nodeCounter >= 2) {
            ListNode<T> currentNode = this.head;

            if (index == 0) {
//                currentNode.previous = newNode;
//                newNode.next = currentNode;
//                this.head = newNode;
                this.head.previous = newNode;
                newNode.next = this.head;
                this.head = newNode;
                nodeCounter++;
//                System.out.println("add() runs");
//                System.out.println("this.head.value " + this.head.value); // exp.: 0
//                System.out.println("this.head.next.value " + this.head.next.value); // exp.: 1
//                System.out.println("this.head.next.previous.value " + this.head.next.previous.value); // exp.: 0
            } else {
                while (indexCounter != index) {
                    indexCounter++;
                    currentNode = currentNode.next;
                }
                ListNode<T> leftNode = currentNode.previous;
                leftNode.next = newNode;
                newNode.previous = leftNode;
                newNode.next = currentNode;
                currentNode.previous = newNode;
                nodeCounter++;
            }
        }

        System.out.println("Number of nodes: " + nodeCounter);
    }

    public int listLength() {
        return nodeCounter;
    }
}
