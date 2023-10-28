package HomeWork1;
/**
 *  Создать метод который будет считать площадь круга c произвольным радиусом
 */

public class AreaCircle {
    public static void main(String[] args) {
        int radiusCircle = 10;
        double areaCircle = Math.PI * radiusCircle * radiusCircle;

        System.out.println("Площадь круга = " + areaCircle);
    }
}
