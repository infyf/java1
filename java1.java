import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        int[] array;
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Знайти унікальні елементи двох масивів");
            System.out.println("2. Знайти прості числа в масиві");
            System.out.println("3. Конвертувати число в шістнадцяткову систему");
            System.out.println("0. Вихід");

            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    array = getUniqueElements(array1, array2);
                    System.out.println("Унікальні елементи: " + Arrays.toString(array));
                    break;
                case 2:
                    int[] primesArray = {2, 5, 8, 11, 13, 15, 17, 20};
                    System.out.println("Прості числа в масиві:");
                    findPrimes(primesArray);
                    break;
                case 3:
                    System.out.print("Введіть ціле число для конвертації в шістнадцяткову систему: ");
                    int decimalNumber = scanner.nextInt();
                    String hexadecimal = convertToHexadecimal(decimalNumber);
                    System.out.println("Результат конвертації: " + hexadecimal);
                    break;
                case 0:
                    System.out.println("Програма завершила роботу.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    // Метод для знаходження унікальних елементів двох масивів (1 завдання)
    private static int[] getUniqueElements(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int resultIndex = 0;

        for (int element : array1) {
            if (!contains(result, resultIndex, element)) {
                result[resultIndex++] = element;
            }
        }

        for (int element : array2) {
            if (!contains(result, resultIndex, element)) {
                result[resultIndex++] = element;
            }
        }

        return Arrays.copyOf(result, resultIndex);
    }

    // Метод для знаходження простих чисел в масиві (2 завдання)
    private static void findPrimes(int[] array) {
        for (int number : array) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

    // Метод для перевірки чи число є простим (використовується в 2 завданні)
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Метод для конвертації числа в шістнадцяткову систему (3 завдання)
    private static String convertToHexadecimal(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder hexStringBuilder = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 16;
            char hexDigit = getHexDigit(remainder);
            hexStringBuilder.insert(0, hexDigit);
            decimal /= 16;
        }

        return hexStringBuilder.toString();
    }

    // Метод для отримання шістнадцяткового розряду (використовується в 3 завданні)
    private static char getHexDigit(int digit) {
        if (digit >= 0 && digit <= 9) {
            return (char) ('0' + digit);
        } else {
            return (char) ('A' + (digit - 10));
        }
    }

    // Метод для перевірки чи масив вже містить заданий елемент (використовується в 1 завданні)
    private static boolean contains(int[] array, int length, int bb) {
        for (int i = 0; i < length; i++) {
            if (array[i] == bb) {
                return true;
            }
        }
        return false;
    }
}
