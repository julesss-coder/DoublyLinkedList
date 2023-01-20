/*
TODOS
- [x] append
- [x] add(index)
- [ ] printList
- [ ] printListReverse
- [ ] listLength
- [ ] seekList(index)
- [ ] seekListReverse(index)
- [ ] delete(index)
    - [ ] Decrement nodeCounter upon removing a node

- [ ] Implement iterator
- [ ] Add access modifiers to classes, fields and methods
- [ ] Add static

QUESTIONS:
- When do I have to use `this` inside a class, and when not?
- Should `head` and `tail` in `DoublyLinkedList` be private?
 */
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);

        int listLength = doublyLinkedList.listLength();
        doublyLinkedList.add(0, 0);

        // Print list
        System.out.println("Doubly linked list: ");
        ListNode<Integer> currentNode = doublyLinkedList.head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
