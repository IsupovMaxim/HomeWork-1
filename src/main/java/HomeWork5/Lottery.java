package HomeWork5;
//Сыграем в лотерею, реализовать механизм который будет перемешивать "Шарики с цифрами"
// - Заполнить массив 100 числовыми значениями
// - Перемешать массив
// - Вывести в консоль первые 10 значений

import java.util.ArrayList;
import java.util.Collections;

public class Lottery {
    public static void main(String[] args) {

        ArrayList<Integer> balls = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        for (int i = 1; i < 10; i++) {
            System.out.println(balls.get(i));
        }
    }
}