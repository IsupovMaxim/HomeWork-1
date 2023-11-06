package HomeWork3;

//Вывести в консоль таблицу умножения используя цикл for
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int k = 1; k <= 10; k++) {
                System.out.printf("%5d", i * k);
            }
            System.out.println();
        }
    }
}