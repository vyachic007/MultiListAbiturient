package model;

import lombok.Getter;

@Getter
public class MultiListNode {
    private final Abiturient data;
    private MultiListNode[] next;
    private MultiListNode[] prev;

    public MultiListNode(Abiturient data, int numberOfLists) {
        this.data = data;
        this.next = new MultiListNode[numberOfLists];
        this.prev = new MultiListNode[numberOfLists];
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
