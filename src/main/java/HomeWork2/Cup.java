package HomeWork2;
//Объявить целочисленную переменную, в которой будет объём стакана в милилитрах.

//Объявить переменную дробного типа, в которой будет указано на сколько процентов заполнен стакан.

//Объявить переменную в которой будет записано,сколько миллилитров воды в стакане,
//заполненном на столько процентов, сколько указано в предыдущей переменной.
//Значение переменной нужно рассчитывать исходя из значений предыдущих переменных.
public class Cup {
    static final int volumeCup = 500;
    static final float percent = 25/100f;

    public static void main(String[] args) {
        float waterCup = volumeCup * percent;

        System.out.println("Объём стакана " + volumeCup + "ml");
        System.out.println("Стакан заполнен на " + (percent*100) + "% водой");
        System.out.println("Воды в стакане " + waterCup + "ml");
    }
}