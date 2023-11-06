package HomeWork3;

import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, чтобы узнать каким оно является - составным или простым.");
        int x = scanner.nextInt();
        if ((x == 0) || (x == 1)) {
            System.out.println("ни то ни другое");
            return;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                System.out.println("составное");
                return;
            }
        }
        System.out.println("простое");
    }
}