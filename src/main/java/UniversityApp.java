import java.util.Scanner;

public class UniversityApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MultiList multiList = new MultiList("Орел");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Меню ===");
            System.out.println("1) Ввести абитуриента");
            System.out.println("2) Показать всех абитуриентов");
            System.out.println("3) Показать отличников");
            System.out.println("4) Показать с аттестатом с отличием");
            System.out.println("5) Показать иногородних");
            System.out.println("6) Показать нуждающихся в общежитии");
            System.out.println("7) Удалить абитуриента");
            System.out.println("8) Очистить все списки");
            System.out.println("0) Выход");
            System.out.print("Выберите пункт: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Фамилия: ");
                    String lastName = scanner.nextLine();

                    int[] scores = new int[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Оценка по экзамену " + (i + 1) + ": ");
                        scores[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.print("Аттестат с отличием (Д/Н): ");
                    String honorsInput = scanner.nextLine().trim().toUpperCase();
                    boolean hasHonors = honorsInput.equals("Д");

                    System.out.print("Город проживания: ");
                    String city = scanner.nextLine();

                    System.out.print("Нуждается в общежитии (Д/Н): ");
                    String dormInput = scanner.nextLine().trim().toUpperCase();
                    boolean needsDorm = dormInput.equals("Д");

                    Abiturient abiturient = new Abiturient(lastName, scores, hasHonors, city, needsDorm);
                    multiList.insertAbiturient(abiturient);

                    System.out.println("Абитуриент добавлен!");
                    break;

                case "2":
                    multiList.displayMainList();
                    break;

                case "3":
                    multiList.displayByCriterion(1); /// Отличники
                    break;

                case "4":
                    multiList.displayByCriterion(2); /// Аттестат с отличием
                    break;

                case "5":
                    multiList.displayByCriterion(3); /// Иногородние
                    break;

                case "6":
                    multiList.displayByCriterion(4); /// Нуждающиеся в общежитии
                    break;

                case "7":
                    System.out.print("Фамилия абитуриента для удаления: ");
                    String delName = scanner.nextLine();
                    multiList.deleteAbiturient(delName);
                    break;

                case "8":
                    multiList.clearAll();
                    break;

                case "0":
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
