package DoublyLinkedList;

public class Teste {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(8);

        System.out.println(list.toString());

        list.remove(2);
        list.remove(0);
        list.add(8);

        System.out.println(list.toString());
    }
}
