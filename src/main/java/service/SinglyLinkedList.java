package service;

import lombok.Getter;
import model.MultiListNode;
import util.Messages;

@Getter
public class SinglyLinkedList {
    private MultiListNode first;
    private MultiListNode last;
    private final String name;

    public SinglyLinkedList(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertAtEnd(MultiListNode newNode, int listIndex) {
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

    public void deleteNode(MultiListNode nodeToDelete, MultiListNode previousNode, int listIndex) {
        if (isEmpty() || nodeToDelete == null) return;

        if (previousNode == null) {
            first = nodeToDelete.getNext()[listIndex];
            if (first != null) {
                first.getPrev()[listIndex] = null;
            }
        } else {
            previousNode.getNext()[listIndex] = nodeToDelete.getNext()[listIndex];
            if (nodeToDelete.getNext()[listIndex] != null) {
                nodeToDelete.getNext()[listIndex].getPrev()[listIndex] = previousNode;
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

    public void display(int listIndex) {
        System.out.println(String.format(Messages.LIST_HEADER, name));
        MultiListNode current = first;
        int index = 1;
        while (current != null) {
            System.out.printf(Messages.LIST_ITEM + "%n", index++, current.getData());
            current = current.getNext()[listIndex];
        }
        System.out.println(Messages.LIST_FOOTER);
    }
}
