import lombok.Getter;

@Getter
public class MultiListNode {
    private final Abiturient data;
    private MultiListNode[] next;

    public MultiListNode(Abiturient data, int numberOfLists) {
        this.data = data;
        this.next = new MultiListNode[numberOfLists];
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
