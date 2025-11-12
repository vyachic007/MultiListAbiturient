package service;

import model.Abiturient;
import model.MultiListNode;
import util.Messages;

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

        lists[MAIN_LIST] = new SinglyLinkedList("Все абитуриенты");
        lists[EXCELLENT_EXAMS] = new SinglyLinkedList("Все экзамены на 5");
        lists[HONORS_DIPLOMA] = new SinglyLinkedList("Аттестат с отличием");
        lists[OUT_OF_TOWN] = new SinglyLinkedList("Иногородние");
        lists[NEEDS_DORMITORY] = new SinglyLinkedList("Нуждаются в общежитии");
    }

    public void insertAbiturient(Abiturient data) {
        MultiListNode newNode = new MultiListNode(data, lists.length);

        lists[MAIN_LIST].insertAtEnd(newNode, MAIN_LIST);

        if (Arrays.stream(data.getExamScore()).allMatch(score -> score == 5)) {
            lists[EXCELLENT_EXAMS].insertAtEnd(newNode, EXCELLENT_EXAMS);
        }

        if (data.isHasHonorsDiploma()) {
            lists[HONORS_DIPLOMA].insertAtEnd(newNode, HONORS_DIPLOMA);
        }

        if (!data.getCity().equalsIgnoreCase(universityCity)) {
            lists[OUT_OF_TOWN].insertAtEnd(newNode, OUT_OF_TOWN);
        }

        if (data.isNeedsDormitory()) {
            lists[NEEDS_DORMITORY].insertAtEnd(newNode, NEEDS_DORMITORY);
        }
    }

    public boolean deleteAbiturient(String lastName) {
        MultiListNode nodeToDelete = null;

        MultiListNode current = lists[MAIN_LIST].getFirst();

        while (current != null) {
            if (current.getData().getLastName().equalsIgnoreCase(lastName)) {
                nodeToDelete = current;
                break;
            }
            current = current.getNext()[MAIN_LIST];
        }

        if (nodeToDelete == null) {
            System.out.println(String.format(Messages.ERROR_NOT_FOUND, lastName));
            return false;
        }

        for (int i = 0; i < lists.length; i++) {
            lists[i].deleteNode(nodeToDelete, nodeToDelete.getPrev()[i], i);
        }

        System.out.println(String.format(Messages.SUCCESS_DELETE, lastName));
        return true;
    }

    public void clearAll() {
        for (SinglyLinkedList list : lists) {
            list.clear();
        }
        System.out.println(Messages.SUCCESS_CLEAR);
    }

    public void displayByCriterion(int index) {
        if (index >= 0 && index < lists.length) {
            lists[index].display(index);
        } else {
            System.out.println(Messages.ERROR_INVALID_INDEX);
        }
    }
}
