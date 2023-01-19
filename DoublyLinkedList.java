// When do I have to use this and when not?

public class DoublyLinkedList<T> {
    ListNode<T> head;
    ListNode<T> tail;

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
    public DoublyLinkedList() {

    }

    public void append(T value) {
        ListNode<T> node = new ListNode(value);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else if (this.head == this.tail) {
            this.head.next = node;
            this.tail = node;
            this.tail.previous = this.head;
            System.out.println("this.head.next.value: " + this.head.next.value); // exp 2
            System.out.println("this.head.value: " + this.head.value); // exp 1
            System.out.println("this.tail.value: " + this.tail.value); // exp 2
            System.out.println("this.tail.previous.value: " + this.tail.previous.value); // exp 1
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
            this.tail.next = null;
            System.out.println("this.tail.value: " + this.tail.value); // exp 6 // reality: 6
            System.out.println(this.tail.next == null); // should be true // reality: true
            System.out.println("this.tail.previous.value: " + this.tail.previous.value); // exp 5 // reality: 5

            // Print list
            ListNode<T> currentNode = this.head;
            while (currentNode.next != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
            System.out.println(currentNode.value);
        }
    }

    public void add(int index, T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        int indexCounter = 0;
        int listLength = this.listLength();
//        System.out.println("listLength within add method " + listLength);

        // Case: listLength === 0 || listLength === 1 || index === listLength (insert after last element)
        if (listLength == 0 || listLength == 1 || index == listLength) {
            append(value);
        }

        // Case: no element at given index:
            //  Does add() insert elements at non-existing indices other than tailIndex + 1? If so, do I have to create empty nodes until I reach the given index?
                // No. Just throw an error. Index out of bounds.
        if (index > listLength) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds."); // However, it is possible to pass in index = listLength, which is out of bounds, too. => Need better exception message.
        }

        // Case: listLength >= 2
        if (listLength >= 2) {
            ListNode<T> currentNode = this.head;

            if (index == 0) {
                currentNode.previous = newNode;
                newNode.next = currentNode;
                this.head = newNode;
                System.out.println("add() runs");
                System.out.println("this.head.value " + this.head.value); // exp.: 0
                System.out.println("this.head.next.value " + this.head.next.value); // exp.: 1
                System.out.println("this.head.next.previous.value " + this.head.next.previous.value); // exp.: 0
            } else {
                // go to element at index
                while (currentNode != null && indexCounter != index) {
                    indexCounter++;
                    currentNode = currentNode.next;
                }
                ListNode<T> leftNode = currentNode.previous;
                leftNode.next = newNode;
                newNode.previous = leftNode;
                newNode.next = currentNode;
                currentNode.previous = newNode;
                // get current element
                // get left element
                // connect new node to left element
                // connect new node to right element
                // head and tail?
                    // tail stays the same even if index == listLength - 1
                    // Case index === listLength (insert after last element) is dealt with above
                    // Case index === 0 is dealt with above
            }
        }

            // Case: Index 0 && listLength >= 2
                // get current element at index
                // connect current element to new node
                // set head to current node
    }

    public int listLength() {
        int nodeCounter = 0;
        ListNode<T> currentNode = this.head;
        while (currentNode != null) {
            nodeCounter++;
            currentNode = currentNode.next;
        }
        return nodeCounter;
    }
}
