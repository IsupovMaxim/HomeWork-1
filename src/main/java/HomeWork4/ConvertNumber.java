package HomeWork4;

import java.util.Scanner;

//Дан метод, необходимо переписать его, используя тернарные операторы.
//При необходимости, метод можно переименовать.
//        String result;
//        if (number > 0) {
//            if (number % 7 < 4) {
//                result = "positive - m";
//            } else {
//                result = "positive  p";
//            }
//        } else {
//            if (number == 0) {
//                result = "zero";
//            } else if (number % 7 > -4) {
//                result = "negative - m";
//            } else {
//                result = "negative - p";
//            }
//        }
//        return result;
//    }
//}
public class ConvertNumber {
    public static void main(String[] args) {
        for ( int i = -5; i < 6; i++){
            System.out.println(convertNumber(i));
        }
    }
    public static String convertNumber(int number) {
        String result = (number > 0)
                ? (number % 7 < 4 ? "positive - m" : "positive - p")
                : (number == 0)
                ? "zero" : (number % 7 > -4 ? "negative - m" : "negative - p");
        return result;
    }
}