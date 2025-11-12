package ui;

import model.Abiturient;
import service.MultiList;
import util.Messages;

import java.util.Scanner;

public class UniversityApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiList multiList = new MultiList("Орел");
        boolean exit = false;

        while (!exit) {
            System.out.println(Messages.MENU_TITLE);
            System.out.println(Messages.MENU_ADD);
            System.out.println(Messages.MENU_SHOW_ALL);
            System.out.println(Messages.MENU_SHOW_EXCELLENT);
            System.out.println(Messages.MENU_SHOW_HONORS);
            System.out.println(Messages.MENU_SHOW_OUT_OF_TOWN);
            System.out.println(Messages.MENU_SHOW_DORM);
            System.out.println(Messages.MENU_DELETE);
            System.out.println(Messages.MENU_CLEAR);
            System.out.println(Messages.MENU_EXIT);
            System.out.print(Messages.MENU_PROMPT);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print(Messages.PROMPT_LAST_NAME);
                    String lastName = scanner.nextLine();

                    int[] scores = new int[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.printf(Messages.PROMPT_SCORE, i + 1);
                        scores[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.print(Messages.PROMPT_HONORS);
                    String honorsInput = scanner.nextLine().trim().toUpperCase();
                    boolean hasHonors = honorsInput.equals("Д");

                    System.out.print(Messages.PROMPT_CITY);
                    String city = scanner.nextLine();

                    System.out.print(Messages.PROMPT_DORM);
                    String dormInput = scanner.nextLine().trim().toUpperCase();
                    boolean needsDorm = dormInput.equals("Д");

                    Abiturient abiturient = new Abiturient(lastName, scores, hasHonors, city, needsDorm);
                    multiList.insertAbiturient(abiturient);
                    System.out.println(Messages.SUCCESS_ADD);
                    break;

                case "2":
                    multiList.displayByCriterion(0);
                    break;

                case "3":
                    multiList.displayByCriterion(1);
                    break;

                case "4":
                    multiList.displayByCriterion(2);
                    break;

                case "5":
                    multiList.displayByCriterion(3);
                    break;

                case "6":
                    multiList.displayByCriterion(4);
                    break;

                case "7":
                    System.out.print(Messages.PROMPT_LAST_NAME);
                    String delName = scanner.nextLine();
                    multiList.deleteAbiturient(delName);
                    break;

                case "8":
                    multiList.clearAll();
                    break;

                case "0":
                    exit = true;
                    System.out.println(Messages.SUCCESS_EXIT);
                    break;

                default:
                    System.out.println(Messages.ERROR_INVALID_CHOICE);
            }
        }

        scanner.close();
    }
}
