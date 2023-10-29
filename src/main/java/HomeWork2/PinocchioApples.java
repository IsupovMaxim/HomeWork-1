package HomeWork2;
//Объявить целочисленную переменную, в которой количество яблок у Буратино

// Объявить целочисленную переменную,в которой записано,
// сколько яблок отобрал у него Карабас Барабас.

// Объявить целочисленную переменную, в которой записано,
// сколько яблок осталось у Буратино , после того, как Карабас Барабас отобрал у него яблоки.

public class PinocchioApples {
    static final int pinocchioApples = 10;
    static final int BarabasPickedApples = 5;

    public static void main(String[] args) {
         int PinocchioApplesLeft = pinocchioApples - BarabasPickedApples;

        System.out.println("у Буратино было яблок " + pinocchioApples);
        System.out.println("Карабас Барабас отобрал " + BarabasPickedApples + " яблок ");
        System.out.println("в итоге у Буратино осталось " + PinocchioApplesLeft + " яблок ");
    }


}
