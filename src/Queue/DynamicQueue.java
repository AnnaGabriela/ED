package Queue;

import DoublyLinkedList.Node;

public class DynamicQueue implements TADQueue {

    private Node first, last;
    private int qtd;

    @Override
    public int dequeue() {
        int top = -1;
        if (!isEmpty()) {
            top = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
            qtd--;
        }
        return top;
    }

    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        qtd++;
    }

    @Override
    public int size() {
       return qtd;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

}
