/*
TODOS

- [x] append
- [ ] add(index)
- [ ] printList
- [ ] printListReverse
- [ ] listLength
- [ ] seekList(index)
- [ ] seekListReverse(index)
- [ ] delete(index)

- [ ] Implement iterator
- [ ] Add access modifiers to classes, fields and methods
- [ ] Add static

 */
public class Main {

    public static void main(String[] args) {

//        ListNode<Integer> node1 = new ListNode<>(1);
//        ListNode<Integer> node2 = new ListNode<>(2);
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);

        int listLength = doublyLinkedList.listLength();
        System.out.println(listLength);
        doublyLinkedList.add(0, 0);

        // Test add() for regular cases


//        while (node !=  null) {
//            System.out.println(node.value);
//            node = node.next;
//        }
    }
}
