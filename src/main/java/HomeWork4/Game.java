package HomeWork4;
//Правила игры: дана последовательность целых чисел. Числа могут быть от 0 до 9
//        Игрок может вычеркнуть (убрать из последовательности) два рядом стоящих числа, если они одинаковы или в сумме дают 9.
//        За каждое вычеркивание игрок получает 1 очко
//        Игра заканчивается, когда не останется возможных комбинаций
//
//        Необходимо написать метод, который принимает последовательность чисел (List<Integer>) и возвращает результирующий счет (int)
//
//        Например:
//        Дана последовательность: 1 2 3 4 8 1 9 0 5 3
//        Можем вычеркнуть 1 2 3 4 [8 1] 9 0 5 3, оставшаяся последовательность: 1 2 3 4 9 0 5 3
//        Можем вычеркнуть 1 2 3 4 [9 0] 5 3, оставшаяся последовательность: 1 2 3 4 5 3
//        Можем вычеркнуть 1 2 3 [4 5] 3, оставшаяся последовательность: 1 2 3 3
//        Можем вычеркнуть 1 2 [3 3], оставшаяся последовательность: 1 2
//
//        Вычеркивали 4 раза, значит результирующий счет = 4
//        Примечание: не всегда нужно всю логику хранить в одном методе, можно части кода выносить в отдельные, чтобы потом их переиспользовать

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static void main(String[] args) {

        ArrayList<Integer> ArrayList = new ArrayList<>(Arrays.asList(6, 8, 0, 5, 5, 1, 8, 4, 7, 2));

        System.out.println("Наш массив: " + ArrayList);

        int result = removeArrayNumbers(ArrayList);

        System.out.println("Результирующий счёт = " + result);
    }
    private static int removeArrayNumbers(ArrayList<Integer> ArrayList) {
        int counter = 0;
        int i = 0;

        while (i < ArrayList.size() - 1) {
            int value = ArrayList.get(i);
            int value2 = ArrayList.get(i + 1);
            int sum = value + value2;

            if (sum == 9 || value == value2) {
                System.out.println("Сумма чисел " + value + " и " + value2 + " равна 9 или числа равны между собой - удаляются");
                ArrayList.remove(i + 1);
                ArrayList.remove(i);
                counter++;
                i -= 2;
                if (i < 0) i = 0;
            } else {
                i++;
            }
        }
        return counter;
    }
}