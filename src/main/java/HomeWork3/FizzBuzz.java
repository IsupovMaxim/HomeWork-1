package HomeWork3;

//Написать программу, которая для каждой цифры в диапазоне от 0 до 100 печатает следующее:
//Если цифра делится нацело на три - печатает fizz
//Если цифра делится нацело не пять - печатает buzz
//Если цифра делится и на три и на пять - печатает FizzBuzz
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + " FizzBizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " buzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}