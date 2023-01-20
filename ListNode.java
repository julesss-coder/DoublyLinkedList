public class ListNode<T> {
    T value;
    // class ListNode hat zwei ListNodes. Da jeder ListNode 2 ListNodes hat, haben auch diese 2 ListNodes.
    ListNode<T> next;
    ListNode<T> previous;

    ListNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "value=" + value +
//                ", next=" + next +
//                ", previous=" + previous +
//                '}';
//    }
}
