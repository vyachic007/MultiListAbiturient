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
        newNode.getPrev()[listIndex] = null;

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.getNext()[listIndex] = newNode;
            newNode.getPrev()[listIndex] = last;
            last = newNode;
        }
    }

    public void deleteNode(MultiListNode nodeToDelete, MultiListNode previousNode) {
        if (isEmpty() || nodeToDelete == null) return;

        if (previousNode == null) {
            first = nodeToDelete.getNext()[listIndex];
            if (first != null) {
                first.getPrev()[listIndex] = null;  // ← Добавить
            }
        } else {
            previousNode.getNext()[listIndex] = nodeToDelete.getNext()[listIndex];
            if (nodeToDelete.getNext()[listIndex] != null) {
                nodeToDelete.getNext()[listIndex].getPrev()[listIndex] = previousNode;  // ← Добавить
            }
        }

        if (nodeToDelete == last) {
            last = previousNode;
        }

        nodeToDelete.getNext()[listIndex] = null;
        nodeToDelete.getPrev()[listIndex] = null;
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