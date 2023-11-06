package HomeWork2;

public class Discounts {
    //Цена одной рубашки без скидки .
    static final int priceShirt = 300;

    //Количество уже выбранных рубашек.
    static final int quantityShirt = 5;

    //Количество рубашек, которые надо купить, чтобы получить скидку.
    static final int discountShirt = 10;

    // Скидка.
    static final float percentDiscount = 10 / 100F;

    public static void main(String[] args) {
        // количество рубашек, которые надо добавить к купленным,чтобы получить скидку.
        int quantityShirt2 = discountShirt - quantityShirt;

        //Общая цена уже выбранных рубашек без скидки.
        int priceGeneral = priceShirt * quantityShirt;

        //общая цена рубашек (без скидки), которые надо докупить,чтобы получить скидку.
        int priceGeneralDontDiscount = quantityShirt2 * priceShirt;

        //цена всех рубашек со скидкой.
        float priceGeneralDiscount = (priceGeneralDontDiscount + priceGeneral) - ((priceGeneralDontDiscount + priceGeneral) * percentDiscount);

        //Цена одной рубашки со скидкой.
        float priceShirtDiscount = priceGeneralDiscount / discountShirt;

        //Количество сэкономленных денег, если рубашки куплены со скидкой.
        float savingMomey = priceGeneral + priceGeneralDontDiscount - priceGeneralDiscount;

        //Количество рубашек, которые можно купить с сэкономленных денег.
        float quantityShirt3 = savingMomey / priceShirt;

        System.out.println("Цена одной рубашки без скидки - " + priceShirt + " руб ");
        System.out.println("Рубашек выбрано в кол-ве - " + quantityShirt + " шт ");
        System.out.println("Чтобы получить скидку, нужно купить всего рубашек - " + discountShirt + " шт ");
        System.out.println("Предлагаемая скидка - " + (percentDiscount * 100) + " % ");
        System.out.println("Чтобы получить скидку, вам нужно добавить еще - " + quantityShirt2 + " шт ");
        System.out.println("Общая цена уже выбранных рубашек без скидки - " + priceGeneral + " руб ");
        System.out.println("Общая цена рубашек (без скидки), которые надо докупить,чтобы получить скидку - " + priceGeneralDontDiscount + " руб ");
        System.out.println("Цена всех рубашек со скидкой - " + priceGeneralDiscount + " руб ");
        System.out.println("Цена одной рубашки со скидкой - " + priceShirtDiscount + " руб ");
        System.out.println("Вы сэкономили - " + savingMomey + " руб ");
        System.out.println("Можете приобрести - " + quantityShirt3 + " рубашку ");
    }
}