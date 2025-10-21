import lombok.Getter;

@Getter
public class SinglyLinkedList {
    private MultiListNode first;
    private MultiListNode last;
    private MultiListNode ptr;
    private final String name;
    private final int listIndex;

    public SinglyLinkedList(String name, int listIndex) {
        this.name = name;
        this.listIndex = listIndex;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean contains(MultiListNode node) {
        MultiListNode current = first;
        while (current != null) {
            if (current == node) return true;
            current = current.getNext()[listIndex];
        }
        return false;
    }

    public void insertAtEnd(MultiListNode newNode) {
        if (newNode == null) return;

        if (contains(newNode)) return;

        newNode.getNext()[listIndex] = null;

        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.getNext()[listIndex] = newNode;
            last = newNode;
        }
    }

    public void deleteNode(MultiListNode nodeToDelete, MultiListNode previousNode) {
        if (isEmpty() || nodeToDelete == null) return;

        if (previousNode == null) {
            first = nodeToDelete.getNext()[listIndex];
        } else {
            previousNode.getNext()[listIndex] = nodeToDelete.getNext()[listIndex];
        }

        if (nodeToDelete == last) {
            last = previousNode;
        }

        nodeToDelete.getNext()[listIndex] = null;
    }

    public void display() {
        System.out.println("=== Список: " + name + " ===");
        MultiListNode current = first;
        int index = 1;
        while (current != null) {
            System.out.printf("%d) %s%n", index++, current.getData());
            current = current.getNext()[listIndex];
        }
        System.out.println("=============================");
    }
}
