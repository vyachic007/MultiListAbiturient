package util;

public class Messages {
    // Меню
    public static final String MENU_TITLE = "=== Меню ===";
    public static final String MENU_ADD = "1) Ввести абитуриента";
    public static final String MENU_SHOW_ALL = "2) Показать всех абитуриентов";
    public static final String MENU_SHOW_EXCELLENT = "3) Показать отличников";
    public static final String MENU_SHOW_HONORS = "4) Показать с аттестатом с отличием";
    public static final String MENU_SHOW_OUT_OF_TOWN = "5) Показать иногородних";
    public static final String MENU_SHOW_DORM = "6) Показать нуждающихся в общежитии";
    public static final String MENU_DELETE = "7) Удалить абитуриента";
    public static final String MENU_CLEAR = "8) Очистить все списки";
    public static final String MENU_EXIT = "0) Выход";
    public static final String MENU_PROMPT = "Выберите пункт: ";

    // Ввод данных
    public static final String PROMPT_LAST_NAME = "Фамилия: ";
    public static final String PROMPT_SCORE = "Оценка по экзамену %d: ";
    public static final String PROMPT_HONORS = "Аттестат с отличием (Д/Н): ";
    public static final String PROMPT_CITY = "Город проживания: ";
    public static final String PROMPT_DORM = "Нуждается в общежитии (Д/Н): ";

    // Результаты операций
    public static final String SUCCESS_ADD = "Абитуриент добавлен!";
    public static final String SUCCESS_DELETE = "Абитуриент '%s' удалён из всех списков.";
    public static final String SUCCESS_CLEAR = "Все списки очищены.";
    public static final String SUCCESS_EXIT = "Выход из программы...";

    // Ошибки
    public static final String ERROR_NOT_FOUND = "Абитуриент с фамилией '%s' не найден.";
    public static final String ERROR_INVALID_CHOICE = "Некорректный выбор. Попробуйте снова.";
    public static final String ERROR_INVALID_INDEX = "Некорректный индекс списка.";

    // Списки
    public static final String LIST_HEADER = "=== Список: %s ===";
    public static final String LIST_ITEM = "%d) %s";
    public static final String LIST_FOOTER = "=============================";
}
