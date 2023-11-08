package HomeWork4;
//Написать метод, который принимает на вход имя человека и количество его яблок
// и выводит в консоль текст "{Имя человека} хранит у себя {количество яблок}" по
// правилам склонения русского языка.

public class Apples {
    public static void main(String[] args) {
        int apples = 51;
        String name = "Иван";
        printAppleCount(name + " хранит у себя ", apples);
    }
    public static void printAppleCount(String name, int numberOfApples) {

        if (numberOfApples == 0) {
             name += numberOfApples + " яблок";
        } else if (numberOfApples == 1) {
            name += numberOfApples + "яблоко";
        } else if (numberOfApples >= 2 && numberOfApples <= 4) { // числа от 2 до 4
            name += numberOfApples + " яблока";
        } else if (numberOfApples >= 5 && numberOfApples <= 20) { // числа от 5 до 20
            name += numberOfApples + " яблок";
        } else if (numberOfApples % 10 == 1) { // числа 21, 31, 41 ...
            name += numberOfApples + " яблоко";
        } else if (numberOfApples % 10 >= 2 && numberOfApples % 10 <= 4) { // числа от 2 до 4 в десятках
            name += numberOfApples + " яблока";
        } else {
            name += numberOfApples + " яблок";
        }
         System.out.println(name);
    }
}