public class ListNode<T> {
    T value;
    ListNode<T> next;
    ListNode<T> previous;

    ListNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
