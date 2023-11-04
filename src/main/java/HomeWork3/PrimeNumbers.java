package HomeWork3;

import java.util.Scanner;
public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, чтобы узнать каким оно является - состовным или простым.");
        int x = scanner.nextInt();
        for (int i = 2; i*i<= x; i++){
            if(x % i == 0){
                System.out.println("составное");
                return;
            }
        }
        System.out.println("простое");
    }
}