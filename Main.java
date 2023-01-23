public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.append(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);

        doublyLinkedList.add(0, 0);
        int listLength = doublyLinkedList.listLength();
        System.out.println("listLength: " + listLength);
//
        doublyLinkedList.printList();
        doublyLinkedList.printListReverse();

        System.out.println("Value at given index: " + doublyLinkedList.searchList(0));
        System.out.println("Value at given index: " + doublyLinkedList.searchList(6));
        System.out.println("Value at given index: " + doublyLinkedList.searchListReverse(0)); 
        System.out.println("Value at given index: " + doublyLinkedList.searchListReverse(6)); 

        doublyLinkedList.delete(listLength - 1);
        doublyLinkedList.printList();
    }
}
