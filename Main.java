import java.util.Arrays;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public double fraction (double x) {
        return x - (int) x;
    }

    public int charToNum (char x) {
        return x == 0 ? 48 : (int) x;
    }

    public boolean is2Digits (int x) {
        return Math.abs(x) >= 10 && Math.abs(x) <= 99;
    }

    public boolean isInRange (int a, int b, int num) {
        return num >= a && num <= b;
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    public int abs (int x) {
        return Math.abs(x);
    }

    public boolean is35 (int x) {
        return (x % 5 == 0 || x % 3 == 0) && !(x % 5 == 0 && x % 3 == 0);
    }

    public int max3 (int x, int y, int z) {
        if (x >= y && x >= z) return x;
        if (y >= z) return y;
        return z;
    }

    public int sum2 (int x, int y) {
        if ((x + y) >= 10 && (x + y) <= 19) return 20;
        return x + y;
    }

    public String day (int x) {
        return switch (x) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "Ошибка! Это не день недели";
        };
    }

    public String listNums (int x) {
        StringBuilder str = new StringBuilder("0");
        for (int i = 1; i <= x; i++) str.append(" ").append(i);
        return str.toString();
    }

    public String chet (int x) {
        StringBuilder str = new StringBuilder("0");
        for (int i = 2; i <= x; i += 2) str.append(" ").append(i);
        return str.toString();
    }

    public int numLen (long x) {
        int count = 1;
        while (x >= 10) {
            x /= 10;
            count++;
        }
        return count;
    }

    public void square (int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                IO.print("*");
            }
            IO.println();
        }
    }

    public void rightTriangle (int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (j >= x - i - 1) IO.print("*");
                else IO.print(" ");
            }
            IO.println();
        }
    }

    public int findFirst (int[] arr, int x) {
        for (int i = 0; i < arr.length; i++)
            if (x == arr[i]) return i;
        return -1;
    }

    public int maxAbs (int[] arr) {
        int max_val = arr[0];
        for (int n: arr)
            if (Math.abs(n) > Math.abs(max_val)) max_val = n;
        return max_val;
    }

    public int[] add (int[] arr, int[] ins, int pos) {
        int[] new_arr = new int[arr.length + ins.length];
        boolean pasted = false;
        for (int i = 0; i < new_arr.length; i++) {
            if (i >= pos && i < pos + ins.length) {
                new_arr[i] = ins[i - pos];
                pasted = true;
            } else if (pasted)
                new_arr[i] = arr[i - ins.length];
            else
                new_arr[i] = arr[i];
        }
        return new_arr;
    }

    public int[] reverseBack (int[] arr) {
        int[] rev_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            rev_arr[i] = arr[arr.length - 1 - i];
        return rev_arr;
    }

    public int[] findAll (int[] arr, int x) {
        int count = 0;
        for (int n: arr)
            if (x == n) count++;

        int[] indexes = new int[count];
        int i = 0;
        for (int j = 0; j < arr.length; j++)
            if (x == arr[j]) {
                indexes[i] = j;
                i++;
            }
        return indexes;
    }


    private int getInt() {
        IO.print("Введите целое число: ");
        while (!scanner.hasNextInt()) {
            IO.println("Ошибка! Ожидалось целое число");
            scanner.next();
            IO.print("Введите целое число: ");
        }
        return scanner.nextInt();
    }

    private int getInt(int min_val, int max_val, boolean have_min, boolean have_max) {
        while (true) {
            int num;
            IO.print("Введите целое число: ");
            if (!scanner.hasNextInt()) {
                IO.println("Ошибка! Ожидалось целое число");
                scanner.next();
            } else {
                num = scanner.nextInt();
                if (num < min_val && have_min)
                    IO.println("Ошибка! Ожидалось число, большее или равное " + min_val);
                else if (num > max_val && have_max)
                    IO.println("Ошибка! Ожидалось число, меньшее или равное " + max_val);
                else return num;
            }
        }
    }

    private int getInt(int min_val, int max_val, boolean have_min, boolean have_max, String message) {
        while (true) {
            int num;
            IO.print(message);
            if (!scanner.hasNextInt()) {
                IO.println("Ошибка! Ожидалось целое число");
                scanner.next();
            } else {
                num = scanner.nextInt();
                if (num < min_val && have_min)
                    IO.println("Ошибка! Ожидалось число, большее или равное " + min_val);
                else if (num > max_val && have_max)
                    IO.println("Ошибка! Ожидалось число, меньшее или равное " + max_val);
                else return num;
            }
        }
    }

    private int getInt(String message) {
        IO.print(message);
        while (!scanner.hasNextInt()) {
            IO.println("Ошибка! Ожидалось целое число");
            scanner.next();
            IO.print(message);
        }
        return scanner.nextInt();
    }

    private double getDouble() {
        IO.print("Введите число: ");
        while (!scanner.hasNextDouble()) {
            IO.println("Ошибка! Ожидалось число");
            scanner.next();
            IO.print("Введите число: ");
        }
        return scanner.nextDouble();
    }

    private long getLong() {
        IO.print("Введите число: ");
        while (!scanner.hasNextLong()) {
            IO.println("Ошибка! Ожидалось число");
            scanner.next();
            IO.print("Введите число: ");
        }
        return scanner.nextLong();
    }

    private char getChar() {
        while (true) {
            IO.print("Введите символ: ");
            if (!scanner.hasNextInt()) {
                IO.println("Ошибка! Ожидалась цифра");
                scanner.next();
            } else {
                int a = scanner.nextInt();
                if (a >= 0 && a <= 9) return (char) a;
                IO.println("Ошибка! Ожидалась цифра");
            }
        }
    }

    private String bool_to_ans(boolean value, String true_ans, String false_ans) {
        return value ? true_ans : false_ans;
    }

    private String bool_to_ans(boolean value) {
        return value ? "да" : "нет";
    }

    private int[] getArray() {
        int len = getInt(1, 0, true, false, "Введите кол-во чисел в массиве: ");
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = getInt("Введите число №" + (i + 1) + ": ");
        return arr;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        int choice = -1;
        while (choice != 0) {
            IO.println();
            IO.println("Категории: ");
            IO.println("1 - Методы");
            IO.println("2 - Условия");
            IO.println("3 - Циклы");
            IO.println("4 - Массивы");
            IO.println("Выберите 0 для выхода");
            choice = obj.getInt(0, 4, true, true, "Введите номер категории: ");

            switch (choice) {
                case 1 :
                    int choice_1 = -1;
                    while (choice_1 != 0) {
                        IO.println();
                        IO.println("Выберите задачу: ");
                        IO.println("1 - Дробная часть");
                        IO.println("2 - Букву в число");
                        IO.println("3 - Двузначное");
                        IO.println("4 - Диапазон");
                        IO.println("5 - Равенство");
                        IO.println("Выберите 0, чтобы вернуться");
                        choice_1 = obj.getInt(0, 5, true, true, "Введите номер задачи: ");

                        IO.println();
                        switch (choice_1) {
                            case 1 :
                                IO.println("Вывести дробную часть");
                                IO.println("Дробная часть: " + obj.fraction(obj.getDouble()));
                                break;
                            case 2 :
                                IO.println("Вывести код символа");
                                IO.println("Код символа: " + obj.charToNum(obj.getChar()));
                                break;
                            case 3 :
                                IO.println("Проверить число на двузначность");
                                IO.println("Это число двузначно: " + obj.bool_to_ans(obj.is2Digits(obj.getInt())));
                                break;
                            case 4 : {
                                IO.println("Проверить, входит ли число в диапазон");
                                int a = obj.getInt("Введите нижнюю границу диапазона: ");
                                int b = obj.getInt(a, 0, true, false, "Введите верхнюю границу диапазона: ");
                                int num = obj.getInt();
                                IO.println("Это число входит в диапазон: " + obj.bool_to_ans(obj.isInRange(a, b, num)));
                                break;
                            }
                            case 5 : {
                                IO.println("Проверить 3 числа на равенство");
                                int a = obj.getInt("Введите число 1: ");
                                int b = obj.getInt("Введите число 2: ");
                                int c = obj.getInt("Введите число 3: ");
                                IO.println("Эти числа равны: " + obj.bool_to_ans(obj.isEqual(a, b, c)));
                                break;
                            }
                            case 0 :
                                break;
                        }

                    }
                    break;
                case 2 :
                    int choice_2 = -1;
                    while (choice_2 != 0) {
                        IO.println();
                        IO.println("Выберите задачу: ");
                        IO.println("1 - Модуль числа");
                        IO.println("2 - Тридцать пять");
                        IO.println("3 - Тройной максимум");
                        IO.println("4 - Двойная сумма");
                        IO.println("5 - День недели");
                        IO.println("Выберите 0, чтобы вернуться");
                        choice_2 = obj.getInt(0, 5, true, true, "Введите номер задачи: ");

                        IO.println();
                        switch (choice_2) {
                            case 1 :
                                IO.println("Найти модуль числа");
                                IO.println("Модуль числа: " + obj.abs(obj.getInt()));
                                break;
                            case 2 :
                                IO.println("Проверить, кратно ли число 3 или 5 и не кратно 15");
                                IO.println("Ответ: " + obj.bool_to_ans(obj.is35(obj.getInt())));
                                break;
                            case 3 :
                                IO.println("Найти максимальное из 3 чисел");
                                int x = obj.getInt("Введите число 1: ");
                                int y = obj.getInt("Введите число 2: ");
                                int z = obj.getInt("Введите число 3: ");
                                IO.println("Максимальное из них: " + obj.max3(x, y, z));
                                break;
                            case 4 :
                                IO.println("Вывести сумму чисел. Если она в промежутке от 10 до 19, то вывести 20");
                                int a = obj.getInt("Введите первое число: ");
                                int b = obj.getInt("Введите второе число: ");
                                IO.println("Ответ: " + obj.sum2(a, b));
                                break;
                            case 5 : {
                                IO.println("Вывести название дня недели, соответствующего введённому номеру");
                                IO.println("Название: " + obj.day(obj.getInt("Введите номер дня недели: ")));
                                break;
                            }
                            case 0 :
                                break;
                        }

                    }
                    break;
                case 3 :
                    int choice_3 = -1;
                    while (choice_3 != 0) {
                        IO.println();
                        IO.println("Выберите задачу: ");
                        IO.println("1 - Числа подряд");
                        IO.println("2 - Четные числа");
                        IO.println("3 - Длина числа");
                        IO.println("4 - Квадрат");
                        IO.println("5 - Правый треугольник");
                        IO.println("Выберите 0, чтобы вернуться");
                        choice_3 = obj.getInt(0, 5, true, true, "Введите номер задачи: ");

                        IO.println();
                        switch (choice_3) {
                            case 1 :
                                IO.println("Вывести строку из чисел от 0 до N");
                                IO.println(obj.listNums(obj.getInt("Введите N: ")));
                                break;
                            case 2 :
                                IO.println("Вывести строку из чётных чисел от 0 до N");
                                IO.println(obj.chet(obj.getInt("Введите N: ")));
                                break;
                            case 3 :
                                IO.println("Вывести длину числа");
                                IO.println("Длина числа: " + obj.numLen(obj.getLong()));
                                break;
                            case 4 :
                                IO.println("Вывести квадрат из '*' с длиной стороны N");
                                obj.square(obj.getInt("Введите N: "));
                                break;
                            case 5 :
                                IO.println("Вывести треугольник из '*' с длиной катетов N. Катеты - нижняя и правая сторона");
                                obj.rightTriangle(obj.getInt("Введите N: "));
                                break;
                            case 0 :
                                break;
                        }

                    }
                    break;
                case 4 :
                    int choice_4 = -1;
                    while (choice_4 != 0) {
                        IO.println();
                        IO.println("Выберите задачу: ");
                        IO.println("1 - Поиск первого значения");
                        IO.println("2 - Поиск максимального");
                        IO.println("3 - Добавление массива в массив");
                        IO.println("4 - Возвратный реверс");
                        IO.println("5 - Все вхождения");
                        IO.println("Выберите 0, чтобы вернуться");
                        choice_4 = obj.getInt(0, 5, true, true, "Введите номер задачи: ");

                        IO.println();
                        switch (choice_4) {
                            case 1 : {
                                IO.println("Найти первое вхождение заданного числа");
                                int[] arr = obj.getArray();
                                int a = obj.getInt("Введите число для поиска: ");
                                IO.println("Введённый массив: " + Arrays.toString(arr) + "; искать: " + a);
                                IO.println("Индекс первого искомого элемента: " + obj.findFirst(arr, a));

                                break;
                            }
                            case 2 : {
                                IO.println("Найти максимальное по модулю число в массиве");
                                int[] arr = obj.getArray();
                                IO.println("Введённый массив: " + Arrays.toString(arr));
                                IO.println("Максимум по модулю: " + obj.maxAbs(arr));

                                break;
                            }
                            case 3 : {
                                IO.println("Добавить один массив в другой перед заданным индексом");
                                IO.println("Введите основной массив:");
                                int[] arr_a = obj.getArray();
                                IO.println("Введите добавочный массив:");
                                int[] arr_b = obj.getArray();
                                int ind = obj.getInt(0, arr_a.length, true, true, "Введите индекс для добавления: ");
                                IO.println("Основной массив: " + Arrays.toString(arr_a));
                                IO.println("Добавочный массив: " + Arrays.toString(arr_b));
                                IO.println("Точка добавления: " + ind);
                                IO.println("Результат объединения: " + Arrays.toString(obj.add(arr_a, arr_b, ind)));

                                break;
                            }
                            case 4 : {
                                IO.println("Создать массив, инвертированный введённому");
                                int[] arr = obj.getArray();
                                IO.println("Введённый массив: " + Arrays.toString(arr));
                                IO.println("Инвертированный массив: " + Arrays.toString(obj.reverseBack(arr)));

                                break;
                            }
                            case 5 : {
                                IO.println("Найти все вхождения введённого элемента");
                                int[] arr = obj.getArray();
                                int a = obj.getInt("Введите число для поиска: ");
                                IO.println("Введённый массив: " + Arrays.toString(arr) + "; искать: " + a);
                                IO.println("Индексы всех искомых элементов: " + Arrays.toString(obj.findAll(arr, a)));

                                break;
                            }
                            case 0 :
                                break;
                        }

                    }
                    break;
                case 0 :
                    IO.println("Работа завершена.");
                    break;
            }

        }
    }
}