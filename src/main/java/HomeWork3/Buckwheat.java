package HomeWork3;
// Программист Василий очень любит гречку. Поэтому он заготовил запас гречки на годы вперёд который хранится на складе.

// В его запасе 100 килограммов гречки. Хранение одного килограмма в месяц стоит 100 рублей.
// Плата вносится за месяц вперёд.
// За месяц Василий съедает примерно 6 килограммов гречки.

// Каждый месяц Василий платит за хранение остатка.
// То есть в первый месяц от заплатит за 100 килограммов, второй месяц за 94 и так далее, пока гречка не закончится.

// Написать программу, которая посчитает сколько денег нужно будет Василию,
// чтобы оплатить хранение гречки, до того момента, как он её съест.

import java.util.Scanner;

// УСЛОВИЕ!!! В начале задавать в переменной не сколько килограммов запас Василий,
// а в течение какого срока он хочет питаться гречкой и рассчитывать остальное, исходя из этого.
public class Buckwheat {
    static int totalBuckwheat = 100; //всего гречки (кг);
    static int buckwheatСonsumption = 6; //расход гречки в месяц (кг);
    static int buckwheatPrice = 100;//стоимость 1кг гречки;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите кол-во месяцев");

        int numbers = scanner.nextInt();
        int[] n = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            n[i] = buckwheatСonsumption + (buckwheatСonsumption * i);
        }
        for (int i = 0; i < numbers; i++) {
            System.out.println(n[i] * buckwheatPrice);
        }
        int sum = 0;
        for (int i = 0; i < numbers; i++) {
            sum += n[i];
            System.out.println();
            System.out.println(sum * buckwheatPrice);
        }
    }
}
//    static int totalBuckwheat = 100; //всего гречки (кг);
//    static int buckwheatСonsumption = 6; //расход гречки в месяц (кг);
//    static int buckwheatPrice = 100;//стоимость 1кг гречки;
//    static int n = totalBuckwheat / buckwheatСonsumption;//вермя хранения гречки(месяц).
//    static int storagePrice;//общая стоимость хранения гречки
//
//    public static void main(String[] args) {
//        for (int i = 0; i <= n; i++) { //перебираем значения, где i - представляет текущий период.
//            int price = (totalBuckwheat - i * buckwheatСonsumption) * buckwheatPrice;
//            storagePrice += price;// складываем полученные периоды и присваиваем к общей стоимости.
//        }
//        System.out.println(storagePrice);
//    }
//}