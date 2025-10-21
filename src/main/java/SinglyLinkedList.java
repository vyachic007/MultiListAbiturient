import lombok.Getter;

@Getter
public class SinglyLinkedList {
    private MultiListNode first;
    private MultiListNode last;
    private final String name;
    private final int listIndex;

    public SinglyLinkedList(String name, int listIndex) {
        this.name = name;
        this.listIndex = listIndex;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertAtEnd(MultiListNode newNode) {
        if (newNode == null) return;

        newNode.getNext()[listIndex] = null;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.getNext()[listIndex] = newNode;
            last = newNode;
        }
    }

    public void deleteNode(MultiListNode nodeToDelete, MultiListNode previousNode) {
        if (isEmpty() || nodeToDelete == null) return;

        if (previousNode == null) {
            first = nodeToDelete.getNext()[listIndex];
            if (first == null) {
                last = null;
            }
        } else {
            previousNode.getNext()[listIndex] = nodeToDelete.getNext()[listIndex];
        }

        if (nodeToDelete == last) {
            last = previousNode;
        }

        nodeToDelete.getNext()[listIndex] = null;
    }

    public void clear() {
        first = null;
        last = null;
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