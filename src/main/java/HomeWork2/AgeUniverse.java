package HomeWork2;
//Объявить целочисленную переменную, в которой возраст Вселенной в годах (13 миллиардов лет).

//Объявить целочисленную переменную, в которой возраст человека, как вида (100 тысяч лет).

//Объявить целочисленную переменную, в которой записано, во сколько раз Вселенная старше людей.
//Значение переменной нужно рассчитывать исходя из значений предыдущих переменных.

public class AgeUniverse {
    static final long ageUniverse = 13000000000L;
    static final int agePerson = 100000;

    public static void main(String[] args) {
        long relativity = ageUniverse / agePerson;

        System.out.println("возраст Вселенной равен " + (ageUniverse/1000000000) + " миллиардов лет");
        System.out.println("возраст человека равен " + (agePerson/1000) + " тысяч лет");
        System.out.println("Вселенная старше людей в " + relativity + " раз");

    }
}
