import java.util.ArrayList;
import java.util.Scanner;

public class Array {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> list = new ArrayList<>();

//  Сеттеры класса
    public int getSize() {
        return list.size();
    }

    public ArrayList<String> getList() {
        return list;
    }

    // Методы класса
    void addElement() {
        System.out.println("Введите числа через пробел или запятую:");
        String input = scanner.nextLine();
        String[] parts = input.split("[,\\s]+");
        for (String part : parts) {
            list.add(part);
        }
    }

    void getAllElements() {
        if (list.isEmpty()) {
            System.out.println("Хранилище пустое.");
        } else {
            System.out.println("Элементы хранилища:");
            for (String num : list) {
                System.out.println(num);
            }
        }
    }

    void deleteElement(String name) {
        boolean removed = list.removeIf(n -> n.equals(name));
        if (removed) {
            System.out.println("Удалены все элементы со значением: " + name);
        } else {
            System.out.println("Элемент " + name + " не найден.");
        }
    }

    void deleteAllElements() {
        list.clear();
        System.out.println("Хранилище очищено.");
    }


    void logic(GlobalArray manager) {
        while (true) {
            System.out.println("""
                    Какое действие хотите совершить?
                    1. Показать элементы
                    2. Добавить элемент
                    3. Удалить элемент
                    4. Очистить хранилище
                    5. Вернуться к выбору хранилища
                    """);

            int number = Integer.parseInt(scanner.nextLine());

            switch (number) {
                case 1 -> {
                    getAllElements();
                    System.out.println("В массиве лежит: " + list.size() + " элементов");
                }
                case 2 -> addElement();
                case 3 -> {
                    System.out.println("Введите элемент для удаления:");
                    deleteElement(scanner.nextLine());
                }
                case 4 -> deleteAllElements();
                case 5 -> {
                    manager.menu();
                    return; // чтобы выйти из цикла
                }
                default -> System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }
}

//git add . && git commit -m "реализация хранилища" && git push&&