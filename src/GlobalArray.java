import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GlobalArray {
    Map<String, Array> globalArray = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);

    void addArray(String name, Array array) {
        globalArray.put(name, array);
    }

    Array setArray() {
        int index = 1;
        String[] names = new String[globalArray.size()];

        for (String name : globalArray.keySet()) {
            System.out.println(index + ". " + name);
            names[index - 1] = name;
            index++;
        }

        System.out.println("Введите номер хранилища для выбора:");
        int choice = scanner.nextInt();

        String selectedName = names[choice - 1];
        return globalArray.get(selectedName);
    }

    void menu() {
        while (true) {
            System.out.println("Выберите действие\n" +
                    "1. Добавить хранилище\n" +
                    "2. Выбрать хранилище\n" +
                    "0. Выход");
            int number = scanner.nextInt();

            if (number == 1) {
                System.out.println("Как желаете назвать хранилище?");
                String name = scanner.next();
                Array newArray = new Array();
                addArray(name, newArray);

            } else if (number == 2) {
                Array array = setArray();
                array.logic(this);

            } else if (number == 0) {
                break;
            }
        }
    }
}