package DoublyLinkedList;

public class DoublyLinkedList {

    private int size;
    private Node firstNode, lastNode, nodePointer, newNode;

    public DoublyLinkedList() {
        firstNode = lastNode = null;
    }

    /**
     * Add a new value to the list.
     *
     * @param number
     */
    public void add(int number) {
        // Instatiates a node with the new value.
        newNode = new Node(number);
        // Check if the list is empty before adding the first node.
        if (isEmpty()) {
            firstNode = lastNode = new Node(number);
            size++;
        } 
        // Check if the new node should be the first node.
        // If so, points the new node's next node to the first ~old~ node.
        // Then the first ~old~ node's previous node to the new node.
        // And the turns the first node into the new node.
        // And implements size.
        else if (number < firstNode.value) {
            newNode.next = firstNode;
            firstNode.prev = newNode;
            firstNode = newNode;
            size++;
        } 
        // Check if the new node should be the last node.
        // If so, points the new node's previous node to the last ~old~ node.
        // Then the last ~old~ node's next node to the new node.
        // And the turns the last node into the new node.
        // And implements size.
        else if (number > lastNode.value) {
            newNode.prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            size++;
        } 
        // Checks if the new node is between the first and last node. 
        // Then, creates a new node as a pointer.
        // Makes the pointer run the list and it stops when
        // a bigger value is found (nodePointer).
        else if (number > firstNode.value && number < lastNode.value) {
            // Creates a new node to run the list pointing the nodes.
            nodePointer = firstNode;
            // Makes the pointer go through the list.
            while (newNode.value >= nodePointer.value) {
                nodePointer = nodePointer.next;
            }
            newNode.next = nodePointer;
            nodePointer.prev = newNode;
            Node oldNodePrev = nodePointer.prev;
            newNode.prev = oldNodePrev;
            oldNodePrev.next = newNode;
            size++;
        } else {
            System.out.println(number + " is already on the list.");
        }
    }

    /**
     * Remove a node by it's value.
     *
     * @param number
     */
    public void remove(int number) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else if (isOnTheList(number)) {
            newNode = new Node(number);
            if (number == firstNode.value) {
                firstNode = firstNode.next;
                firstNode.prev = null;
                size--;
            } else if (number == lastNode.value) {
                lastNode = lastNode.prev;
                lastNode.next = null;
                size--;
            } else if (number > firstNode.value && number < lastNode.value) {
                nodePointer = firstNode;
                while (newNode.value >= nodePointer.value) {
                    nodePointer = nodePointer.next;
                    if (newNode.value == nodePointer.value) {
                        break;
                    }
                }
                Node oldNodePrev = nodePointer.prev;
                Node oldNodeNext = nodePointer.next;
                oldNodePrev.next = oldNodeNext;
                oldNodeNext.prev = oldNodePrev;
                size--;
            }
        } else {
            System.out.println(number + " is not on the list.");
        }
    }

    /**
     * Checks if a value is on the list.
     *
     * @param number
     * @return
     */
    public boolean isOnTheList(int number) {
        nodePointer = firstNode;
        while (nodePointer != null) {
            if (nodePointer.value == number) {
                return true;
            }
            nodePointer = nodePointer.next;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        nodePointer = firstNode;
        string.append("[ ");
        while (nodePointer != null) {
            string.append(nodePointer.value);
            if (nodePointer.next != null) {
                string.append(" | ");
            }
            nodePointer = nodePointer.next;
        }
        string.append(" ]");
        return string + " Size: " + size;
    }
    
}
