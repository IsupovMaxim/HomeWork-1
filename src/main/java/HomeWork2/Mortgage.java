package HomeWork2;

//Объявить целочисленную переменную, в которой стоимость квартиры.

//Объявить дробную переменную, в которой процент первоначального взноса по ипотеке.

//Объявить переменную, в которой сумма первоначального взноса.
//Значение переменной нужно рассчитывать исходя из значений предыдущих переменных


public class Mortgage {
    static final int apartmentPrice= 7500000;
    static final float downPayment = 30/100F;

    public static void main(String[] args) {
        float DownPaymentPrice = apartmentPrice * downPayment;

        System.out.println("Стоимость квартиры " + apartmentPrice + " руб ");
        System.out.println("Первоначальный взноса по - " + (downPayment*100) + " % ");
        System.out.println("Cумма первоначального взноса - " + DownPaymentPrice + " руб ");

    }

}
