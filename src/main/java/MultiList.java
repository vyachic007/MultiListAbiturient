import java.util.Arrays;

public class MultiList {
    private static final int MAIN_LIST = 0;
    private static final int EXCELLENT_EXAMS = 1;
    private static final int HONORS_DIPLOMA = 2;
    private static final int OUT_OF_TOWN = 3;
    private static final int NEEDS_DORMITORY = 4;

    private final SinglyLinkedList[] lists;
    private final String universityCity;


    public MultiList(String universityCity) {
        this.universityCity = universityCity;
        lists = new SinglyLinkedList[5];

        lists[MAIN_LIST] = new SinglyLinkedList("Все абитуриенты", MAIN_LIST);
        lists[EXCELLENT_EXAMS] = new SinglyLinkedList("Все экзамены на 5", EXCELLENT_EXAMS);
        lists[HONORS_DIPLOMA] = new SinglyLinkedList("Аттестат с отличием", HONORS_DIPLOMA);
        lists[OUT_OF_TOWN] = new SinglyLinkedList("Иногородние", OUT_OF_TOWN);
        lists[NEEDS_DORMITORY] = new SinglyLinkedList("Нуждаются в общежитии", NEEDS_DORMITORY);
    }


    public void insertAbiturient(Abiturient data) {
        MultiListNode newNode = new MultiListNode(data, lists.length);

        lists[MAIN_LIST].insertAtEnd(newNode);

        if (Arrays.stream(data.getExamScore()).allMatch(score -> score == 5)) {
            lists[EXCELLENT_EXAMS].insertAtEnd(newNode);
        }

        if (data.isHasHonorsDiploma()) {
            lists[HONORS_DIPLOMA].insertAtEnd(newNode);
        }

        if (!data.getCity().equalsIgnoreCase(universityCity)) {
            lists[OUT_OF_TOWN].insertAtEnd(newNode);
        }

        if (data.isNeedsDormitory()) {
            lists[NEEDS_DORMITORY].insertAtEnd(newNode);
        }
    }



    public boolean deleteAbiturient(String lastName) {
        MultiListNode nodeToDelete = null;

        MultiListNode current = lists[MAIN_LIST].getFirst();
        MultiListNode previous = null;

        while (current != null) {
            if (current.getData().getLastName().equalsIgnoreCase(lastName)) {
                nodeToDelete = current;
                break;
            }
            previous = current;
            current = current.getNext()[MAIN_LIST];
        }

        if (nodeToDelete == null) {
            System.out.println("Абитуриент с фамилией '" + lastName + "' не найден.");
            return false;
        }

        for (SinglyLinkedList list : lists) {
            MultiListNode prev = null;
            MultiListNode curr = list.getFirst();
            while (curr != null) {
                if (curr == nodeToDelete) {
                    list.deleteNode(nodeToDelete, prev);
                    break;
                }
                prev = curr;
                curr = curr.getNext()[list.getListIndex()];
            }
        }

        System.out.println("Абитуриент '" + lastName + "' удалён из всех списков.");
        return true;
    }


    public void clearAll() {
        for (SinglyLinkedList list : lists) {
            list.clear();
        }
        System.out.println("Все списки очищены.");
    }


    public void displayMainList() {
        lists[MAIN_LIST].display();
    }

    public void displayByCriterion(int index) {
        if (index >= 0 && index < lists.length) {
            lists[index].display();
        } else {
            System.out.println("Некорректный индекс списка.");
        }
    }
}
