import java.util.Scanner;

public class Array {

    Scanner scanner = new Scanner(System.in);
    int[] allCount = new int[10];
    int count = 0;

    void addElement(int element) {
        if (count < allCount.length) {
            allCount[count] = element;
            count++;
        } else {
            int[] newAllCount = new int[allCount.length * 2];
            for (int i = 0; i < allCount.length; i++) {
                newAllCount[i] = allCount[i];
            }
            allCount = newAllCount;
            allCount[count] = element;
            count++;
        }
    }

    int getInfo(int index) {
        if (index >= 0 && index < count) {
            return allCount[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
    }

    void getAllElements() {
        for (int i = 0; i < allCount.length; i++) {
            System.out.println(allCount[i]);
        }
    }

    void deleteElement(int number) {
        for (int i = 0; i < allCount.length; i++) {
            if (allCount[i] == number) {
                for (int j = i; j < allCount.length - 1; j++) {
                    allCount[j] = allCount[j + 1];
                }
            }
        }
    }

    void deleteAllElements() {
        allCount = new int[10];
        count = 0;
    }

    void removeElementOfName(int count, int newCount) {
        for (int i = 0; i < allCount.length; i++) {
            if (allCount[i] == count) {
                allCount[i] = newCount;
                System.out.println("Значение: " + allCount[i] + " Успешно заменено на значение: " + newCount);
            }
        }
    }


    void logic () {
        System.out.println("Какое действие хотите совершить?\n" +
                "1. Показать элементы хранящиеся в хранилище\n" +
                "2. Добавить элемент\n" +
                "3. Удалить элемент\n" +
                "4. Заменить элемент\n" +
                "5. Полностью очистить хранилище");
        int number = scanner.nextInt();

        if(number == 1) {
            System.out.println("В хранилще хранятся:");
            getAllElements();
            logic();

        } else if(number == 2) {
            System.out.println("Какое значение требуется добавить?");
            int count = scanner.nextInt();
            addElement(count);
            System.out.println("Элемент успешно добавлен");
            logic();

        } else if (number == 3) {
            System.out.println("Какое значение желаете удалить?");
            int count = scanner.nextInt();
            deleteElement(count);
            System.out.println("Элемент успешно удален");
            logic();

        } else if(number == 4) {
            System.out.println("Какое значение желаете заменить?");
            int count = scanner.nextInt();
            System.out.println("На Какое новое значение желаете заменить?");
            int newCount = scanner.nextInt();
            removeElementOfName(count, newCount);
            System.out.println("Элемент успешно заменен");
            logic();

        } else if(number == 5) {
            deleteAllElements();
            System.out.println("Хранилище успешно очищено");
            logic();
        }
    }

}
