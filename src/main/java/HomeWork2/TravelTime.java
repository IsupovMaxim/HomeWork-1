package HomeWork2;
//Объявить целочисленную переменную, в которой расстояние в километрах от дома до офиса.

//Объявить дробную переменную, в которой средняя скорость такси.

//Объявить дробную переменную, в которой время за которое тестировщик добирается от дома до офиса.
//Для вычисления времени нужно поделить расстояние на скорость.

//Объявить дробную переменную, в которой коэффициент замедления транспорта вечером.

//Объявить дробную переменную, в которой время, за которое тестировщик добирается на такси с работы домой.
//Для вычисления этого времени нужно умножить время за которое тестировщик обычно добирается от дома до офиса на коэффициент.
public class TravelTime {
    static final int route = 20;
    static final float speed = 65.5F;
    static final float coefficient = 1.8F;

    public static void main(String[] args) {
        float travelTime1 = route / speed * 60; // время в минутах
        float travelTime2 = travelTime1 * coefficient;

        System.out.println("Расстояние от дома до работы - " + route + " км ");
        System.out.println("Средняя скорость такси - " + speed + " км/ч ");
        System.out.println("Коэффициент замедления транспорта вечером " + coefficient);
        System.out.println("Время в пути без коофициента замедления - " + travelTime1 + " минут ");
        System.out.println("Время в пути с коофициентом - " + travelTime2 + " минуты ");
    }
}
