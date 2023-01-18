// When do I have to use this and when not?

public class DoublyLinkedList<T> {
    ListNode<T> head;
    ListNode<T> tail;

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public DoublyLinkedList(ListNode<T> head, ListNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // Leave this constructor so you can call class without arguments, too
    public DoublyLinkedList() {

    }

    void append(T value) {
        ListNode<T> node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
        } else if (this.head != null && this.tail == null) {
            // Was, wenn schon Nodes zwischen Head und Tail sind? A: Dann waere tail nicht gleich null
            // head und tail verknuepfen
            this.tail = node;
            this.head.next = tail;
            this.tail.previous = this.head;
        } else {
            // Ich haenge den neuen Knoten vor tail an. Am besten, wenn tail (und head) leere Knoten sind, nur Einstiegsstellen.
//            this.tail.previous.next = node;
//            this.tail.previous = node;
//            node.next = tail;

            // Option 2: Ich haenge den neuen Node nach tail dran, und verschiebe tail auf den letzten Knoten.
            this.tail.next = node;
            this.tail = node;
            
        }
    }

}
